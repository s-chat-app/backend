package indi.midreamsheep.schatapp.backend.dao.mysql.handle.controller.user;

import indi.midreamsheep.schatapp.backend.service.dao.mysql.Account;

/**
 * 登录注册相关的数据库操作
 * */
public interface AccountMapperHandler {
    Account getAccountByPwd(long userId, String password);
    Account getAccountByToken(String token);
}
