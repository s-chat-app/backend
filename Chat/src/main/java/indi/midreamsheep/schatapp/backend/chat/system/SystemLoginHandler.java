package indi.midreamsheep.schatapp.backend.chat.system;

import indi.midreamsheep.schatapp.backend.chat.ChatMessage;
import indi.midreamsheep.schatapp.backend.chat.message.ChatType;
import indi.midreamsheep.schatapp.backend.protocol.Result;
import indi.midreamsheep.schatapp.backend.protocol.ResultEnum;
import indi.midreamsheep.schatapp.backend.api.chat.handler.annotation.ChatHandler;
import indi.midreamsheep.schatapp.backend.api.scan.inter.ChatHandlerInter;
import indi.midreamsheep.schatapp.backend.service.chat.ChannelManager;
import indi.midreamsheep.schatapp.backend.service.chat.system.login.ChatLoginService;
import indi.midreamsheep.schatapp.backend.until.json.JsonUtil;
import io.netty.channel.ChannelHandlerContext;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@ChatHandler(type = ChatType.SYSTEM, mapping = "LOGIN")
@Component
public class SystemLoginHandler implements ChatHandlerInter {

    @Resource
    private ChatLoginService chatLoginService;

    @Override
    public Result handle(ChannelHandlerContext ctx, ChatMessage data) {
        PrivateKey jsonToBean = JsonUtil.getJsonToBean(data.getData(), PrivateKey.class);
        //空检查
        if (jsonToBean == null || jsonToBean.getPrivateKey() == null) {
            return new Result(ResultEnum.ERROR, data.getId(),"privateKey is null");
        }
        chatLoginService.login(ctx, jsonToBean);
        return new Result(ResultEnum.SUCCESS,data.getId(), "login success");
    }
}
