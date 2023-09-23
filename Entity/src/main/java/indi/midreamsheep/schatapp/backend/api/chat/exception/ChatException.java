package indi.midreamsheep.schatapp.backend.api.chat.exception;


import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.data.result.chat.ChatResultEnum;
import lombok.Getter;

/**
 * 聊天模块的异常类
 * 用于处理聊天模块的异常
 * 用注解进行异常捕获
 * */
@Getter
public class ChatException extends RuntimeException{

    /**错误码*/
    private final int code;
    /**错误信息*/
    private final String msg;


    public ChatException(String message) {
            super(message);
            code = ChatResultEnum.ERROR.getCode();
            msg = ChatResultEnum.ERROR.getMsg();
    }
    public ChatException(String message,int code,String msg) {
        super(message);
        this.code = code;
        this.msg = msg;
    }
    public ChatException(String message, ChatResultEnum resultEnum) {
        super(message);
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

}
