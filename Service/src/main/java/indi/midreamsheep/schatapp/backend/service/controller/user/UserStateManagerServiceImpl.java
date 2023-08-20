package indi.midreamsheep.schatapp.backend.service.controller.user;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserStateManagerServiceImpl implements UserStateManagerService {

    private final Map<Long,Long> userMap = new ConcurrentHashMap<>();
    public long getUserId(long privateKey) {
        return userMap.containsKey(privateKey) ? userMap.get(privateKey) : -1;
    }

    @Override
    public void addUser(long privateKey, long id) {
        userMap.put(privateKey,id);
    }
}
