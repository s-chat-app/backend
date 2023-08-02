package indi.midreamsheep.schatapp.backend.service.chat.individual.send;

import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;

import java.math.BigInteger;

public interface IndividualChatSendService {
    BigInteger endurance(SChatUser user, String data);
    void send(SChatUser user, String data);
}
