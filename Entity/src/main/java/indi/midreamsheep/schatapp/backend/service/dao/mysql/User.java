package indi.midreamsheep.schatapp.backend.service.dao.mysql;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;
import java.sql.Timestamp;

@Data
@TableName("user")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId("id")
    private BigInteger id;
    @TableField("name")
    private String name;
    @TableField("data")
    private String data;
    @TableField("create_time")
    private Timestamp createTime;
}
