package indi.midreamsheep.schatapp.backend.chat;

import indi.midreamsheep.schatapp.backend.api.chat.handler.HandlerMapper;
import indi.midreamsheep.schatapp.backend.api.chat.handler.annotation.ChatHandler;
import indi.midreamsheep.schatapp.backend.chat.message.ChatType;
import indi.midreamsheep.schatapp.backend.api.scan.inter.ChatHandlerInter;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ChatHandlerMapper {
    public static final List<HandlerMapper> REGISTER = new LinkedList<>();
    private static final Map<String, ChatHandlerInter> INDIVIDUAL_MAPPER = new HashMap<>();
    private static final Map<String, ChatHandlerInter> GROUP_MAPPER = new HashMap<>();
    private static final Map<String, ChatHandlerInter> CHANNEL_MAPPER = new HashMap<>();
    private static final Map<String, ChatHandlerInter> SYSTEM_MAPPER = new HashMap<>();
    public static Map<String, ChatHandlerInter> getMapper(ChatType type) {
        return switch (type) {
            case INDIVIDUAL -> INDIVIDUAL_MAPPER;
            case GROUP -> GROUP_MAPPER;
            case CHANNEL -> CHANNEL_MAPPER;
            default -> SYSTEM_MAPPER;
        };
    }
    public static void init(ConfigurableApplicationContext context){
        for (HandlerMapper mapper : REGISTER) {
            ChatHandler chatHandler = mapper.getChatHandler();
            getMapper(chatHandler.type()).put(chatHandler.mapping(), (ChatHandlerInter)context.getBean(mapper.getAClass()));
        }
    }
}
