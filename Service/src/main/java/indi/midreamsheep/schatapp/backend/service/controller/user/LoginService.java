package indi.midreamsheep.schatapp.backend.service.controller.user;

public interface LoginService {
    String loginByPwd(long userId, String password);
    String loginByToken(String token);
    String loginByServer(String serverToken);
}
