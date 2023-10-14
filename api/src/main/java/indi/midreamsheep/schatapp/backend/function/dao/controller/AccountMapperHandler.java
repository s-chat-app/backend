package indi.midreamsheep.schatapp.backend.function.dao.controller;

import indi.midreamsheep.schatapp.backend.entity.service.dao.Account;

/**
 * 登录注册相关的数据库操作
 * */
public interface AccountMapperHandler {
    Account getAccountByPwd(long userId, String password);
    Account getAccountByToken(String token);
}
