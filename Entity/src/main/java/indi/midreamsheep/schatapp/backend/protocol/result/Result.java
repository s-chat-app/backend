package indi.midreamsheep.schatapp.backend.protocol.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于服务器对用户端数据的回应
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    /**
     * 数据id
     * 对于服务端无用,只用于客户端判断数据是对应哪个请求的回应
     * */
    private int id;
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

    public Result(ResultEnum resultEnum,int id) {
        new Result(resultEnum, id,"");
    }
    public Result(ResultEnum resultEnum,int id,String data) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.data = data;
        this.id = id;
    }
}