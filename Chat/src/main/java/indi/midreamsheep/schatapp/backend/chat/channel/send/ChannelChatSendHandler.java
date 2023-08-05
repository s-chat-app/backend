package indi.midreamsheep.schatapp.backend.chat.channel.send;

import indi.midreamsheep.schatapp.backend.api.chat.handler.annotation.ChatHandler;
import indi.midreamsheep.schatapp.backend.api.scan.inter.ChatHandlerInter;
import indi.midreamsheep.schatapp.backend.chat.ChatMessage;
import indi.midreamsheep.schatapp.backend.chat.message.ChatType;
import indi.midreamsheep.schatapp.backend.util.response.Result;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ChatHandler(mapping = "SEND", type = ChatType.CHANNEL)
public class ChannelChatSendHandler implements ChatHandlerInter {
    @Override
    public Result handle(ChannelHandlerContext ctx, ChatMessage data) {
        return null;
    }
}
