package indi.midreamsheep.schatapp.backend.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    private int type;
    private String mapping;
    private String data;

    public void check() throws Exception{
        if (type <= 0 || type > 3) throw new Exception("type error");
        if (data == null || data.isEmpty()) throw new Exception("data error");
        if (mapping == null || mapping.isEmpty()) throw new Exception("mapping error");
    }
}
