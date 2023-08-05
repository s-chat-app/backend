package indi.midreamsheep.schatapp.backend.protocol;

import indi.midreamsheep.schatapp.backend.util.json.JsonUtil;
import indi.midreamsheep.schatapp.backend.util.response.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChatDataProtocol {
    /*消息的对应的消息id 为-1则为服务端主动发送的数据*/
    private long id;
    /*消息的类型*/
    private int type;
    /*消息的具体数据*/
    private String data;

    @Override
    public String toString() {
        return JsonUtil.getBeanToJson(this);
    }

    public ChatDataProtocol(long id, ChatDataTypeEnum type, Result result){
        this.id = id;
        this.type = type.getCode();
        this.data = result.toString();
    }
}