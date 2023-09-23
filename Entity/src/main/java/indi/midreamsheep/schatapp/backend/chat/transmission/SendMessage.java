package indi.midreamsheep.schatapp.backend.chat.transmission;

import indi.midreamsheep.schatapp.backend.util.json.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户的发送消息接收实体类
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendMessage {
    private long messageTo;
    private String message;

    @Override
    public String toString() {
        return JsonUtil.getBeanToJson(this);
    }
}
