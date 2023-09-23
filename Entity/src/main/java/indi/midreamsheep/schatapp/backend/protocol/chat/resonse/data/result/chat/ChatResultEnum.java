package indi.midreamsheep.schatapp.backend.protocol.chat.resonse.data.result.chat;

import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.data.result.ResultData;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 聊天模块的错误码和错误信息
 * */
@AllArgsConstructor
@Getter
public enum ChatResultEnum implements ResultData {
    SUCCESS(200, "success"),
    ERROR(500, "error"),
    NOT_FOUND(404, "request processor not found"),
    ACCESS_CHECK_FAILED(325, "user permissions are not passed"),
    MALFORMED_REQUEST(403, "malformed request")
    ;
    private final int code;
    private final String msg;

    
}
