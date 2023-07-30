package indi.midreamsheep.schatapp.backend.chat.message;

import lombok.Data;


@Data
public class MessageEntity {
    private int chatType;
    private String toId;
    private String messageMapping;
    private String dataJson;

}
