package indi.midreamsheep.schatapp.backend.chat;

import com.alibaba.fastjson.JSONException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    private long id;
    private int type;
    private String mapping;
    private String data;

    public void check() throws Exception{
        if (id <= 0) throw new JSONException("id error");
        if (type <= 0 || type > 3) throw new JSONException("type error");
        if (data == null || data.isEmpty()) throw new JSONException("data error");
        if (mapping == null || mapping.isEmpty()) throw new JSONException("mapping error");
    }
}
