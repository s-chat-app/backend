package indi.midreamsheep.schatapp.backend.chat.system;

import indi.midreamsheep.schatapp.backend.chat.ChatMessage;
import indi.midreamsheep.schatapp.backend.chat.message.ChatType;
import indi.midreamsheep.schatapp.backend.protocol.ChatDataProtocol;
import indi.midreamsheep.schatapp.backend.protocol.ChatDataTypeEnum;
import indi.midreamsheep.schatapp.backend.protocol.result.Result;
import indi.midreamsheep.schatapp.backend.protocol.result.ResultEnum;
import indi.midreamsheep.schatapp.backend.api.chat.handler.annotation.ChatHandler;
import indi.midreamsheep.schatapp.backend.api.scan.inter.ChatHandlerInter;
import indi.midreamsheep.schatapp.backend.service.chat.system.login.ChatLoginService;
import indi.midreamsheep.schatapp.backend.until.json.JsonUtil;
import io.netty.channel.ChannelHandlerContext;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@ChatHandler(type = ChatType.SYSTEM, mapping = "LOGIN")
@Component
@Slf4j
public class SystemLoginHandler implements ChatHandlerInter {

    @Resource
    private ChatLoginService chatLoginService;

    @Override
    public ChatDataProtocol handle(ChannelHandlerContext ctx, ChatMessage data) {
        log.info("一个用户登录");
        PrivateKey jsonToBean = JsonUtil.getJsonToBean(data.getData(), PrivateKey.class);
        //空检查
        if (jsonToBean == null || jsonToBean.getPrivateKey() == 0) {
            return new ChatDataProtocol(data.getId(), ChatDataTypeEnum.LOGIN.getCode(),new Result(ResultEnum.SUCCESS).toString());
        }
        log.info("privateKey:{}", jsonToBean.getPrivateKey());
        return chatLoginService.login(ctx, jsonToBean,data);
    }
}
