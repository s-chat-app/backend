package indi.midreamsheep.schatapp.backend.chat.account;

import indi.midreamsheep.schatapp.backend.protocol.ChatTransmission;
import indi.midreamsheep.schatapp.backend.protocol.ResponseProcessor;
import indi.midreamsheep.schatapp.backend.protocol.TransmissionEnum;
import indi.midreamsheep.schatapp.backend.protocol.data.ChatTransmissionData;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.Message;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
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

    public void receive(TransmissionEnum type, ChatTransmissionData data, long from){
        ResponseProcessor.write(channel,ResponseProcessor.makeResponse(type.getCode(),data.toJson()));
        log.info("{} receive message from {}", id, from);
    }
    public void receiveResult(long messageId, TransmissionEnum type, ChatTransmissionData data,long from){
        ResponseProcessor.write(channel,ResponseProcessor.makeResultResponse(messageId,type.getCode(),data.toJson()));
        log.info("{} receive message from {}", id, from);
    }
}