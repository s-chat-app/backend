package indi.midreamsheep.schatapp.backend.dao.mysql.handle.chat.message;

import cn.hutool.core.bean.BeanUtil;
import indi.midreamsheep.schatapp.backend.dao.chat.MessageMapperHandler;
import indi.midreamsheep.schatapp.backend.dao.entity.DaoMessage;
import indi.midreamsheep.schatapp.backend.dao.mysql.mapper.MessageMapper;
import indi.midreamsheep.schatapp.backend.service.dao.Message;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class MessageMapperHandlerImpl implements MessageMapperHandler {

    @Resource
    private MessageMapper messageMapper;

    @Override
    public void insertMessage(Message messageEntity) {
        messageMapper.insert(BeanUtil.copyProperties(messageEntity, DaoMessage.class));
    }

    @Override
    public void updateMessage(Message messageEntity) {
        messageMapper.updateById(BeanUtil.copyProperties(messageEntity, DaoMessage.class));

    }

    @Override
    public void deleteMessage(long id) {
        messageMapper.deleteById(id);
    }

    @Override
    public Message selectMessage(long id) {
        return BeanUtil.copyProperties(messageMapper.selectById(id),Message.class);
    }
}
