package indi.midreamsheep.schatapp.backend.config;

import indi.midreamsheep.schatapp.backend.service.service.controller.user.login.LoginTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**读取资源文件配置*/
@Component
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SChatConfig {
    private LoginTypeEnum loginType = LoginTypeEnum.PWD;
}
