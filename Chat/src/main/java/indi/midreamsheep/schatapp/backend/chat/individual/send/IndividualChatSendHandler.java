package indi.midreamsheep.schatapp.backend.chat.individual.send;

import indi.midreamsheep.schatapp.backend.api.aop.access.annotation.ChatAccessChecker;
import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.chat.message.ChatType;
import indi.midreamsheep.schatapp.backend.api.chat.handler.annotation.ChatHandler;
import indi.midreamsheep.schatapp.backend.api.scan.inter.ChatHandlerInter;
import indi.midreamsheep.schatapp.backend.chat.message.send.SendMessageEntity;
import indi.midreamsheep.schatapp.backend.protocol.Result;
import indi.midreamsheep.schatapp.backend.protocol.ResultEnum;
import indi.midreamsheep.schatapp.backend.service.chat.ChannelManager;
import indi.midreamsheep.schatapp.backend.service.chat.individual.send.IndividualChatSendService;
import indi.midreamsheep.schatapp.backend.until.json.JsonUtil;
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
    @ChatAccessChecker
    public Result handle(ChannelHandlerContext ctx, String data) {
        SendMessageEntity jsonToBean = JsonUtil.getJsonToBean(data, SendMessageEntity.class);
        //获取用户信息
        SChatUser sChatUser = channelManager.getChannelMap().get(ctx.channel());
        individualChatSendService.send(sChatUser, individualChatSendService.endurance(sChatUser, jsonToBean));
        //TODO 返回消息id 通知发送成功
        return new Result(ResultEnum.SUCCESS, "send success");
    }
}