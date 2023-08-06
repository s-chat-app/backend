package indi.midreamsheep.schatapp.backend.chat.account;

import indi.midreamsheep.schatapp.backend.protocol.ChatTransmission;
import indi.midreamsheep.schatapp.backend.protocol.ResponseProcessor;
import indi.midreamsheep.schatapp.backend.protocol.TransmissionEnum;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.Message;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.User;
import indi.midreamsheep.schatapp.backend.util.json.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.netty.channel.Channel;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SChatUser {
    /**用户id*/
    private long id;
    /**用户名*/
    private User userData;
    /**用户密钥*/
    private long privateKey;
    /**通道*/
    private Channel channel;
    /**好友列表*/
    private long[] individuals;
    /**群组列表*/
    private long[] groups;
    /**通道列表*/
    private long[] channels;

    public void receive(Message data) {
        channel.writeAndFlush(ResponseProcessor.makeExceptionResponse(-1,TransmissionEnum.SEND_MESSAGE.getCode(), data));
    }
}