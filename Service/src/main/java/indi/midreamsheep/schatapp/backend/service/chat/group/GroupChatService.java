package indi.midreamsheep.schatapp.backend.service.chat.group;

import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.Message;

public interface GroupChatService {
    void enduranceMessage(SChatUser user, Message msg);
    void send(Message msg);
}
