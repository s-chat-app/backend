package indi.midreamsheep.schatapp.backend.function.dao.chat;

import indi.midreamsheep.schatapp.backend.entity.service.dao.Message;

/**
 * 消息相关的数据库操作
 * */
public interface MessageMapperHandler {
    void insertMessage(Message messageEntity);
    void updateMessage(Message messageEntity);
    void deleteMessage(long id);
    Message selectMessage(long id);
}
