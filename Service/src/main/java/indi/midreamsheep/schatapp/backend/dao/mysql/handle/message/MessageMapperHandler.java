package indi.midreamsheep.schatapp.backend.dao.mysql.handle.message;

import indi.midreamsheep.schatapp.backend.service.dao.mysql.Message;
import org.springframework.stereotype.Component;

public interface MessageMapperHandler {
    void insertMessage(Message messageEntity);
    void updateMessage(Message messageEntity);
    void deleteMessage(Message messageEntity);
    Message selectMessage(long id);
}
