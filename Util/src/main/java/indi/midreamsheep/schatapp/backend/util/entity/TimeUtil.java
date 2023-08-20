package indi.midreamsheep.schatapp.backend.util.entity;

import java.sql.Timestamp;

/**
 * 时间相关的工具类
 * */
public final class TimeUtil {
    public static Timestamp now() {
        return new Timestamp(System.currentTimeMillis());
    }
}
