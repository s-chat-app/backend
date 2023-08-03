package indi.midreamsheep.schatapp.backend.service.dao.mysql;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("message")
public class Message {
    @TableId("id")
    private long id;
    @TableField("type")
    private int type;
    @TableField("message_type")
    private int messageType;
    @TableField("message")
    private String message;
    @TableField("message_to")
    private long messageTo;
    @TableField("message_from")
    private long messageFrom;
    @TableField("message_time")
    private Timestamp messageTime;
}
