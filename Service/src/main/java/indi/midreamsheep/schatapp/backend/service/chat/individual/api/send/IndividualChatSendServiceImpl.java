package indi.midreamsheep.schatapp.backend.service.chat.individual.api.send;

import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.chat.message.ChatType;
import indi.midreamsheep.schatapp.backend.dao.mysql.handle.message.MessageMapperHandlerImpl;
import indi.midreamsheep.schatapp.backend.protocol.transmission.SendMessage;
import indi.midreamsheep.schatapp.backend.service.chat.individual.api.IndividualChatSendService;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.Message;
import indi.midreamsheep.schatapp.backend.service.chat.individual.manager.IndividualChatManager;
import indi.midreamsheep.schatapp.backend.service.service.chat.individual.IndividualChatEntity;
import indi.midreamsheep.schatapp.backend.util.entity.IdUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import static indi.midreamsheep.schatapp.backend.util.entity.TimeUtil.now;


@Component
public class IndividualChatSendServiceImpl implements IndividualChatSendService {

    @Resource
    IndividualChatManager individualChatManager;

    @Resource
    private MessageMapperHandlerImpl messageMapperHandlerImpl;

    @Override
    public Message endurance(SChatUser user, SendMessage data) {
        Message message = new Message();
        message.setId(IdUtil.generateId());
        message.setMessageFrom(user.getId());
        message.setMessageTo(data.getMessageTo());
        message.setType(ChatType.INDIVIDUAL.getId());
        message.setMessageTime(now());
        message.setMessage(data.getMessage());
        messageMapperHandlerImpl.insertMessage(message);
        return message;
    }

    @Override
    public void send(SChatUser user, Message data) {
        IndividualChatEntity individualChat = individualChatManager.getIndividualChat(data.getMessageTo());
        individualChat.send(user, data);
    }
}
