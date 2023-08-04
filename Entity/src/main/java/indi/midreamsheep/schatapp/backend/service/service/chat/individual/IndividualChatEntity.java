package indi.midreamsheep.schatapp.backend.service.service.chat.individual;

import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.Message;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.User;
import indi.midreamsheep.schatapp.backend.service.service.chat.AbstractChatEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class IndividualChatEntity extends AbstractChatEntity {
     private final SChatUser[] users = new SChatUser[2];

     public void send(SChatUser user, Message data) {
         SChatUser user2 = users[0]==user?users[1]:users[0];
         if (user2 != null) {
             user2.receive(data);
         }
     }
}
