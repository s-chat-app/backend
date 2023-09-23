package indi.midreamsheep.schatapp.backend.service.dao.mysql;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.ChatTransmissionData;
import indi.midreamsheep.schatapp.backend.util.json.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("message")
public class Message implements ChatTransmissionData {
    @TableId("id")
    private long id;
    @TableField("type")
    private int type;
    @TableField("message")
    private String message;
    @TableField("message_to")
    private long messageTo;
    @TableField("message_from")
    private long messageFrom;
    @TableField("message_time")
    private Timestamp messageTime;

    @Override
    public String toString() {
        return JsonUtil.getBeanToJson(this);
    }
}
