package indi.midreamsheep.schatapp.backend.chat;

import indi.midreamsheep.schatapp.backend.api.chat.handler.HandlerMapper;
import indi.midreamsheep.schatapp.backend.api.chat.handler.annotation.ChatHandler;
import indi.midreamsheep.schatapp.backend.protocol.chat.request.ChatType;
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
    /**私人聊天映射*/
    private static final Map<String, ChatHandlerInter> INDIVIDUAL_MAPPER = new HashMap<>();
    /**群聊映射*/
    private static final Map<String, ChatHandlerInter> GROUP_MAPPER = new HashMap<>();
    /**频道映射*/
    private static final Map<String, ChatHandlerInter> CHANNEL_MAPPER = new HashMap<>();
    /**系统消息映射*/
    private static final Map<String, ChatHandlerInter> SYSTEM_MAPPER = new HashMap<>();
    /**自己悟*/
    public static Map<String, ChatHandlerInter> getMapper(ChatType type) {
        return switch (type) {
            case INDIVIDUAL -> INDIVIDUAL_MAPPER;
            case GROUP -> GROUP_MAPPER;
            case CHANNEL -> CHANNEL_MAPPER;
            default -> SYSTEM_MAPPER;
        };
    }
    /**
     * 通过spring容器用REGISTER信息将处理器注入映射表
     * @param context spring容器上下文
     * */
    public static void init(ConfigurableApplicationContext context){
        for (HandlerMapper mapper : REGISTER) {
            ChatHandler chatHandler = mapper.getChatHandler();
            getMapper(chatHandler.type()).put(chatHandler.mapping(), (ChatHandlerInter)context.getBean(mapper.getAClass()));
        }
    }
}
