package indi.midreamsheep.schatapp.backend.protocol;

import indi.midreamsheep.schatapp.backend.api.chat.exception.ChatException;
import indi.midreamsheep.schatapp.backend.protocol.ChatTransmission;
import indi.midreamsheep.schatapp.backend.protocol.data.ChatTransmissionData;
import indi.midreamsheep.schatapp.backend.protocol.data.result.Result;
import indi.midreamsheep.schatapp.backend.protocol.data.result.ResultEnum;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.Message;
import org.springframework.stereotype.Component;


/**
 * Create response string or send a response via ChannelHandlerContext
 * @author midreamsheep
 */
public final class ResponseProcessor {
    public static ChatTransmission makeExceptionResponse(long messageId, int type, ChatException t){
        ChatTransmission transmission = new ChatTransmission();
        transmission.setId(messageId);
        transmission.setType(type);
        transmission.setData(new Result(t.getCode(),t.getMsg(), t.getMessage()).toString());
        return transmission;
    }

    public static ChatTransmission makeExceptionResponse(long messageId, int type, String msg){
        ChatTransmission transmission = new ChatTransmission();
        transmission.setId(messageId);
        transmission.setType(type);
        transmission.setData(new Result(ResultEnum.ERROR,msg).toString());
        return transmission;
    }

    public static ChatTransmission makeExceptionResponse(long messageId, int type, ChatTransmissionData data){
        return makeExceptionResponse(messageId, type, data.toJson());
    }
}
