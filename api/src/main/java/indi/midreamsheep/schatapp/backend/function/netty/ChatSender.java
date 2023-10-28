package indi.midreamsheep.schatapp.backend.function.netty;

import indi.midreamsheep.schatapp.backend.entity.protocol.chat.resonse.ChatTransmission;

public interface ChatSender {
    void send(ChatTransmission chatTransmission);
}
