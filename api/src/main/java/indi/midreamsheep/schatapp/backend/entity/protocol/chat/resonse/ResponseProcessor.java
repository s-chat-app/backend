package indi.midreamsheep.schatapp.backend.entity.protocol.chat.resonse;

import indi.midreamsheep.schatapp.backend.entity.api.chat.exception.ChatException;
import indi.midreamsheep.schatapp.backend.entity.protocol.chat.resonse.data.result.Result;
import indi.midreamsheep.schatapp.backend.entity.protocol.chat.resonse.data.result.chat.ChatResultEnum;
import indi.midreamsheep.schatapp.backend.function.netty.ChatSender;
import io.netty.channel.Channel;


/**
 * Create response string or send a response via ChannelHandlerContext
 * @author midreamsheep
 */
public final class ResponseProcessor {

    public static void write(ChatSender sender, ChatTransmission transmission){
        sender.send(transmission);
    }


    public static ChatTransmission makeResultResponse(long messageId, int type, ChatException t){
        ChatTransmission transmission = new ChatTransmission();
        transmission.setId(messageId);
        transmission.setType(type);
        transmission.setData(new Result(t.getCode(),t.getMsg(), t.getMessage()));
        return transmission;
    }

    public static ChatTransmission makeResultResponse(long messageId, String msg){
        ChatTransmission transmission = new ChatTransmission();
        transmission.setId(messageId);
        transmission.setData(new Result(ChatResultEnum.ERROR,msg));
        return transmission;
    }

    public static ChatTransmission makeResultResponse(long messageId, int type, ChatTransmissionData data){
        ChatTransmission transmission = new ChatTransmission();
        transmission.setId(messageId);
        transmission.setType(type);
        transmission.setData(data);
        return transmission;
    }

    public static ChatTransmission makeResponse(int type, ChatTransmissionData data){
        ChatTransmission transmission = new ChatTransmission();
        transmission.setId(-1);
        transmission.setType(type);
        transmission.setData(data);
        return transmission;
    }

}
