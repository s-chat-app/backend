package indi.midreamsheep.schatapp.backend.chat.individual.send;

import indi.midreamsheep.schatapp.backend.entity.message.ChatType;
import indi.midreamsheep.schatapp.backend.entity.message.MessageEntity;
import indi.midreamsheep.schatapp.backend.scan.annotation.ChatHandler;
import indi.midreamsheep.schatapp.backend.scan.inter.ChatHandlerInter;
import io.netty.channel.ChannelHandlerContext;

@ChatHandler(type = ChatType.INDIVIDUAL, mapping = "SEND")
public class IndividualChatSendHandler implements ChatHandlerInter {

    @Override
    public void handle(ChannelHandlerContext ctx, MessageEntity msg) {

    }
}
