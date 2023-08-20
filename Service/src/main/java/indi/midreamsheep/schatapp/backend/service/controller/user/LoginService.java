package indi.midreamsheep.schatapp.backend.service.controller.user;

/**
 * 登录相关的服务
 * */
public interface LoginService {
    String loginByPwd(long userId, String password);
    String loginByToken(String token);
    String loginByServer(String serverToken);
}
