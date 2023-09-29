package indi.midreamsheep.schatapp.backend.service.dao;

import indi.midreamsheep.schatapp.backend.service.service.controller.user.login.LoginTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    /**user id*/
    private long userId;
    /**登录的方式 见{@link LoginTypeEnum}*/
    private int loginType;
    /**密码*/
    private String pwd;
    /**token*/
    private String token;
}
