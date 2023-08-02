package indi.midreamsheep.schatapp.backend.chat.system;

import indi.midreamsheep.schatapp.backend.chat.message.ChatType;
import indi.midreamsheep.schatapp.backend.protocol.Result;
import indi.midreamsheep.schatapp.backend.protocol.ResultEnum;
import indi.midreamsheep.schatapp.backend.api.chat.handler.annotation.ChatHandler;
import indi.midreamsheep.schatapp.backend.api.scan.inter.ChatHandlerInter;
import indi.midreamsheep.schatapp.backend.service.chat.ChannelManager;
import indi.midreamsheep.schatapp.backend.until.json.JsonUtil;
import io.netty.channel.ChannelHandlerContext;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@ChatHandler(type = ChatType.SYSTEM, mapping = "login")
@Component
public class SystemLoginHandler implements ChatHandlerInter {

    @Resource
    private ChannelManager channelManager;

    @Override
    public Result handle(ChannelHandlerContext ctx, String data) {
        PrivateKey jsonToBean = JsonUtil.getJsonToBean(data, PrivateKey.class);
        //空检查
        if (jsonToBean == null || jsonToBean.getPrivateKey() == null) {
            return new Result(ResultEnum.ERROR, "privateKey is null");
        }
        //TODO 向数据库进行检验并获取用户信息
        //TODO 存储用户信息
        //TODO 通道管理
        return new Result(ResultEnum.SUCCESS, "login success");
    }
}
