package indi.midreamsheep.schatapp.backend.chat.channel.send;

import indi.midreamsheep.schatapp.backend.api.handler.annotation.ChatHandler;
import indi.midreamsheep.schatapp.backend.api.scan.inter.ChatHandlerInter;
import indi.midreamsheep.schatapp.backend.entity.protocol.chat.request.ChatMessage;
import indi.midreamsheep.schatapp.backend.entity.protocol.chat.resonse.ChatTransmission;
import indi.midreamsheep.schatapp.backend.function.netty.ChatSender;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ChatHandler("SEND")
public class ChannelChatSendHandler implements ChatHandlerInter {
    @Override
    public ChatTransmission handle(ChatSender sender, ChatMessage data) {
        return null;
    }
}
