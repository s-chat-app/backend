package indi.midreamsheep.schatapp.backend.chat.account;

import indi.midreamsheep.schatapp.backend.chat.message.send.SendMessageEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.netty.channel.Channel;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SChatUser {
    private long id;
    private String username;
    private String privateKey;
    private Channel channel;

    private long[] friends;
    private long[] groups;
    private long[] channels;

    public void receive(SendMessageEntity data) {
        //TODO 通过通道发送信息
    }
}
