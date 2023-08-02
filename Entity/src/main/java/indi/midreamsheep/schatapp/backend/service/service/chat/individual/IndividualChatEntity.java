package indi.midreamsheep.schatapp.backend.service.service.chat.individual;

import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.service.service.chat.AbstractChatEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class IndividualChatEntity extends AbstractChatEntity {
     private final SChatUser[] users = new SChatUser[2];
}
