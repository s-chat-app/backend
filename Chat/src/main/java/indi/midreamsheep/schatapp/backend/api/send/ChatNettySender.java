package indi.midreamsheep.schatapp.backend.api.send;

import indi.midreamsheep.schatapp.backend.entity.protocol.chat.resonse.ChatTransmission;
import indi.midreamsheep.schatapp.backend.function.netty.ChatSender;
import io.netty.channel.Channel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ChatNettySender implements ChatSender {

    private Channel channel;

    @Override
    public void send(ChatTransmission chatTransmission) {
        channel.writeAndFlush(chatTransmission);
    }

    @Override
    public int hashCode() {
        return channel.hashCode();
    }
}
