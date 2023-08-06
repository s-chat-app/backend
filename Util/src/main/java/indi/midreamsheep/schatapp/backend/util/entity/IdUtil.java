package indi.midreamsheep.schatapp.backend.util.entity;

public class IdUtil {
    public static long generateId() {
        return cn.hutool.core.util.IdUtil.getSnowflake().nextId();
    }
}
