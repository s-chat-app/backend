package indi.midreamsheep.schatapp.backend.chat.individual.send;

import indi.midreamsheep.schatapp.backend.api.aop.access.annotation.ChatAccessChecker;
import indi.midreamsheep.schatapp.backend.chat.ChatMessage;
import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.chat.message.ChatType;
import indi.midreamsheep.schatapp.backend.api.chat.handler.annotation.ChatHandler;
import indi.midreamsheep.schatapp.backend.api.scan.inter.ChatHandlerInter;
import indi.midreamsheep.schatapp.backend.protocol.ChatDataProtocol;
import indi.midreamsheep.schatapp.backend.protocol.ChatDataTypeEnum;
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
    @ChatAccessChecker(ChatDataTypeEnum.SEND_MESSAGE)
    public ChatDataProtocol handle(ChannelHandlerContext ctx, ChatMessage data) {
        try {
            Message jsonToBean = JsonUtil.getJsonToBean(data.getData(), Message.class);
            SChatUser sChatUser = channelManager.getChannelMap().get(ctx.channel());
            individualChatSendService.send(sChatUser, individualChatSendService.endurance(sChatUser, jsonToBean));
        }catch (Exception e){
            log.error("发送消息失败", e);
            return new ChatDataProtocol(data.getId(), ChatDataTypeEnum.SEND_MESSAGE.getCode(), new Result(ResultEnum.ERROR).toString());
        }
        return new ChatDataProtocol(data.getId(), ChatDataTypeEnum.SEND_MESSAGE.getCode(), new Result(ResultEnum.SUCCESS).toString());
    }
}