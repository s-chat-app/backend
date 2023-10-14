package indi.midreamsheep.schatapp.backend.entity.chat.transmission;

import indi.midreamsheep.schatapp.backend.util.json.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户的编辑消息接收实体类
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditMessage {
    private long messageTo;
    private String message;
    private long editId;

    @Override
    public String toString() {
        return JsonUtil.getBeanToJson(this);
    }
}
