package indi.midreamsheep.schatapp.backend.scan.inter;

import indi.midreamsheep.schatapp.backend.entity.message.MessageEntity;
import io.netty.channel.ChannelHandlerContext;

public interface ChatHandlerInter {
    void handle(ChannelHandlerContext ctx, MessageEntity msg);
}
