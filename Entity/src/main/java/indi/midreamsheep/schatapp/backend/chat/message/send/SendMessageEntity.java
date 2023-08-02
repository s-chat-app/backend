package indi.midreamsheep.schatapp.backend.chat.message.send;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendMessageEntity {
    private int type;
    private int messageType;
    private String message;
    private String messageTo;
    private String messageFrom;
}
