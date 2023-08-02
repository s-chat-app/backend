package indi.midreamsheep.schatapp.backend.netty;

import indi.midreamsheep.schatapp.backend.chat.ChatHandlerMapper;
import indi.midreamsheep.schatapp.backend.chat.ChatMessage;
import indi.midreamsheep.schatapp.backend.chat.message.ChatType;
import indi.midreamsheep.schatapp.backend.protocol.Result;
import indi.midreamsheep.schatapp.backend.protocol.ResultEnum;
import indi.midreamsheep.schatapp.backend.api.scan.inter.ChatHandlerInter;
import indi.midreamsheep.schatapp.backend.until.json.JsonUtil;
import io.netty.channel.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;



@Component
@ChannelHandler.Sharable
@Slf4j
public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, String msg) {
        ChatMessage message;
        try {
            message = JsonUtil.getJsonToBean(msg, ChatMessage.class);
            message.check();
        } catch (Exception e) {
            log.error("messageReceived error", e);
            ctx.writeAndFlush(JsonUtil.getBeanToJson(new Result(ResultEnum.ERROR, "message structure error")));
            return;
        }

        ChatHandlerInter chatHandlerInter = ChatHandlerMapper.getMapper(ChatType.valueOf(message.getType())).get(message.getMapping());
        if (chatHandlerInter != null) {
            ctx.writeAndFlush(JsonUtil.getBeanToJson(chatHandlerInter.handle(ctx, message.getData())));
            return;
        }
        ctx.writeAndFlush(JsonUtil.getBeanToJson(new Result(ResultEnum.ERROR,"no such mapping in this type:"+message.getType()+" in this mapping:"+message.getMapping())));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        //关闭通道
        ctx.close();
    }
}
