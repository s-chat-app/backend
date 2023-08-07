package indi.midreamsheep.schatapp.backend.service.service.chat.individual;

import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.protocol.TransmissionEnum;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.Message;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.User;
import indi.midreamsheep.schatapp.backend.service.service.chat.AbstractChatEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Slf4j
@Data
public class IndividualChatEntity extends AbstractChatEntity {
     private final SChatUser[] users = new SChatUser[2];

     public void send(SChatUser user, Message data) {
         SChatUser user2 = getAnotherUser(user);
         if (user2 != null) {
             log.info("send message to user: {}", user2.getId());
             user2.receive(TransmissionEnum.SEND_MESSAGE,data,user.getId());
         }
     }

     public void edit(SChatUser user, Message data) {
         SChatUser user2 = getAnotherUser(user);
         if (user2 != null) {
             log.info("send message to user: {}", user2.getId());
             user2.receive(TransmissionEnum.EDIT_MESSAGE,data,user.getId());
         }
     }

     private SChatUser getAnotherUser(SChatUser user) {
         return users[0].getId()==user.getId()?users[1]:users[0];
     }
}

