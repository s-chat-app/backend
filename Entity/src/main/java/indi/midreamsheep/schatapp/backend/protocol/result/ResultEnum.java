package indi.midreamsheep.schatapp.backend.protocol.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResultEnum {
    SUCCESS(200, "success"),
    ERROR(500, "error"),
    NOT_FOUND(404, "request processor not found"),
    ACCESS_CHECK_FAILED(325, "user permissions are not passed"),
    ;
    private final int code;
    private final String msg;
}
