package indi.midreamsheep.schatapp.backend.service.controller.user.login;

import indi.midreamsheep.schatapp.backend.dao.mysql.handle.controller.user.AccountMapperHandler;
import indi.midreamsheep.schatapp.backend.protocol.data.result.Result;
import indi.midreamsheep.schatapp.backend.protocol.data.result.login.LoginResultEnum;
import indi.midreamsheep.schatapp.backend.service.controller.user.LoginService;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class LoginServiceImpl implements LoginService {

    @Resource
    private AccountMapperHandler accountMapperHandler;

    @Override
    public String loginByPwd(long userId, String password) {
        Account accountByPwd = accountMapperHandler.getAccountByPwd(userId, password);
        if (accountByPwd != null) {
            //生成token
            //TODO 生成权限token 插入token表
            return new Result(LoginResultEnum.SUCCESS,"生成的token").toJson();
        }
        return new Result(LoginResultEnum.ERROR,"error password or user is not exist").toJson();
    }

    @Override
    public String loginByToken(String token) {
        Account accountByToken = accountMapperHandler.getAccountByToken(token);
        if (accountByToken != null) {
            //TODO 生成权限token 插入token表
            return new Result(LoginResultEnum.SUCCESS,"生成的token").toJson();
        }
        return new Result(LoginResultEnum.ERROR,"error token,please check the input or get a new token from the owner").toJson();
    }

    @Override
    public String loginByServer(String serverToken) {
        //TODO 通过serverToken进行登录
        return null;
    }
}
