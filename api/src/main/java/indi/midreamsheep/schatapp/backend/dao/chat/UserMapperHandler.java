package indi.midreamsheep.schatapp.backend.dao.chat;

import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;

/**
 * 持久层跟用户相关的操作
 * */
public interface UserMapperHandler {
    /**
     * 通过用户id获取用户信息
     * 需要注入的数据 除开channel privateKey
     * @param id 用户id
     * @return 用户信息
     * */
    SChatUser getUserById(long id);
}
