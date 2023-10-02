package indi.midreamsheep.schatapp.backend.service.chat;

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
        System.out.println(user.getChannel().hashCode());
    }

    public void removeChannel(Channel channel) {
        channelMap.remove(channel);
    }

    public SChatUser getUser(Channel channel) {
        return channelMap.get(channel);
    }
}
