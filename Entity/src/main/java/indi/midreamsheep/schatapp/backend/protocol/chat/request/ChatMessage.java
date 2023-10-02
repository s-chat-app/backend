package indi.midreamsheep.schatapp.backend.protocol.chat.request;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
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
     * 消息的对应的消息id则为异常数据
     * 用于返回给用户告诉用户是那个请求的返回值
     * */
    private long id;
    /**
     * 消息的类型
     * 用于告诉后端这个消息是什么类型的消息
     * 标准后端所包含的类型见{@link ChatType}
     * */
    private int type;
    /**
     * 消息的mapping
     * 用于告诉后端这个消息的处理器是什么
     * */
    private String mapping;
    /**
     * 消息的具体数据
     * 用于告诉后端这个消息的具体数据
     * */
    private String data;

    public void check() throws Exception{
        if (id <= 0) throw new JSONException("id error");
        if (type <= 0 || type > 3) throw new JSONException("type error");
        if (data == null) throw new JSONException("data error");
        if (mapping == null || mapping.isEmpty()) throw new JSONException("mapping error");
    }
}
