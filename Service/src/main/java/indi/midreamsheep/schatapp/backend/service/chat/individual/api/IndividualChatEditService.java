package indi.midreamsheep.schatapp.backend.service.chat.individual.api;

import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.protocol.transmission.EditMessage;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.Message;

public interface IndividualChatEditService {
    Message endurance(SChatUser user, EditMessage data);
    void edit(SChatUser user, Message data);

    void check(SChatUser user, EditMessage editMessage);
}
