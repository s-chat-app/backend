package indi.midreamsheep.schatapp.backend.service.chat.individual.send;

import cn.hutool.core.util.IdUtil;
import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.dao.mysql.handle.message.MessageMapperHandler;
import indi.midreamsheep.schatapp.backend.dao.mysql.handle.message.MessageMapperHandlerImpl;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.Message;
import indi.midreamsheep.schatapp.backend.service.chat.individual.manager.IndividualChatManager;
import indi.midreamsheep.schatapp.backend.service.service.chat.individual.IndividualChatEntity;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class IndividualChatSendServiceImpl implements IndividualChatSendService{

    @Resource
    IndividualChatManager individualChatManager;

    @Resource
    private MessageMapperHandlerImpl messageMapperHandlerImpl;

    @Override
    public Message endurance(SChatUser user, Message data) {
        data.setId(IdUtil.getSnowflake().nextId());
        data.setMessageTime(new Timestamp(System.currentTimeMillis()));
        data.setMessageFrom(user.getId());
        messageMapperHandlerImpl.insertMessage(data);
        return data;
    }

    @Override
    public void send(SChatUser user, Message data) {
        IndividualChatEntity individualChat = individualChatManager.getIndividualChat(data.getMessageTo());
        individualChat.send(user, data);
    }
}
