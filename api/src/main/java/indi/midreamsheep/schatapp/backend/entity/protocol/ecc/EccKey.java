package indi.midreamsheep.schatapp.backend.entity.protocol.ecc;

import indi.midreamsheep.schatapp.backend.util.json.JsonUtil;
import lombok.Data;

@Data
public class EccKey {
    private String privateKey;

    @Override
    public String toString() {
        return JsonUtil.getBeanToJson(this);
    }
}
