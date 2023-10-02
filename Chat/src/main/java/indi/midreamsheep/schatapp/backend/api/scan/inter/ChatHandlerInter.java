package indi.midreamsheep.schatapp.backend.api.scan.inter;

import indi.midreamsheep.schatapp.backend.protocol.chat.MessageProtocol;
import indi.midreamsheep.schatapp.backend.protocol.chat.request.ChatMessage;
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
    MessageProtocol handle(ChannelHandlerContext ctx, ChatMessage data) throws Exception;
}
