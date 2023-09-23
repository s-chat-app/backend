package indi.midreamsheep.schatapp.backend.service.chat.system.login;

import indi.midreamsheep.schatapp.backend.api.chat.exception.ChatException;
import indi.midreamsheep.schatapp.backend.protocol.chat.request.ChatMessage;
import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.chat.system.PrivateKey;
import indi.midreamsheep.schatapp.backend.dao.mysql.handle.chat.user.UserMapperHandlerImpl;
import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.ChatTransmission;
import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.ChatTransmissionEnum;
import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.data.result.Result;
import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.data.result.chat.ChatResultEnum;
import indi.midreamsheep.schatapp.backend.service.chat.ChannelManager;
import indi.midreamsheep.schatapp.backend.service.chat.individual.manager.IndividualChatManager;
import indi.midreamsheep.schatapp.backend.service.controller.user.UserStateService;
import io.netty.channel.ChannelHandlerContext;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ChatLoginServiceImpl implements ChatLoginService{

    @Resource
    private ChannelManager channelManager;

    @Resource
    private IndividualChatManager individualChatManager;

    @Resource
    private UserStateService userStateManager;

    @Resource
    private UserMapperHandlerImpl userMapperHandlerImpl;

    @Override
    public ChatTransmission login(ChannelHandlerContext ctx, PrivateKey privateKey, ChatMessage data) {
        long userId = userStateManager.getUserId(privateKey.getPrivateKey());
        if(userId == -1){
            throw new ChatException("the private key is not exist");
        }
        SChatUser user = userMapperHandlerImpl.getUserById(userId);
        user.setChannel(ctx.channel());
        user.setPrivateKey(privateKey.getPrivateKey());
        channelManager.addChannel(user);
        loginIndividualChat(user, user.getIndividuals());
/*        loginGroupChat(user, user.getGroups());
        loginChannelChat(user, user.getChannels());*/
        log.info("用户"+user.getUserData().getName()+"登录成功");
        return new ChatTransmission(data.getId(), ChatTransmissionEnum.LOGIN, new Result(ChatResultEnum.SUCCESS));
    }
    private void loginIndividualChat(SChatUser user, long[] ids) {
        for (long id : ids) {
           individualChatManager.addIndividualChat(id, user);
        }
    }
    private void loginGroupChat(SChatUser user, long[] ids) {
        for (long id : ids) {
            //TODO 处理群组信息
        }
    }
    private void loginChannelChat(SChatUser user, long[] ids) {
        for (long id : ids) {
            //TODO 处理频道信息
        }
    }
}
