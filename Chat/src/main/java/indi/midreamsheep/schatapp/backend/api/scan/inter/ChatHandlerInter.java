package indi.midreamsheep.schatapp.backend.api.scan.inter;

import indi.midreamsheep.schatapp.backend.chat.ChatMessage;
import indi.midreamsheep.schatapp.backend.protocol.result.Result;
import io.netty.channel.ChannelHandlerContext;

public interface ChatHandlerInter {
    Result handle(ChannelHandlerContext ctx, ChatMessage data);
}
