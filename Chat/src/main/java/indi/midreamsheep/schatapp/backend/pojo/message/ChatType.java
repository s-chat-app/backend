package indi.midreamsheep.schatapp.backend.pojo.message;

import lombok.Getter;

@Getter
public enum ChatType {
    INDIVIDUAL(0),
    GROUP(1),
    SYSTEM(2);
    private final int id;

    ChatType(int id) {
        this.id = id;
    }

    public static ChatType valueOf(int id) {
        for (ChatType type : values()) {
            if (type.id == id) {
                return type;
            }
        }
        return null;
    }
}
