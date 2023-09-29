package indi.midreamsheep.schatapp.backend.service.dao;

import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.ChatTransmissionData;
import indi.midreamsheep.schatapp.backend.util.json.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message implements ChatTransmissionData {
    private long id;
    private int type;
    private String message;
    private long messageTo;
    private long messageFrom;
    private Timestamp messageTime;

    @Override
    public String toString() {
        return JsonUtil.getBeanToJson(this);
    }
}
