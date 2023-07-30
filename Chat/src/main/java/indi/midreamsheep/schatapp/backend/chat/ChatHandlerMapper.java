package indi.midreamsheep.schatapp.backend.chat;

import indi.midreamsheep.schatapp.backend.entity.message.ChatType;
import indi.midreamsheep.schatapp.backend.scan.inter.ChatHandlerInter;

import java.util.HashMap;
import java.util.Map;

public class ChatHandlerMapper {
    private static final Map<String, ChatHandlerInter> INDIVIDUAL_MAPPER = new HashMap<>();
    private static final Map<String, ChatHandlerInter> GROUP_MAPPER = new HashMap<>();
    private static final Map<String, ChatHandlerInter> CHANNEL_MAPPER = new HashMap<>();
    private static final Map<String, ChatHandlerInter> NULL = new HashMap<>(0);
    public static Map<String, ChatHandlerInter> getMapper(ChatType type) {
        System.out.println("ChatHandlerMapper.getMapper: " + type);
        return switch (type) {
            case INDIVIDUAL -> INDIVIDUAL_MAPPER;
            case GROUP -> GROUP_MAPPER;
            case SYSTEM -> CHANNEL_MAPPER;
            default -> NULL;
        };
    }
}
