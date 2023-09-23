package indi.midreamsheep.schatapp.backend.dao.controller;

public interface UserAliveMapperHandler {
    void addUser(long id,String privateKey);
    long getUserId(String privateKey);
    void deleteUser(String privateKey,long id);
}
