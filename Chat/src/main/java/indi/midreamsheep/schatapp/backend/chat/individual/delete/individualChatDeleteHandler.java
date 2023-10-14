package indi.midreamsheep.schatapp.backend.chat.individual.delete;

import indi.midreamsheep.schatapp.backend.api.aop.access.annotation.ChatAccessChecker;
import indi.midreamsheep.schatapp.backend.api.aop.access.annotation.ChatExceptionHandler;
import indi.midreamsheep.schatapp.backend.entity.api.chat.handler.annotation.ChatHandler;
import indi.midreamsheep.schatapp.backend.api.scan.inter.ChatHandlerInter;
import indi.midreamsheep.schatapp.backend.entity.protocol.chat.request.ChatMessage;
import indi.midreamsheep.schatapp.backend.entity.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.entity.protocol.chat.resonse.ChatTransmission;
import indi.midreamsheep.schatapp.backend.entity.protocol.chat.resonse.ChatTransmissionEnum;
import indi.midreamsheep.schatapp.backend.entity.protocol.chat.resonse.data.result.Result;
import indi.midreamsheep.schatapp.backend.entity.protocol.chat.resonse.data.result.chat.ChatResultEnum;
import indi.midreamsheep.schatapp.backend.entity.chat.transmission.DeleteMessage;
import indi.midreamsheep.schatapp.backend.service.chat.ChannelManager;
import indi.midreamsheep.schatapp.backend.service.chat.individual.api.IndividualChatDeleteService;
import indi.midreamsheep.schatapp.backend.util.json.JsonUtil;
import io.netty.channel.ChannelHandlerContext;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@ChatHandler("INDIVIDUAL_DELETE")
public class individualChatDeleteHandler implements ChatHandlerInter {

    @Resource
    private ChannelManager channelManager;

    @Resource
    private IndividualChatDeleteService individualChatDeleteService;

    @Override
    @ChatAccessChecker(check = ChatTransmissionEnum.DELETE_MESSAGE)
    @ChatExceptionHandler
    public ChatTransmission handle(ChannelHandlerContext ctx, ChatMessage data) throws Exception {
        //获取用户信息
        SChatUser user = channelManager.getUser(ctx.channel());
        //获取消息信息
        DeleteMessage deleteMessage = JsonUtil.getJsonToBean(data.getData(),DeleteMessage.class);
        //权限校验
        individualChatDeleteService.check(user, deleteMessage);
        //删除消息
        individualChatDeleteService.delete(user,individualChatDeleteService.endurance(user, deleteMessage));
        return new ChatTransmission(data.getId(), ChatTransmissionEnum.DELETE_MESSAGE, new Result(ChatResultEnum.SUCCESS));
    }
}
