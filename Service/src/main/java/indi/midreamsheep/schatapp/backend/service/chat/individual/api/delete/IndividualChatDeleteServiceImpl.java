package indi.midreamsheep.schatapp.backend.service.chat.individual.api.delete;

import indi.midreamsheep.schatapp.backend.api.chat.exception.ChatException;
import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.dao.mysql.handle.message.MessageMapperHandler;
import indi.midreamsheep.schatapp.backend.protocol.TransmissionEnum;
import indi.midreamsheep.schatapp.backend.protocol.transmission.DeleteMessage;
import indi.midreamsheep.schatapp.backend.service.chat.individual.api.IndividualChatDeleteService;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.Message;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
@Resource
public class IndividualChatDeleteServiceImpl implements IndividualChatDeleteService {

    @Resource
    private MessageMapperHandler messageMapperHandler;

    @Override
    public DeleteMessage endurance(SChatUser user, DeleteMessage data) {
        messageMapperHandler.deleteMessage(data.getDeleteId());
        return data;
    }

    @Override
    public void delete(SChatUser user, DeleteMessage id) {
        user.receive(TransmissionEnum.DELETE_MESSAGE,id,user.getId());
    }

    @Override
    public void check(SChatUser user, DeleteMessage deleteMessage) {
        Message message = messageMapperHandler.selectMessage(deleteMessage.getDeleteId());
        if(message==null||message.getMessageFrom()!=(user.getId())){
            throw new ChatException("could not delete message from other user");
        }
    }
}
