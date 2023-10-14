package indi.midreamsheep.schatapp.backend.entity.protocol.chat.resonse.data.result;

/**
 * result的数据接口
 * 用于返回数据，自定义特定的错误码和错误信息
 * 使用: 枚举类实现该接口，然后在枚举类中定义错误码和错误信息
 * */
public interface ResultData {
    /**
     * @return 错误码
     * */
    int getCode();
    /**
     * @return 错误信息
     * */
    String getMsg();
}