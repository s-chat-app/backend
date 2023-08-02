package indi.midreamsheep.schatapp.backend.service.chat.individual.manager;

import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.service.service.chat.individual.IndividualChatEntity;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class IndividualChatManager {
    Map<BigInteger, IndividualChatEntity> individualChatMap = new ConcurrentHashMap<>();

    public void addIndividualChat(BigInteger id, SChatUser user) {
        if(individualChatMap.containsKey(id)){
            individualChatMap.get(id).getUsers()[1] = user;
            return;
        }
        IndividualChatEntity individualChatEntity = new IndividualChatEntity();
        individualChatEntity.setId(id);
        individualChatEntity.getUsers()[0] = user;
        addIndividualChat(individualChatEntity);
    }


    public void addIndividualChat(IndividualChatEntity individualChatEntity) {
        individualChatMap.put(individualChatEntity.getId(), individualChatEntity);
    }
    public IndividualChatEntity getIndividualChat(BigInteger id) {
        return individualChatMap.get(id);
    }
}