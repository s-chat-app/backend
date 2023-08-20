package indi.midreamsheep.schatapp.backend.chat.individual.edit;

import indi.midreamsheep.schatapp.backend.api.aop.access.annotation.ChatAccessChecker;
import indi.midreamsheep.schatapp.backend.api.aop.access.annotation.ChatExceptionHandler;
import indi.midreamsheep.schatapp.backend.api.chat.handler.annotation.ChatHandler;
import indi.midreamsheep.schatapp.backend.api.scan.inter.ChatHandlerInter;
import indi.midreamsheep.schatapp.backend.chat.ChatMessage;
import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.chat.message.ChatType;
import indi.midreamsheep.schatapp.backend.protocol.chat.ChatTransmission;
import indi.midreamsheep.schatapp.backend.protocol.chat.ChatTransmissionEnum;
import indi.midreamsheep.schatapp.backend.protocol.result.Result;
import indi.midreamsheep.schatapp.backend.protocol.result.chat.ChatResultEnum;
import indi.midreamsheep.schatapp.backend.protocol.transmission.EditMessage;
import indi.midreamsheep.schatapp.backend.service.chat.ChannelManager;
import indi.midreamsheep.schatapp.backend.service.chat.individual.api.IndividualChatEditService;
import indi.midreamsheep.schatapp.backend.util.json.JsonUtil;
import io.netty.channel.ChannelHandlerContext;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@ChatHandler(type = ChatType.INDIVIDUAL, mapping = "EDIT")
public class IndividualChatEditHandler implements ChatHandlerInter {

    @Resource
    private ChannelManager channelManager;

    @Resource
    private IndividualChatEditService individualChatEditService;

    @Override
    @ChatAccessChecker(check = ChatTransmissionEnum.EDIT_MESSAGE)
    @ChatExceptionHandler
    public ChatTransmission handle(ChannelHandlerContext ctx, ChatMessage data) {
        SChatUser user = channelManager.getUser(ctx.channel());
        EditMessage editMessage = JsonUtil.getJsonToBean(data.getData(), EditMessage.class);
        individualChatEditService.check(user, editMessage);
        individualChatEditService.edit( user,individualChatEditService.endurance(user, editMessage));
        return new ChatTransmission(data.getId(), ChatTransmissionEnum.EDIT_MESSAGE,new Result(ChatResultEnum.SUCCESS));
    }
}
