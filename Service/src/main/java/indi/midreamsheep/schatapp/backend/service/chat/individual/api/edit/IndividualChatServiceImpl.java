package indi.midreamsheep.schatapp.backend.service.chat.individual.api.edit;

import indi.midreamsheep.schatapp.backend.api.chat.exception.ChatException;
import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.chat.message.ChatType;
import indi.midreamsheep.schatapp.backend.dao.mysql.handle.message.MessageMapperHandler;
import indi.midreamsheep.schatapp.backend.protocol.transmission.DeleteMessage;
import indi.midreamsheep.schatapp.backend.protocol.transmission.EditMessage;
import indi.midreamsheep.schatapp.backend.service.chat.individual.api.IndividualChatEditService;
import indi.midreamsheep.schatapp.backend.service.chat.individual.manager.IndividualChatManager;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.Message;
import indi.midreamsheep.schatapp.backend.service.service.chat.individual.IndividualChatEntity;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static indi.midreamsheep.schatapp.backend.util.entity.TimeUtil.now;

@Component
@Slf4j
public class IndividualChatServiceImpl implements IndividualChatEditService {


    @Resource
    private MessageMapperHandler messageMapperHandler;

    @Resource
    private IndividualChatManager individualChatManager;

    @Override
    public Message endurance(SChatUser user, EditMessage data) {
        Message message = new Message();
        message.setId(data.getEditId());
        message.setMessageFrom(user.getId());
        message.setMessageTime(now());
        message.setType(ChatType.INDIVIDUAL.getId());
        message.setMessageTo(data.getMessageTo());
        message.setMessage(data.getMessage());
        messageMapperHandler.updateMessage(message);
        return message;
    }

    @Override
    public void edit(SChatUser user, Message data) {
        log.info("user {} edit message {} to {}", user.getId(), data.getId(), data.getMessageTo());
        IndividualChatEntity individualChat = individualChatManager.getIndividualChat(data.getMessageTo());
        individualChat.edit(user,data);
    }

    @Override
    public void check(SChatUser user, EditMessage deleteMessage) {
        Message message = messageMapperHandler.selectMessage(deleteMessage.getEditId());
        if(message==null||message.getMessageFrom()!=(user.getId())){
            throw new ChatException("could not edit message from other user");
        }
    }
}
