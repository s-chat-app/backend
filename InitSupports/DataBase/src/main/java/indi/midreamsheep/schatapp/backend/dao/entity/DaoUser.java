package indi.midreamsheep.schatapp.backend.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@TableName("user")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DaoUser {
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;
    @TableField("name")
    private String name;
    @TableField("data")
    private String data;
    @TableField("create_time")
    private Timestamp time;
}