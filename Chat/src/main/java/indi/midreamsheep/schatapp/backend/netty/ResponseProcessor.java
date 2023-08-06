package indi.midreamsheep.schatapp.backend.netty;

import com.google.gson.Gson;
import indi.midreamsheep.schatapp.backend.api.exception.ChatException;
import indi.midreamsheep.schatapp.backend.protocol.ChatTransmission;
import indi.midreamsheep.schatapp.backend.protocol.TransmissionEnum;
import indi.midreamsheep.schatapp.backend.util.response.Result;
import indi.midreamsheep.schatapp.backend.util.response.ResultEnum;
import indi.midreamsheep.schatapp.backend.util.response.StatusCode;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Create response string or send a response via ChannelHandlerContext
 * @author midreamsheep
 */
@Component
public final class ResponseProcessor {
    public ChatTransmission makeExceptionResponse(long messageId, int type, ChatException t){
        ChatTransmission transmission = new ChatTransmission();
        transmission.setId(messageId);
        transmission.setType(type);
        transmission.setData(new Result(t.getCode(),t.getMsg(), t.getMessage()).toString());
        return transmission;
    }
}
