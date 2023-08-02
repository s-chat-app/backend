package indi.midreamsheep.schatapp.backend.api.scan.inter;

import indi.midreamsheep.schatapp.backend.protocol.Result;
import io.netty.channel.ChannelHandlerContext;

public interface ChatHandlerInter {
    Result handle(ChannelHandlerContext ctx, String data);
}
