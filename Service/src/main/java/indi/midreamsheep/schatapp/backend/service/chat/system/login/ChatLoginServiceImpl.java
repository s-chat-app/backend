package indi.midreamsheep.schatapp.backend.service.chat.system.login;

import indi.midreamsheep.schatapp.backend.chat.ChatMessage;
import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.chat.system.PrivateKey;
import indi.midreamsheep.schatapp.backend.dao.mysql.handle.user.UserMapperHandler;
import indi.midreamsheep.schatapp.backend.protocol.result.Result;
import indi.midreamsheep.schatapp.backend.protocol.result.ResultEnum;
import indi.midreamsheep.schatapp.backend.service.chat.ChannelManager;
import indi.midreamsheep.schatapp.backend.service.chat.individual.manager.IndividualChatManager;
import indi.midreamsheep.schatapp.backend.service.user.UserStateManager;
import io.netty.channel.ChannelHandlerContext;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class ChatLoginServiceImpl implements ChatLoginService{

    @Resource
    private ChannelManager channelManager;

    @Resource
    private IndividualChatManager individualChatManager;

    @Resource
    private UserStateManager userStateManager;

    @Resource
    private UserMapperHandler userMapperHandler;

    @Override
    public Result login(ChannelHandlerContext ctx, PrivateKey privateKey, ChatMessage data) {
        long userId = userStateManager.getUserId(privateKey.getPrivateKey());
        if(userId == -1){
            return new Result(ResultEnum.ERROR,data.getId(), "privateKey is error");
        }
        SChatUser user = userMapperHandler.getUserById(userId);
        user.setChannel(ctx.channel());
        channelManager.addChannel(user);
        loginIndividualChat(user, user.getFriends());
        loginGroupChat(user, user.getGroups());
        loginChannelChat(user, user.getChannels());
        return new Result(ResultEnum.SUCCESS, data.getId(), "login success");

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
