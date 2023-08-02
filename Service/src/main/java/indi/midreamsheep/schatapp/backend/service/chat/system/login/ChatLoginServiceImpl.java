package indi.midreamsheep.schatapp.backend.service.chat.system.login;

import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.chat.system.PrivateKey;
import indi.midreamsheep.schatapp.backend.service.chat.ChannelManager;
import indi.midreamsheep.schatapp.backend.service.chat.individual.manager.IndividualChatManager;
import indi.midreamsheep.schatapp.backend.service.service.chat.individual.IndividualChatEntity;
import io.netty.channel.ChannelHandlerContext;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

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
        BigInteger[] indi = new BigInteger[0];
        loginIndividualChat(user, indi);

        BigInteger[] group = new BigInteger[0];
        loginIndividualChat(user, group);

        BigInteger[] channel = new BigInteger[0];
        loginIndividualChat(user, channel);

    }
    private void loginIndividualChat(SChatUser user, BigInteger[] ids) {
        for (BigInteger id : ids) {
           individualChatManager.addIndividualChat(id, user);
        }
    }
    private void loginGroupChat(SChatUser user, BigInteger[] ids) {
        for (BigInteger id : ids) {
            //TODO
        }
    }
    private void loginChannelChat(SChatUser user, BigInteger[] ids) {
        for (BigInteger id : ids) {
            //TODO
        }
    }
}
