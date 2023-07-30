package indi.midreamsheep.schatapp.backend.entity.message;

import lombok.Data;


@Data
public class MessageEntity {
    private int chatType;
    private String toId;
    private String messageMapping;
    private String dataJson;

}
