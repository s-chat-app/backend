package indi.midreamsheep.schatapp.backend.protocol.chat.resonse;

import indi.midreamsheep.schatapp.backend.api.chat.exception.ChatException;
import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.data.result.Result;
import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.data.result.chat.ChatResultEnum;
import io.netty.channel.Channel;


/**
 * Create response string or send a response via ChannelHandlerContext
 * @author midreamsheep
 */
public final class ResponseProcessor {

    public static void write(Channel channel, ChatTransmission transmission){
        channel.writeAndFlush(transmission.toString());
    }


    public static ChatTransmission makeResultResponse(long messageId, int type, ChatException t){
        ChatTransmission transmission = new ChatTransmission();
        transmission.setId(messageId);
        transmission.setType(type);
        transmission.setData(new Result(t.getCode(),t.getMsg(), t.getMessage()));
        return transmission;
    }

    public static ChatTransmission makeResultResponse(long messageId, int type, String msg){
        ChatTransmission transmission = new ChatTransmission();
        transmission.setId(messageId);
        transmission.setType(type);
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