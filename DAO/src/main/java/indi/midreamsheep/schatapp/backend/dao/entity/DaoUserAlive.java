package indi.midreamsheep.schatapp.backend.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class DaoUserAlive {
    @TableId(value = "user_id",type = IdType.ASSIGN_ID)
    private Long userId;
    @TableField("private_key")
    private String privateKey;
}
