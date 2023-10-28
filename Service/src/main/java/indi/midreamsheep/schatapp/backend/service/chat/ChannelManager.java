package indi.midreamsheep.schatapp.backend.service.chat;

import indi.midreamsheep.schatapp.backend.entity.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.function.netty.ChatSender;
import io.netty.channel.Channel;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
public class ChannelManager {

    //在线用户的对应表
    private final Map<ChatSender,SChatUser> channelMap = new HashMap<>();

    public void addChannel(SChatUser user) {
        channelMap.put(user.getSender(), user);
    }

    public void removeChannel(ChatSender sender) {
        channelMap.remove(sender);
    }

    public SChatUser getUser(ChatSender sender) {
        return channelMap.get(sender
        );
    }
}
