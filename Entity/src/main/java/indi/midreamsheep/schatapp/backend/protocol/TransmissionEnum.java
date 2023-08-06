package indi.midreamsheep.schatapp.backend.protocol;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TransmissionEnum {
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

    public static TransmissionEnum fromCode(int code) {
        for (TransmissionEnum value : TransmissionEnum.values()) {
            if (value.code == code) {
                return value;
            }
        }
        return null;
    }
}
