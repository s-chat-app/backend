package indi.midreamsheep.schatapp.backend.service.controller.user;

/**
 * 用户登录状态的管理服务
 * */
public interface UserStateService {
    long getUserId(String privateKey);
    void addUser(String privateKey,long id);
}