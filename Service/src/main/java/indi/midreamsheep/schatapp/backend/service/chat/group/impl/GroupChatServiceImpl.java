package indi.midreamsheep.schatapp.backend.service.chat.group.impl;

import cn.hutool.core.util.IdUtil;
import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.dao.mysql.handle.message.MessageMapperHandler;
import indi.midreamsheep.schatapp.backend.dao.mysql.handle.message.MessageMapperHandlerImpl;
import indi.midreamsheep.schatapp.backend.dao.mysql.mapper.GroupMapper;
import indi.midreamsheep.schatapp.backend.service.chat.group.GroupChatService;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.Message;
import jakarta.annotation.Resource;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import static indi.midreamsheep.schatapp.backend.until.TimeUtil.now;

@Service
public class GroupChatServiceImpl  implements GroupChatService {
    @Resource
    private MessageMapperHandler messageMapperHandler;

    @Resource
    private GroupMapper groupMapper;

    @Override
    public void enduranceMessage(SChatUser user, Message msg) {
        msg.setId(IdUtil.getSnowflake().nextId());
        msg.setMessageTime(now());
        msg.setMessageFrom(user.getId());
        messageMapperHandler.insertMessage(msg);
    }

    @Override
    public void send(Message msg) {

    }
}
