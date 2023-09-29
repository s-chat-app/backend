package indi.midreamsheep.schatapp.backend.service.chat.group;

import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.service.dao.Message;

/**
 * Group Chat Logics
 * @author lsk
 */
public interface GroupChatService {
    /**
     * Save a group message to database
     * @param user the sender
     * @param msg the message structure
     */
    void enduranceMessage(SChatUser user, Message msg);

    /**
     * Send a group message to all online group members
     * @param msg the message structure
     */
    void send(Message msg);
}
