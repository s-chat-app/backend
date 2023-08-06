package indi.midreamsheep.schatapp.backend.api.scan.inter;

import indi.midreamsheep.schatapp.backend.api.aop.access.annotation.ChatExceptionHandler;
import indi.midreamsheep.schatapp.backend.chat.ChatMessage;
import indi.midreamsheep.schatapp.backend.protocol.ChatTransmission;
import io.netty.channel.ChannelHandlerContext;

public interface ChatHandlerInter {
    ChatTransmission handle(ChannelHandlerContext ctx, ChatMessage data);
}
