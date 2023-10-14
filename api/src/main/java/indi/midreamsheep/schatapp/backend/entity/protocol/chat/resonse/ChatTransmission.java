package indi.midreamsheep.schatapp.backend.entity.protocol.chat.resonse;

import indi.midreamsheep.schatapp.backend.entity.protocol.chat.resonse.data.result.Result;
import indi.midreamsheep.schatapp.backend.util.json.JsonUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 传输层的数据结构,用于后端对客户端的数据的发送
 * 用于传输的数据结构，包含消息的id，消息的类型，消息的具体数据
 * 用于对用户的响应应使用{@link Result}
 * 用于对用户主动传输的数据根据自身需求选择
 * 但必须继承{@link ChatTransmissionData}类
 * */
@NoArgsConstructor
@Data
public class ChatTransmission {
    /**消息的对应的消息id 为-1则为服务端主动发送的数据*/
    private long id;
    /**正常情况下应为{@link ChatTransmissionEnum}的key*/
    private int type;
    /**消息的具体数据*/
    private String data;

    private String AESKey;

    public ChatTransmission(long id, int i, String data) {
        this.id = id;
        this.type = i;
        this.data = data;
    }
    public void setData(ChatTransmissionData data) {
        this.data = data.toString();
    }

    public void setData(String data){
        this.data = data;
    }

    public ChatTransmission(long id, int type, String data, String AESKey) {
        this.id = id;
        this.type = type;
        this.data = data;
        this.AESKey = AESKey;
    }

    public ChatTransmission(long id, int code, ChatTransmissionData data, String AESKey) {
        this(id, code, data.toString(), AESKey);
    }


    public ChatTransmission(long id, ChatTransmissionEnum type, ChatTransmissionData data){
        this(id, type.getCode(), data);
    }

    public ChatTransmission(ChatTransmissionEnum type, ChatTransmissionData data){
        this(-1, type.getCode(), data);
    }

    public ChatTransmission(long i, int code, ChatTransmissionData data) {
        this(i, code, data.toString());
    }

    public ChatTransmission(long id, ChatTransmissionEnum chatTransmissionEnum, Result result, String aesKey) {
        this(id, chatTransmissionEnum.getCode(), result, aesKey);
    }

    @Override
    public String toString() {
        return JsonUtil.getBeanToJson(this);
    }
}