package indi.midreamsheep.schatapp.backend.service.chat.system.login;

import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.chat.system.PrivateKey;
import indi.midreamsheep.schatapp.backend.service.chat.ChannelManager;
import indi.midreamsheep.schatapp.backend.service.chat.individual.manager.IndividualChatManager;
import io.netty.channel.ChannelHandlerContext;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class ChatLoginServiceImpl implements ChatLoginService{

    @Resource
    private ChannelManager channelManager;

    @Resource
    private IndividualChatManager individualChatManager;

    @Override
    public void login(ChannelHandlerContext ctx, PrivateKey privateKey) {
        //TODO 通过数据库查询用户信息
        SChatUser user = new SChatUser();
        user.setChannel(ctx.channel());
        channelManager.addChannel(user);
        //TODO 通过数据库查询好友、群组、频道信息 获取id数组
        long[] indi = new long[0];
        loginIndividualChat(user, indi);

        long[] group = new long[0];
        loginIndividualChat(user, group);

        long[] channel = new long[0];
        loginIndividualChat(user, channel);

    }
    private void loginIndividualChat(SChatUser user, long[] ids) {
        for (long id : ids) {
           individualChatManager.addIndividualChat(id, user);
        }
    }
    private void loginGroupChat(SChatUser user, long[] ids) {
        for (long id : ids) {
            //TODO
        }
    }
    private void loginChannelChat(SChatUser user, long[] ids) {
        for (long id : ids) {
            //TODO
        }
    }
}
