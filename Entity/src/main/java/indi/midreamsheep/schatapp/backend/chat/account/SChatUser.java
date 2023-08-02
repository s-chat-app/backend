package indi.midreamsheep.schatapp.backend.chat.account;

import cn.hutool.json.JSONUtil;
import indi.midreamsheep.schatapp.backend.chat.message.send.SendMessageEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.netty.channel.Channel;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SChatUser {
    private String username;
    private String privateKey;
    private Channel channel;

    private BigInteger[] friends;
    private BigInteger[] groups;
    private BigInteger[] channels;

    public void receive(SendMessageEntity data) {
        //TODO 通过通道发送信息
    }
}
