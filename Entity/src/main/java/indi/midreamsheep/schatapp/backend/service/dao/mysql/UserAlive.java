package indi.midreamsheep.schatapp.backend.service.dao.mysql;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户登录列表
 * */
@TableName("user_alive")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAlive {
    @TableId("user_id")
    private long userId;
    @TableField("private_key")
    private String privateKey;
}
