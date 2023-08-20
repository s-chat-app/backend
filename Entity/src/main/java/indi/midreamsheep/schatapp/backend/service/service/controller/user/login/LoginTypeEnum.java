package indi.midreamsheep.schatapp.backend.service.service.controller.user.login;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 登录方式枚举类
 * @see LoginTypeEnum#PWD 通过账号密码登录
 * @see LoginTypeEnum#TOKEN 通过群聊提供的token进行登录
 * @see LoginTypeEnum#SERVER 通过中心服务器进行登录
 * */
@Getter
@AllArgsConstructor
public enum LoginTypeEnum {
    /**Login by password*/
    PWD(0,"password"),
    /**Login by token*/
    TOKEN(1,"token"),
    /**Login by server*/
    SERVER(2,"server_token")
    ;
    private final int type;
    private final String name;

    public static LoginTypeEnum getLoginType(int type) {
        for (LoginTypeEnum loginTypeEnum : LoginTypeEnum.values()) {
            if (loginTypeEnum.getType() == type) {
                return loginTypeEnum;
            }
        }
        return null;
    }
}
