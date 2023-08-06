package indi.midreamsheep.schatapp.backend.util.entity;

import java.sql.Timestamp;

public final class TimeUtil {
    public static Timestamp now() {
        return new Timestamp(System.currentTimeMillis());
    }
}
