package indi.midreamsheep.schatapp.backend.service.chat.group.impl;

import cn.hutool.core.util.IdUtil;
import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.dao.mysql.handle.message.MessageMapperHandler;
import indi.midreamsheep.schatapp.backend.dao.mysql.mapper.GroupMapper;
import indi.midreamsheep.schatapp.backend.service.chat.group.GroupChatService;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.Message;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import static indi.midreamsheep.schatapp.backend.util.entity.TimeUtil.now;

/**
 * Implements group chat logics
 * @author lsk
 */
@Service
public class GroupChatServiceImpl  implements GroupChatService {
    // Database "message" accessor
    @Resource
    private MessageMapperHandler messageMapperHandler;

    // Database "group" accessor
    @Resource
    private GroupMapper groupMapper;

    @Override
    public void enduranceMessage(SChatUser user, Message msg) {
        // Generate the message id with snowflake id generator
        msg.setId(IdUtil.getSnowflake().nextId());
        msg.setMessageTime(now());
        msg.setMessageFrom(user.getId());
        messageMapperHandler.insertMessage(msg);
    }

    @Override
    public void send(Message msg) {
        // TODO
    }
}
