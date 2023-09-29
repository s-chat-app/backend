package indi.midreamsheep.schatapp.backend.dao.config.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * redis配置类
 * */
@ConfigurationProperties(prefix = "spring.redis")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class RedisConfig {
    private String host;
    private int port;
    private int timeout;//秒
    private String password;
    private int poolMaxTotal;
    private int poolMaxIdle;
    private int poolMaxWait;
}
