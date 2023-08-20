package indi.midreamsheep.schatapp.backend.util.entity;

import org.springframework.util.DigestUtils;

/**
 * id相关的工具类
 * */
public class IdUtil {
    public static long generateId() {
        return cn.hutool.core.util.IdUtil.getSnowflake().nextId();
    }

    public static String generatePrivateKey(long id) {
        return DigestUtils.md5DigestAsHex((cn.hutool.core.util.IdUtil.fastSimpleUUID() + id).getBytes());
    }
}
