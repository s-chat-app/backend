package indi.midreamsheep.schatapp.backend.protocol.transmission;

import indi.midreamsheep.schatapp.backend.protocol.data.ChatTransmissionData;
import indi.midreamsheep.schatapp.backend.util.json.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
