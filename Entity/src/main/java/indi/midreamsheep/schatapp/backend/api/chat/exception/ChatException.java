package indi.midreamsheep.schatapp.backend.api.chat.exception;


import indi.midreamsheep.schatapp.backend.protocol.data.result.ResultEnum;
import lombok.Getter;

@Getter
public class ChatException extends RuntimeException{

    /**错误码*/
    private final int code;
    /**错误信息*/
    private final String msg;


    public ChatException(String message) {
            super(message);
            code = ResultEnum.ERROR.getCode();
            msg = ResultEnum.ERROR.getMsg();
    }
    public ChatException(String message,int code,String msg) {
        super(message);
        this.code = code;
        this.msg = msg;
    }
    public ChatException(String message,ResultEnum resultEnum) {
        super(message);
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

}
