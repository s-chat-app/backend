package indi.midreamsheep.schatapp.backend.dao.mysql.handle.chat;

import indi.midreamsheep.schatapp.backend.service.dao.mysql.Message;
import org.springframework.stereotype.Component;

/**
 * 消息相关的数据库操作
 * */
public interface MessageMapperHandler {
    void insertMessage(Message messageEntity);
    void updateMessage(Message messageEntity);
    void deleteMessage(long id);
    Message selectMessage(long id);
}
