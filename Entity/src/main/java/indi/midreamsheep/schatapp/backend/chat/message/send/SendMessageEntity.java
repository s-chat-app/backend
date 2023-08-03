package indi.midreamsheep.schatapp.backend.chat.message.send;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendMessageEntity {
    private long id;
    private int type;
    private int messageType;
    private String message;
    private long messageTo;
    private long messageFrom;
    private Timestamp messageTime;
}
