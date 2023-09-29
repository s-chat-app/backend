package indi.midreamsheep.schatapp.backend.service.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户登录列表
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAlive {
    private long userId;
    private String privateKey;
}
