package indi.midreamsheep.schatapp.backend.protocol.chat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ChatDataSenderTypeEnum {
    SEND(1),;
    private final int type;

    public static ChatDataSenderTypeEnum valueOf(int type) {
        for (ChatDataSenderTypeEnum value : ChatDataSenderTypeEnum.values()) {
            if (value.type == type) {
                return value;
            }
        }
        return null;
    }

}
