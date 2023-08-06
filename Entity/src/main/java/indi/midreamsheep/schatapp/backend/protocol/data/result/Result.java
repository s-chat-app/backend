package indi.midreamsheep.schatapp.backend.protocol.data.result;

import indi.midreamsheep.schatapp.backend.protocol.data.ChatTransmissionData;
import indi.midreamsheep.schatapp.backend.util.json.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于服务器对用户端数据的回应
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result implements ChatTransmissionData {
    /**
     * 响应码
     * */
    private int code;
    /**
     * 响应信息
     * */
    private String msg;
    /**
     * 响应数据
     * */
    private String data;

    public Result(ResultEnum resultEnum) {
        new Result(resultEnum,"");
    }
    public Result(ResultEnum resultEnum, String data) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.data = data;
    }

    @Override
    public String toString() {
        return JsonUtil.getBeanToJson(this);
    }

    @Override
    public String toJson() {
        return toString();
    }
}