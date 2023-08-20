package indi.midreamsheep.schatapp.backend.service.dao.mysql;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import indi.midreamsheep.schatapp.backend.service.service.controller.user.login.LoginTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    /**user id*/
    @TableId(value = "user_id")
    private long userId;
    /**登录的方式 见{@link LoginTypeEnum}*/
    @TableField("login_type")
    private int loginType;
    /**密码*/
    @TableField("pwd")
    private String pwd;
    /**token*/
    @TableField("token")
    private String token;
}
