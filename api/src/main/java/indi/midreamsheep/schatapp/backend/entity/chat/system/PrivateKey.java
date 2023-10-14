package indi.midreamsheep.schatapp.backend.entity.chat.system;

import indi.midreamsheep.schatapp.backend.entity.api.chat.exception.ChatException;
import indi.midreamsheep.schatapp.backend.util.json.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrivateKey {
    private String privateKey;

    private String publicKey;

    @Override
    public String toString() {
        return JsonUtil.getBeanToJson(this);
    }

    public void check() {
        if (privateKey.isEmpty()||publicKey.isEmpty()) {
            throw new ChatException("privateKey is null or json string is not correct");
        }
    }
}
