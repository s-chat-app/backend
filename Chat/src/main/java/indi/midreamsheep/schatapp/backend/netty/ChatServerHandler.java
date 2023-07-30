package indi.midreamsheep.schatapp.backend.netty;

import indi.midreamsheep.schatapp.backend.chat.ChatHandlerMapper;
import indi.midreamsheep.schatapp.backend.entity.message.ChatType;
import indi.midreamsheep.schatapp.backend.entity.message.MessageEntity;
import indi.midreamsheep.schatapp.backend.scan.inter.ChatHandlerInter;
import indi.midreamsheep.schatapp.backend.until.json.JsonUtil;
import io.netty.channel.*;
import org.springframework.stereotype.Component;

@Component
@ChannelHandler.Sharable
public class ChatServerHandler extends SimpleChannelInboundHandler<String> {


    @Override
    protected void messageReceived(ChannelHandlerContext ctx, String msg) {
        MessageEntity message = JsonUtil.getJsonToBean(msg, MessageEntity.class);
        System.out.println(message);
        ChatHandlerInter chatHandlerInter = ChatHandlerMapper.getMapper(ChatType.valueOf(message.getChatType())).get(message.getMessageMapping());
        if (chatHandlerInter != null) {
            chatHandlerInter.handle(ctx, message);
            return;
        }
        ctx.writeAndFlush("error");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //关闭通道
        ctx.close();
    }
}
