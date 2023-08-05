package indi.midreamsheep.schatapp.backend.chat.individual.edit;

import indi.midreamsheep.schatapp.backend.api.aop.access.annotation.ChatAccessChecker;
import indi.midreamsheep.schatapp.backend.api.chat.handler.annotation.ChatHandler;
import indi.midreamsheep.schatapp.backend.api.scan.inter.ChatHandlerInter;
import indi.midreamsheep.schatapp.backend.chat.ChatMessage;
import indi.midreamsheep.schatapp.backend.chat.message.ChatType;
import indi.midreamsheep.schatapp.backend.protocol.ChatDataProtocol;
import indi.midreamsheep.schatapp.backend.protocol.ChatDataTypeEnum;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@ChatHandler(type = ChatType.INDIVIDUAL, mapping = "SEND")
public class IndividualChatEditHandler implements ChatHandlerInter {
    @Override
    @ChatAccessChecker(check = ChatDataTypeEnum.EDIT_MESSAGE)
    public ChatDataProtocol handle(ChannelHandlerContext ctx, ChatMessage data) {
        //TODO 获取用户信息
        //TODO 进行删除
        //TODO 消息推送
        return null;
    }
}
