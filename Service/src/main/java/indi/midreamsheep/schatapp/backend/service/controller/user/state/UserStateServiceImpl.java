package indi.midreamsheep.schatapp.backend.service.controller.user.state;

import indi.midreamsheep.schatapp.backend.function.dao.controller.UserAliveMapperHandler;
import indi.midreamsheep.schatapp.backend.service.controller.user.UserStateService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class UserStateServiceImpl implements UserStateService {

    @Resource
    private UserAliveMapperHandler userAliveMapperHandler;

    public long getUserId(String privateKey) {
        return userAliveMapperHandler.getUserId(privateKey);
    }

    @Override
    public void addUser(String privateKey, long id) {
        userAliveMapperHandler.addUser(id,privateKey);
    }
}