package indi.midreamsheep.schatapp.backend.protocol;

import indi.midreamsheep.schatapp.backend.protocol.data.ChatTransmissionData;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.Message;
import indi.midreamsheep.schatapp.backend.util.json.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 传输层的数据结构
 * 用于传输的数据结构，包含消息的id，消息的类型，消息的具体数据
 * 用于对用户的响应应使用{@link indi.midreamsheep.schatapp.backend.protocol.data.result.Result}
 * 用于对用户主动传输的数据根据自身需求选择
 * 但必须继承{@link ChatTransmissionData}类
 * */
@NoArgsConstructor
@Data
public class ChatTransmission {
    /**消息的对应的消息id 为-1则为服务端主动发送的数据*/
    private long id;
    /**正常情况下应为{@link TransmissionEnum}的key*/
    private int type;
    /**消息的具体数据，必须继承标识类{@link ChatTransmissionData}*/
    private String data;

    public ChatTransmission(long id, TransmissionEnum type, ChatTransmissionData data){
        this(id, type.getCode(), data.toJson());
    }

    public ChatTransmission(TransmissionEnum type,ChatTransmissionData data){
        this(-1, type.getCode(), data.toJson());
    }

    private ChatTransmission(long i, int code, String data) {
        this.id = i;
        this.type = code;
        this.data = data;
    }

    @Override
    public String toString() {
        return JsonUtil.getBeanToJson(this);
    }
}