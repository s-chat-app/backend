package indi.midreamsheep.schatapp.backend.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ChatDataTypeEnum {
    //账号相关
    LOGIN(1),
    //消息相关，其他用户发的消息的id为-1
    SEND_MESSAGE(2),
    EDIT_MESSAGE(3),
    DELETE_MESSAGE(4),
    //处理器异常
    HANDLER_EXCEPTION(5),
    ;
    private final int code;

    public static ChatDataTypeEnum fromCode(int code) {
        for (ChatDataTypeEnum value : ChatDataTypeEnum.values()) {
            if (value.code == code) {
                return value;
            }
        }
        return null;
    }
}
