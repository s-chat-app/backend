package indi.midreamsheep.schatapp.backend.config;

import indi.midreamsheep.schatapp.backend.service.service.controller.user.login.LoginTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 读取资源文件配置
 * 用于自定义配置
 * */
@Component
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SChatConfig {
    /**
     * 服务器登录类型
     * {@link LoginTypeEnum}
     * */
    private LoginTypeEnum loginType = LoginTypeEnum.PWD;
}
