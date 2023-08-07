package indi.midreamsheep.schatapp.backend.chat.system;

import indi.midreamsheep.schatapp.backend.api.aop.access.annotation.ChatExceptionHandler;
import indi.midreamsheep.schatapp.backend.chat.ChatMessage;
import indi.midreamsheep.schatapp.backend.chat.message.ChatType;
import indi.midreamsheep.schatapp.backend.protocol.ChatTransmission;
import indi.midreamsheep.schatapp.backend.api.chat.handler.annotation.ChatHandler;
import indi.midreamsheep.schatapp.backend.api.scan.inter.ChatHandlerInter;
import indi.midreamsheep.schatapp.backend.service.chat.system.login.ChatLoginService;
import indi.midreamsheep.schatapp.backend.util.json.JsonUtil;
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
    @ChatExceptionHandler
    public ChatTransmission handle(ChannelHandlerContext ctx, ChatMessage data) {
        PrivateKey jsonToBean = JsonUtil.getJsonToBean(data.getData(), PrivateKey.class);
        System.out.println(jsonToBean.getPrivateKey());
        jsonToBean.check();
        log.info("一个用户尝试登录"+data.getData());
        return chatLoginService.login(ctx, jsonToBean, data);
    }
}
