package indi.midreamsheep.schatapp.backend.service.chat.individual.api.send;

import indi.midreamsheep.schatapp.backend.entity.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.function.dao.chat.MessageMapperHandler;
import indi.midreamsheep.schatapp.backend.entity.chat.transmission.SendMessage;
import indi.midreamsheep.schatapp.backend.service.chat.individual.api.IndividualChatSendService;
import indi.midreamsheep.schatapp.backend.entity.service.dao.Message;
import indi.midreamsheep.schatapp.backend.service.chat.individual.manager.IndividualChatManager;
import indi.midreamsheep.schatapp.backend.entity.service.service.chat.individual.IndividualChatEntity;
import indi.midreamsheep.schatapp.backend.util.entity.IdUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import static indi.midreamsheep.schatapp.backend.util.entity.TimeUtil.now;


@Component
public class IndividualChatSendServiceImpl implements IndividualChatSendService {

    @Resource
    IndividualChatManager individualChatManager;

    @Resource
    private MessageMapperHandler messageMapperHandlerImpl;

    @Override
    public Message endurance(SChatUser user, SendMessage data) {
        Message message = new Message();
        message.setId(IdUtil.generateId());
        message.setMessageFrom(user.getId());
        message.setMessageTo(data.getMessageTo());
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
