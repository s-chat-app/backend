package indi.midreamsheep.schatapp.backend.chat.individual.send;

import indi.midreamsheep.schatapp.backend.api.aop.access.annotation.ChatAccessChecker;
import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.chat.message.ChatType;
import indi.midreamsheep.schatapp.backend.api.chat.handler.annotation.ChatHandler;
import indi.midreamsheep.schatapp.backend.api.scan.inter.ChatHandlerInter;
import indi.midreamsheep.schatapp.backend.protocol.Result;
import indi.midreamsheep.schatapp.backend.protocol.ResultEnum;
import indi.midreamsheep.schatapp.backend.service.chat.ChannelManager;
import indi.midreamsheep.schatapp.backend.service.chat.individual.send.IndividualChatSendService;
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
        //获取用户信息
        SChatUser sChatUser = channelManager.getChannelMap().get(ctx.channel());
        individualChatSendService.send(sChatUser, data);
        individualChatSendService.endurance(sChatUser, data);
        return new Result(ResultEnum.SUCCESS, "send success");
    }
}