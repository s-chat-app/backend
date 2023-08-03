package indi.midreamsheep.schatapp.backend.service.chat.individual.send;

import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.Message;

public interface IndividualChatSendService {
    Message endurance(SChatUser user, Message data);
    void send(SChatUser user, Message data);
}
