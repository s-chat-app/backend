package indi.midreamsheep.schatapp.backend.chat;

import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import io.netty.channel.Channel;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
public class ChannelManager {

    //在线用户的对应表
    private final Map<Channel,SChatUser> channelMap = new HashMap<>();

    public void addChannel(SChatUser user) {
        channelMap.put(user.getChannel(), user);
        //分别添加到好友、群组、频道的通道中 TODO
    }
}
