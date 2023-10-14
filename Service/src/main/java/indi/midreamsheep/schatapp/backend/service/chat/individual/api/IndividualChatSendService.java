package indi.midreamsheep.schatapp.backend.service.chat.individual.api;

import indi.midreamsheep.schatapp.backend.entity.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.entity.chat.transmission.SendMessage;
import indi.midreamsheep.schatapp.backend.entity.service.dao.Message;

public interface IndividualChatSendService {
    Message endurance(SChatUser user, SendMessage data);
    void send(SChatUser user, Message data);
}
