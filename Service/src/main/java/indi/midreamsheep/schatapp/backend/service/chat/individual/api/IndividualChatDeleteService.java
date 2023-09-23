package indi.midreamsheep.schatapp.backend.service.chat.individual.api;

import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.chat.transmission.DeleteMessage;

public interface IndividualChatDeleteService {
    DeleteMessage endurance(SChatUser user, DeleteMessage data);
    void delete(SChatUser user, DeleteMessage id);

    void check(SChatUser user, DeleteMessage deleteMessage);
}
