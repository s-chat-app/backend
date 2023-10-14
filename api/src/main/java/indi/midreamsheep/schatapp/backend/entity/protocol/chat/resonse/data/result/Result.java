package indi.midreamsheep.schatapp.backend.entity.protocol.chat.resonse.data.result;

import indi.midreamsheep.schatapp.backend.entity.protocol.chat.resonse.ChatTransmissionData;
import indi.midreamsheep.schatapp.backend.util.json.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于服务器对用户端数据的回应
 * 接收{@link ResultData}类
 * 对于特定的处理逻辑可以自定义枚举类实现{@link ResultData}接口
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

    public Result(ResultData resultData) {
        this(resultData,"");
    }
    public Result(ResultData resultData, String data) {
        this.code = resultData.getCode();
        this.msg = resultData.getMsg();
        this.data = data;
    }

    public Result(ResultData resultData,ResultData data){
        this(resultData,JsonUtil.getBeanToJson(data));
    }

    @Override
    public String toString() {
        return JsonUtil.getBeanToJson(this);
    }

}