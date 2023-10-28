package indi.midreamsheep.schatapp.backend.service.chat.system.login;

import indi.midreamsheep.schatapp.backend.entity.api.chat.exception.ChatException;
import indi.midreamsheep.schatapp.backend.function.dao.chat.UserMapperHandler;
import indi.midreamsheep.schatapp.backend.entity.protocol.chat.request.ChatMessage;
import indi.midreamsheep.schatapp.backend.entity.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.entity.chat.system.PrivateKey;
import indi.midreamsheep.schatapp.backend.entity.protocol.chat.resonse.ChatTransmission;
import indi.midreamsheep.schatapp.backend.entity.protocol.chat.resonse.ChatTransmissionEnum;
import indi.midreamsheep.schatapp.backend.entity.protocol.chat.resonse.data.result.Result;
import indi.midreamsheep.schatapp.backend.entity.protocol.chat.resonse.data.result.chat.ChatResultEnum;
import indi.midreamsheep.schatapp.backend.function.netty.ChatSender;
import indi.midreamsheep.schatapp.backend.service.chat.ChannelManager;
import indi.midreamsheep.schatapp.backend.service.chat.individual.manager.IndividualChatManager;
import indi.midreamsheep.schatapp.backend.service.controller.user.UserStateService;
import indi.midreamsheep.schatapp.backend.util.protocol.AesUtil;
import indi.midreamsheep.schatapp.backend.util.protocol.ECCUtils;
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
    private UserMapperHandler userMapperHandlerImpl;

    @Override
    public ChatTransmission login(ChatSender sender, PrivateKey privateKey, ChatMessage data) {
        long userId = userStateManager.getUserId(privateKey.getPrivateKey());
        if(userId == -1){
            throw new ChatException("the private key is not exist");
        }
        SChatUser user = userMapperHandlerImpl.getUserById(userId);
        user.setSender(sender);
        user.setPrivateKey(privateKey.getPrivateKey());
        String output = "";
        try {
            String AESKey = AesUtil.generateKey();
            output = ECCUtils.encryptByPublicKey(AESKey, privateKey.getPublicKey());
            user.setAESKey(AESKey);
        } catch (Exception e) {
            log.error("加密失败");
            return new ChatTransmission(data.getId(), ChatTransmissionEnum.LOGIN, new Result(ChatResultEnum.ERROR));
        }
        channelManager.addChannel(user);
        loginIndividualChat(user, user.getIndividuals());
/*        loginGroupChat(user, user.getGroups());
        loginChannelChat(user, user.getChannels());*/
        log.info("用户"+user.getUserData().getName()+"登录成功"+"id:"+data.getId());
        System.out.println(privateKey.getPublicKey());
        System.out.println(output);
        log.info("AESKey:"+user.getAESKey()+";");
        return new ChatTransmission(data.getId(), ChatTransmissionEnum.LOGIN, new Result(ChatResultEnum.SUCCESS,output));
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
