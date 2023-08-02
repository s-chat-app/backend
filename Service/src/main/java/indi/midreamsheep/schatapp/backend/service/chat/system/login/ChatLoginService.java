package indi.midreamsheep.schatapp.backend.service.chat.system.login;

import indi.midreamsheep.schatapp.backend.chat.system.PrivateKey;
import io.netty.channel.ChannelHandlerContext;

public interface ChatLoginService {
    void login(ChannelHandlerContext ctx, PrivateKey privateKey);
}
