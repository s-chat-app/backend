package indi.midreamsheep.schatapp.backend.service.user;

public interface UserStateManager {
    long getUserId(long privateKey);
    void addUser(long privateKey,long id);
}
