package indi.midreamsheep.schatapp.backend.protocol.result.login;

import indi.midreamsheep.schatapp.backend.protocol.result.ResultData;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 登录结果枚举类
 * */
@AllArgsConstructor
@Getter
public enum LoginResultEnum implements ResultData {
    NOT_SUPPORT_LOGIN_TYPE(1001,"not support login type"),
    SUCCESS(200,"login success"),
    ERROR(500,"login error");
    private final int code;
    private final String msg;

    public static LoginResultEnum valueOf(int code) {
        for (LoginResultEnum e : LoginResultEnum.values()) {
            if (e.code == code) {
                return e;
            }
        }
        return null;
    }

}
