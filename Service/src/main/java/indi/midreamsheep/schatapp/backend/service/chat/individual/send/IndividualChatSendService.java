package indi.midreamsheep.schatapp.backend.service.chat.individual.send;

import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.chat.message.send.SendMessageEntity;

public interface IndividualChatSendService {
    SendMessageEntity endurance(SChatUser user, SendMessageEntity data);
    void send(SChatUser user, SendMessageEntity data);
}
