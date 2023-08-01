package indi.midreamsheep.schatapp.backend.api.scan.inter;

import io.netty.channel.ChannelHandlerContext;

public interface ChatHandlerInter {
    void handle(ChannelHandlerContext ctx, String data);
}
