package indi.midreamsheep.schatapp.backend.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private int id;
    private int code;
    private String msg;
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