package indi.midreamsheep.schatapp.backend.service.chat.individual.send;

import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.chat.message.send.SendMessageEntity;
import indi.midreamsheep.schatapp.backend.service.chat.individual.manager.IndividualChatManager;
import indi.midreamsheep.schatapp.backend.service.service.chat.individual.IndividualChatEntity;
import jakarta.annotation.Resource;

public class IndividualChatSendServiceImpl implements IndividualChatSendService{

    @Resource
    IndividualChatManager individualChatManager;

    @Override
    public SendMessageEntity endurance(SChatUser user, SendMessageEntity data) {
        //TODO 数据库持久化
        //TODO data信息补全
        return data;
    }

    @Override
    public void send(SChatUser user, SendMessageEntity data) {
        IndividualChatEntity individualChat = individualChatManager.getIndividualChat(data.getMessageTo());
        individualChat.send(user, data);
    }
}
