package indi.midreamsheep.schatapp.backend.api.scan.inter;

import indi.midreamsheep.schatapp.backend.entity.protocol.chat.request.ChatMessage;
import indi.midreamsheep.schatapp.backend.entity.protocol.chat.resonse.ChatTransmission;
import io.netty.channel.ChannelHandlerContext;

/**
 * 聊天处理接口
 * 用于处理聊天消息
 * */
public interface ChatHandlerInter {
    /**
     * 用于处理聊天消息
     * @param ctx 通道上下文
     * @param data 传输的数据
     * */
    ChatTransmission handle(ChannelHandlerContext ctx, ChatMessage data) throws Exception;
}
