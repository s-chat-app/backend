package indi.midreamsheep.schatapp.backend.chat.account;

import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.ResponseProcessor;
import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.ChatTransmissionEnum;
import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.ChatTransmissionData;
import indi.midreamsheep.schatapp.backend.protocol.ecc.EccKey;
import indi.midreamsheep.schatapp.backend.service.dao.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

/**
 * 用户类
 * 用于存储用户的信息，包括用户的id，用户的密钥，用户的通道，用户的好友列表，用户的群组列表，用户的通道列表
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class SChatUser {
    /**用户id*/
    private long id;
    /**用户信息*/
    private User userData;
    /**用户密钥*/
    private String privateKey;
    /**通道*/
    private Channel channel;
    /**好友列表*/
    private long[] individuals;
    /**群组列表*/
    private long[] groups;
    /**通道列表*/
    private long[] channels;

    private String AESKey;

    public void receive(ChatTransmissionEnum type, ChatTransmissionData data, long from){
        ResponseProcessor.write(channel,ResponseProcessor.makeResponse(type.getCode(),data));
        log.info("{} receive message from {}", id, from);
    }
    public void receiveResult(long messageId, ChatTransmissionEnum type, ChatTransmissionData data, long from){
        ResponseProcessor.write(channel,ResponseProcessor.makeResultResponse(messageId,type.getCode(),data));
        log.info("{} receive message from {}", id, from);
    }
}