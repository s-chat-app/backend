package indi.midreamsheep.schatapp.backend.netty;

import indi.midreamsheep.schatapp.backend.api.chat.handler.annotation.ChatHandler;
import indi.midreamsheep.schatapp.backend.chat.ChatHandlerMapper;
import indi.midreamsheep.schatapp.backend.chat.ChatMessage;
import indi.midreamsheep.schatapp.backend.chat.message.ChatType;
import indi.midreamsheep.schatapp.backend.protocol.ChatTransmission;
import indi.midreamsheep.schatapp.backend.protocol.TransmissionEnum;
import indi.midreamsheep.schatapp.backend.api.scan.inter.ChatHandlerInter;
import indi.midreamsheep.schatapp.backend.util.json.JsonUtil;
import indi.midreamsheep.schatapp.backend.util.response.Result;
import indi.midreamsheep.schatapp.backend.util.response.ResultEnum;
import io.netty.channel.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * netty消息接受分发处理器
 * 通过注解{@link ChatHandler}指定消息类型和消息映射并注册到{@link ChatHandlerMapper}中由当前对象处理
 * 收到消息后会先进行json解析，解析失败则返回错误消息
 * 解析成功后会根据消息类型和消息映射从{@link ChatHandlerMapper}中获取对应的处理器并进行处理
 * 处理器注册方式见{@link ChatHandler}
 * @see ChatHandlerInter
 * */
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
            //ctx.writeAndFlush(new ChatTransmission(-1, TransmissionEnum.HANDLER_EXCEPTION, new Result(ResultEnum.ERROR, "json parse error")).toString());
            return;
        }
        ChatHandlerInter chatHandlerInter = ChatHandlerMapper.getMapper(ChatType.valueOf(message.getType())).get(message.getMapping());
        if (chatHandlerInter != null) {
            ctx.writeAndFlush(JsonUtil.getBeanToJson(chatHandlerInter.handle(ctx, message)));
            return;
        }
        //ctx.writeAndFlush(new ChatTransmission(message.getId(), TransmissionEnum.HANDLER_EXCEPTION, new Result(ResultEnum.ERROR, "no handler found")).toString());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        //关闭通道
        ctx.close();
    }
}
