package indi.midreamsheep.schatapp.backend.chat.individual.send;

import indi.midreamsheep.schatapp.backend.api.aop.annotation.ChatAccessChecker;
import indi.midreamsheep.schatapp.backend.chat.message.ChatType;
import indi.midreamsheep.schatapp.backend.api.chat.handler.annotation.ChatHandler;
import indi.midreamsheep.schatapp.backend.api.scan.inter.ChatHandlerInter;
import indi.midreamsheep.schatapp.backend.service.chat.ChannelManager;
import indi.midreamsheep.schatapp.backend.until.dao.redis.RedisService;
import io.netty.channel.ChannelHandlerContext;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
@ChatHandler(type = ChatType.INDIVIDUAL, mapping = "SEND")
public class IndividualChatSendHandler implements ChatHandlerInter {

    @Resource
    private ChannelManager channelManager;

    @Resource
    private RedisService redisUtil;
    @Override
    @ChatAccessChecker
    public void handle(ChannelHandlerContext ctx, String data) {
        try {
            System.out.println("进入个人聊天发送处理器");
            redisUtil.set("test", "test");
            System.out.println("处理完毕");
            //MessageEntity messageEntity = JsonUtil.getJsonToBean(data, MessageEntity.class);
            //TODO 检查数据
            //TODO 检查是否在黑名单中
            //TODO 发生消息
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}