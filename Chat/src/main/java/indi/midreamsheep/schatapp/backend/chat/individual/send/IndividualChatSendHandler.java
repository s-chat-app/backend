package indi.midreamsheep.schatapp.backend.chat.individual.send;

import indi.midreamsheep.schatapp.backend.api.aop.access.annotation.ChatAccessChecker;
import indi.midreamsheep.schatapp.backend.api.aop.access.annotation.ChatExceptionHandler;
import indi.midreamsheep.schatapp.backend.api.exception.ChatException;
import indi.midreamsheep.schatapp.backend.chat.ChatMessage;
import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.chat.message.ChatType;
import indi.midreamsheep.schatapp.backend.api.chat.handler.annotation.ChatHandler;
import indi.midreamsheep.schatapp.backend.api.scan.inter.ChatHandlerInter;
import indi.midreamsheep.schatapp.backend.protocol.ChatTransmission;
import indi.midreamsheep.schatapp.backend.protocol.TransmissionEnum;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.Message;
import indi.midreamsheep.schatapp.backend.util.response.Result;
import indi.midreamsheep.schatapp.backend.util.response.ResultEnum;
import indi.midreamsheep.schatapp.backend.service.chat.ChannelManager;
import indi.midreamsheep.schatapp.backend.service.chat.individual.send.IndividualChatSendService;
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
    @ChatAccessChecker(check = TransmissionEnum.SEND_MESSAGE)
    @ChatExceptionHandler
    public ChatTransmission handle(ChannelHandlerContext ctx, ChatMessage data) {
        throw new ChatException("guess why");
/*        try {
            Message jsonToBean = JsonUtil.getJsonToBean(data.getData(), Message.class);
            SChatUser sChatUser = channelManager.getChannelMap().get(ctx.channel());
            individualChatSendService.send(sChatUser, individualChatSendService.endurance(sChatUser, jsonToBean));
        }catch (Exception e){
            log.error("发送消息失败", e);
            //return new ChatTransmission(data.getId(), TransmissionEnum.SEND_MESSAGE.getCode(), new Result(ResultEnum.ERROR).toString());
        }
        //TODO return new ChatTransmission(data.getId(), TransmissionEnum.SEND_MESSAGE.getCode(), new Result(ResultEnum.SUCCESS).toString());
        return null;*/
    }
}