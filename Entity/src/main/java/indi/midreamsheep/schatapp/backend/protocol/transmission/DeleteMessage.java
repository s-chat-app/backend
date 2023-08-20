package indi.midreamsheep.schatapp.backend.protocol.transmission;

import indi.midreamsheep.schatapp.backend.protocol.chat.ChatTransmissionData;
import indi.midreamsheep.schatapp.backend.util.json.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户删除消息数据的接收实体类
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteMessage implements ChatTransmissionData {
    private long deleteId;

    @Override
    public String toString() {
        return JsonUtil.getBeanToJson(this);
    }

    @Override
    public String toJson() {
        return toString();
    }
}
