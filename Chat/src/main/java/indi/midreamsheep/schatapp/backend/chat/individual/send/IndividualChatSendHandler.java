package indi.midreamsheep.schatapp.backend.chat.individual.send;

import indi.midreamsheep.schatapp.backend.api.aop.access.annotation.ChatAccessChecker;
import indi.midreamsheep.schatapp.backend.api.aop.access.annotation.ChatExceptionHandler;
import indi.midreamsheep.schatapp.backend.protocol.chat.MessageProtocol;
import indi.midreamsheep.schatapp.backend.protocol.chat.request.ChatMessage;
import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.protocol.chat.request.ChatType;
import indi.midreamsheep.schatapp.backend.api.chat.handler.annotation.ChatHandler;
import indi.midreamsheep.schatapp.backend.api.scan.inter.ChatHandlerInter;
import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.ChatTransmission;
import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.ChatTransmissionEnum;
import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.data.result.Result;
import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.data.result.chat.ChatResultEnum;
import indi.midreamsheep.schatapp.backend.chat.transmission.SendMessage;
import indi.midreamsheep.schatapp.backend.service.chat.ChannelManager;
import indi.midreamsheep.schatapp.backend.service.chat.individual.api.IndividualChatSendService;
import indi.midreamsheep.schatapp.backend.util.json.JsonUtil;
import io.netty.channel.ChannelHandlerContext;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@ChatHandler(type = ChatType.INDIVIDUAL, mapping = "SEND")
public class IndividualChatSendHandler implements ChatHandlerInter {

    @Resource
    private ChannelManager channelManager;

    @Resource
    private IndividualChatSendService individualChatSendService;

    @Override
    @ChatAccessChecker(check = ChatTransmissionEnum.SEND_MESSAGE)
    @ChatExceptionHandler
    public MessageProtocol handle(ChannelHandlerContext ctx, ChatMessage data) throws Exception {
        SendMessage message = JsonUtil.getJsonToBean(data.getData(),SendMessage.class);
        SChatUser sChatUser = channelManager.getChannelMap().get(ctx.channel());
        log.info("用户{}发送消息给{}",sChatUser.getId(),message.getMessageTo());
        individualChatSendService.send(sChatUser, individualChatSendService.endurance(sChatUser, message));
        return new MessageProtocol(new ChatTransmission(data.getId(), ChatTransmissionEnum.SEND_MESSAGE,new Result(ChatResultEnum.SUCCESS)),sChatUser.getAESKey());
    }
}