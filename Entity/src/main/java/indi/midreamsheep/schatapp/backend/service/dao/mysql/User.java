package indi.midreamsheep.schatapp.backend.service.dao.mysql;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@TableName("user")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId("id")
    private int id;
    @TableField("name")
    private String name;
}