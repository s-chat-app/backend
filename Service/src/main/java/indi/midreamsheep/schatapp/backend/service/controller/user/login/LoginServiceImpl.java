package indi.midreamsheep.schatapp.backend.service.controller.user.login;

import indi.midreamsheep.schatapp.backend.dao.controller.AccountMapperHandler;
import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.data.result.Result;
import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.data.result.login.LoginResultEnum;
import indi.midreamsheep.schatapp.backend.service.controller.user.LoginService;
import indi.midreamsheep.schatapp.backend.service.controller.user.UserStateService;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.Account;
import indi.midreamsheep.schatapp.backend.util.entity.IdUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserStateService userStateService;

    @Resource
    private AccountMapperHandler accountMapperHandler;

    @Override
    public String loginByPwd(long userId, String password) {
        Account accountByPwd = accountMapperHandler.getAccountByPwd(userId, password);
        if (accountByPwd != null) {
            //生成token
            String privateKey = IdUtil.generatePrivateKey(accountByPwd.getUserId());
            userStateService.addUser(privateKey, accountByPwd.getUserId());
            return new Result(LoginResultEnum.SUCCESS,privateKey).toString();
        }
        return new Result(LoginResultEnum.ERROR,"error password or user is not exist").toString();
    }

    @Override
    public String loginByToken(String token) {
        Account accountByToken = accountMapperHandler.getAccountByToken(token);
        if (accountByToken != null) {
            //TODO 生成权限token 插入token表
            String privateKey = IdUtil.generatePrivateKey(accountByToken.getUserId());
            userStateService.addUser(privateKey, accountByToken.getUserId());
            return new Result(LoginResultEnum.SUCCESS,privateKey).toString();
        }
        return new Result(LoginResultEnum.ERROR,"error token,please check the input or get a new token from the owner").toString();
    }

    @Override
    public String loginByServer(String serverToken) {
        //TODO 通过serverToken进行登录
        return null;
    }
}
