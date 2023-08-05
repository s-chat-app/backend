package indi.midreamsheep.schatapp.backend.service.chat.individual.send;

import cn.hutool.core.util.IdUtil;
import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.chat.message.ChatType;
import indi.midreamsheep.schatapp.backend.dao.mysql.handle.message.MessageMapperHandler;
import indi.midreamsheep.schatapp.backend.dao.mysql.handle.message.MessageMapperHandlerImpl;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.Message;
import indi.midreamsheep.schatapp.backend.service.chat.individual.manager.IndividualChatManager;
import indi.midreamsheep.schatapp.backend.service.service.chat.individual.IndividualChatEntity;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import static indi.midreamsheep.schatapp.backend.until.TimeUtil.now;


@Component
public class IndividualChatSendServiceImpl implements IndividualChatSendService{

    @Resource
    IndividualChatManager individualChatManager;

    @Resource
    private MessageMapperHandlerImpl messageMapperHandlerImpl;

    @Override
    public Message endurance(SChatUser user, Message data) {
        data.setId(IdUtil.getSnowflake().nextId());
        data.setMessageTime(now());
        data.setMessageFrom(user.getId());
        data.setType(ChatType.INDIVIDUAL.getId());
        messageMapperHandlerImpl.insertMessage(data);
        return data;
    }

    @Override
    public void send(SChatUser user, Message data) {
        IndividualChatEntity individualChat = individualChatManager.getIndividualChat(data.getMessageTo());
        individualChat.send(user, data);
    }
}
