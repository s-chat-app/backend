package indi.midreamsheep.schatapp.backend.service.chat.system.login;

import indi.midreamsheep.schatapp.backend.chat.ChatMessage;
import indi.midreamsheep.schatapp.backend.chat.system.PrivateKey;
import indi.midreamsheep.schatapp.backend.util.response.Result;
import indi.midreamsheep.schatapp.backend.protocol.ChatDataProtocol;
import io.netty.channel.ChannelHandlerContext;

public interface ChatLoginService {
    ChatDataProtocol login(ChannelHandlerContext ctx, PrivateKey privateKey, ChatMessage data);
}
