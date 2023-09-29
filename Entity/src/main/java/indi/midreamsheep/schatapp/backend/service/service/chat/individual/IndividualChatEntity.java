package indi.midreamsheep.schatapp.backend.service.service.chat.individual;

import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.ChatTransmissionEnum;
import indi.midreamsheep.schatapp.backend.service.dao.Message;
import indi.midreamsheep.schatapp.backend.service.service.chat.AbstractChatEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 私人聊天实体类
 * 内部维护两个用户的数组
 * */
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
             user2.receive(ChatTransmissionEnum.SEND_MESSAGE,data,user.getId());
         }
     }

     public void edit(SChatUser user, Message data) {
         SChatUser user2 = getAnotherUser(user);
         if (user2 != null) {
             log.info("send message to user: {}", user2.getId());
             user2.receive(ChatTransmissionEnum.EDIT_MESSAGE,data,user.getId());
         }
     }

     private SChatUser getAnotherUser(SChatUser user) {
         return users[0].getId()==user.getId()?users[1]:users[0];
     }
}

