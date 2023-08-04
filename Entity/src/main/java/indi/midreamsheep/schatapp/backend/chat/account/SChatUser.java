package indi.midreamsheep.schatapp.backend.chat.account;

import indi.midreamsheep.schatapp.backend.protocol.chat.ChatDataSender;
import indi.midreamsheep.schatapp.backend.protocol.chat.ChatDataSenderTypeEnum;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.Message;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.User;
import indi.midreamsheep.schatapp.backend.until.json.JsonUtil;
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
        channel.writeAndFlush(JsonUtil.getBeanToJson(new ChatDataSender(ChatDataSenderTypeEnum.SEND.getType(), JsonUtil.getBeanToJson(data))));
    }
}