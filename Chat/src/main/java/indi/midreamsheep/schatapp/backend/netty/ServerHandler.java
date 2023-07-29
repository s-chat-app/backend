package indi.midreamsheep.schatapp.backend.netty;

import io.netty.channel.ChannelHandlerContext;

public interface ServerHandler {
    void handle(ChannelHandlerContext ctx, String msg);
}
