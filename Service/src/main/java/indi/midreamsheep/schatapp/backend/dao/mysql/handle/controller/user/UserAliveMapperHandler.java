package indi.midreamsheep.schatapp.backend.dao.mysql.handle.controller.user;

public interface UserAliveMapperHandler {
    void addUser(long id,String privateKey);
    long getUserId(String privateKey);
    void deleteUser(String privateKey,long id);
}
