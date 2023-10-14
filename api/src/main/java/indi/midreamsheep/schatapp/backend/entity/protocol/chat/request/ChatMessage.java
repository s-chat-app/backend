package indi.midreamsheep.schatapp.backend.entity.protocol.chat.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 聊天消息类
 * 用于接收用户发送的消息
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    /**
     * 映射长度
     * */
    private int mappingLength;
    /**
     * 消息的mapping
     * 用于告诉后端这个消息的处理器是什么
     * */
    private String mapping;
    /**
     * 消息的对应的消息id则为异常数据
     * 用于返回给用户告诉用户是那个请求的返回值
     * */
    private long id;
    /**
     * 消息长度
     * */
    private int dataLength;
    /**
     * 消息的具体数据
     * 用于告诉后端这个消息的具体数据
     * */
    private String data;

    public boolean check(){
        return !(id<=0 || mappingLength<=0 || dataLength<=0 || mapping.isEmpty() || data.isEmpty());
    }
}
