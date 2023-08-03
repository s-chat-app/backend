package indi.midreamsheep.schatapp.backend.protocol.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于服务器主动向客户端发送的数据
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatDataSender {
    private int type;
    private String data;
}
