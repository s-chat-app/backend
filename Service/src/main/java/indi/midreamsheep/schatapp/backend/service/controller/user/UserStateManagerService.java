package indi.midreamsheep.schatapp.backend.service.controller.user;

public interface UserStateManagerService {
    long getUserId(long privateKey);
    void addUser(long privateKey,long id);
}
