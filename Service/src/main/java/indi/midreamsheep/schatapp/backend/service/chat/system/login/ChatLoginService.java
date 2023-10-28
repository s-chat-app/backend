package indi.midreamsheep.schatapp.backend.service.chat.system.login;

import indi.midreamsheep.schatapp.backend.entity.protocol.chat.request.ChatMessage;
import indi.midreamsheep.schatapp.backend.entity.chat.system.PrivateKey;
import indi.midreamsheep.schatapp.backend.entity.protocol.chat.resonse.ChatTransmission;
import indi.midreamsheep.schatapp.backend.function.netty.ChatSender;
import io.netty.channel.ChannelHandlerContext;

public interface ChatLoginService {
    ChatTransmission login(ChatSender sender, PrivateKey privateKey, ChatMessage data);
}
