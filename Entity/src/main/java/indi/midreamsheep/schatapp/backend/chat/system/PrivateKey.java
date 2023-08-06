package indi.midreamsheep.schatapp.backend.chat.system;

import indi.midreamsheep.schatapp.backend.api.chat.exception.ChatException;
import indi.midreamsheep.schatapp.backend.util.json.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrivateKey {
    private long privateKey;

    @Override
    public String toString() {
        return JsonUtil.getBeanToJson(this);
    }

    public void check() {
        if (privateKey == 0) {
            throw new ChatException("privateKey is null or json string is not correct");
        }
    }
}
