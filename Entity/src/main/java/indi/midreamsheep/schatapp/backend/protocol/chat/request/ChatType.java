package indi.midreamsheep.schatapp.backend.protocol.chat.request;

import lombok.Getter;

@Getter
public enum ChatType {
    SYSTEM(1),
    INDIVIDUAL(2),
    GROUP(3),
    CHANNEL(4);
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
        return SYSTEM;
    }
}
