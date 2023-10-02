package indi.midreamsheep.schatapp.backend.chat.system;

import indi.midreamsheep.schatapp.backend.api.aop.access.annotation.ChatExceptionHandler;
import indi.midreamsheep.schatapp.backend.protocol.chat.MessageProtocol;
import indi.midreamsheep.schatapp.backend.protocol.chat.request.ChatMessage;
import indi.midreamsheep.schatapp.backend.protocol.chat.request.ChatType;
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
    public MessageProtocol handle(ChannelHandlerContext ctx, ChatMessage data) {
        log.info("一个用户尝试登录"+data.getData());
        PrivateKey jsonToBean = JsonUtil.getJsonToBean(data.getData(),PrivateKey.class);
        jsonToBean.check();
        return chatLoginService.login(ctx, jsonToBean, data);
    }
}
