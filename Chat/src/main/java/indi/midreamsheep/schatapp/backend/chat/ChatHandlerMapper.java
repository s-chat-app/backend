package indi.midreamsheep.schatapp.backend.chat;

import indi.midreamsheep.schatapp.backend.entity.api.chat.handler.HandlerMapper;
import indi.midreamsheep.schatapp.backend.entity.api.chat.handler.annotation.ChatHandler;
import indi.midreamsheep.schatapp.backend.api.scan.inter.ChatHandlerInter;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * netty聊天处理器映射表
 * 用于存储处理器映射关系
 * 注入过程见ApplicationStarter模块
 * */
public class ChatHandlerMapper {
    /**注册表，在扫描阶段使用，spring容器启动后通过init()方法注入map*/
    public static final List<HandlerMapper> REGISTER = new LinkedList<>();
    /**处理器映射*/
    private static final Map<String, ChatHandlerInter> MAPPER = new HashMap<>();

    /**
     * 通过spring容器用REGISTER信息将处理器注入映射表
     * @param context spring容器上下文
     * */
    public static void init(ConfigurableApplicationContext context){
        for (HandlerMapper mapper : REGISTER) {
            ChatHandler chatHandler = mapper.getChatHandler();
            MAPPER.put(chatHandler.value(), (ChatHandlerInter)context.getBean(mapper.getAClass()));
        }
    }

    /**
     * 通过映射路径获取处理器
     * @param path 映射路径
     * */
    public static ChatHandlerInter getHandler(String path) {
        return MAPPER.get(path);
    }
}
