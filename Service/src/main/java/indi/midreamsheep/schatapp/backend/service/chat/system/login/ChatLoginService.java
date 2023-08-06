package indi.midreamsheep.schatapp.backend.service.chat.system.login;

import indi.midreamsheep.schatapp.backend.chat.ChatMessage;
import indi.midreamsheep.schatapp.backend.chat.system.PrivateKey;
import indi.midreamsheep.schatapp.backend.protocol.ChatTransmission;
import io.netty.channel.ChannelHandlerContext;

public interface ChatLoginService {
    ChatTransmission login(ChannelHandlerContext ctx, PrivateKey privateKey, ChatMessage data);
}
