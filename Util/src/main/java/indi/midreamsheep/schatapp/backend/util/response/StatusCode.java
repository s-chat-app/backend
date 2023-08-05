package indi.midreamsheep.schatapp.backend.util.response;

import com.alibaba.druid.support.spring.stat.annotation.Stat;
import lombok.Getter;
import lombok.Setter;

/**
 * An exception to pass an unexpected situation to the client
 * @author lsk
 */

@Getter
@Setter
public class StatusCode extends RuntimeException{
    /**
     * status code, default 500, for an unknown exception
     * its value comes from the value of ResultEnum
     */
    private int code = 500;

    /**
     * message id, may be useful
     */
    private long messageId = -1;

    /**
     * Create a StatusCode
     * @param resultEnum the result status
     * @param message error message
     */
    public StatusCode(ResultEnum resultEnum, String message) {
        super(message);
        this.code = resultEnum.getCode();
    }

    /**
     * Creates a StatusCode
     * @param resultEnum the result status
     * @param messageId messageId that may be used
     * @param message message
     */
    public StatusCode(ResultEnum resultEnum, long messageId, String message) {
        super(message);
        this.code = resultEnum.getCode();
        this.messageId = messageId;
    }

    /**
     * Create a StatusCode
     * @param resultEnum the result status
     * @param message error message
     * @param t parent exception
     */
    public StatusCode(ResultEnum resultEnum, String message, Throwable t) {
        super(message, t);
        this.code = resultEnum.getCode();
    }

    /**
     * Create a StatusCode
     * @param resultEnum the result status
     * @param messageId messageId that may be used
     * @param message message
     * @param t parent exception
     */
    public StatusCode(ResultEnum resultEnum, long messageId, String message, Throwable t) {
        super(message, t);
        this.code = resultEnum.getCode();
        this.messageId = messageId;
    }

    /**
     * Create a StatusCode
     * @param resultEnum the result status
     */
    public StatusCode(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
    /**
     * Create a StatusCode
     * @param t parent exception
     */
    public StatusCode(Throwable t) {
        super(t);
    }

}
