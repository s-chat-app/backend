package indi.midreamsheep.schatapp.backend.protocol.chat;

import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.ChatTransmission;
import indi.midreamsheep.schatapp.backend.util.protocol.AesUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * 解决netty半包粘包问题的自定义协议
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageProtocol {
    private int len;
    private byte[] content;

    public MessageProtocol(String content,String privateKey) throws Exception {
        String encrypt = AesUtil.Encrypt(content, privateKey);
        this.content = Objects.requireNonNull(encrypt).getBytes();
        this.len = this.content.length;
    }

    public MessageProtocol(String content) {
        this.content = content.getBytes();
        this.len = this.content.length;
    }

    public MessageProtocol(ChatTransmission chatTransmission) {
        this(chatTransmission.toString());
    }

    public MessageProtocol(ChatTransmission chatTransmission,String privateKey) throws Exception {
        this(chatTransmission.toString(),privateKey);
    }
}
