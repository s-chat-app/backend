package indi.midreamsheep.schatapp.backend.netty;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import indi.midreamsheep.schatapp.backend.api.chat.handler.annotation.ChatHandler;
import indi.midreamsheep.schatapp.backend.chat.ChatHandlerMapper;
import indi.midreamsheep.schatapp.backend.protocol.chat.request.ChatMessage;
import indi.midreamsheep.schatapp.backend.protocol.chat.request.ChatType;
import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.ChatTransmission;
import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.ChatTransmissionEnum;
import indi.midreamsheep.schatapp.backend.api.scan.inter.ChatHandlerInter;
import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.data.result.Result;
import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.data.result.chat.ChatResultEnum;
import io.netty.channel.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * netty消息接受分发处理器
 * 通过注解{@link ChatHandler}指定消息类型和消息映射并注册到{@link ChatHandlerMapper}中由当前对象处理
 * 收到消息后会先进行json解析，解析失败则返回错误消息
 * 解析成功后会根据消息类型和消息映射从{@link ChatHandlerMapper}中获取对应的处理器并进行处理
 * 处理器注册方式见{@link ChatHandler}
 * @see ChatHandlerInter
 * */
@Component
@ChannelHandler.Sharable
@Slf4j
public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, String msg) {
        ChatMessage message;
        try {
            message = parse(msg);
            message.check();
        } catch (Exception e) {
            log.error("messageReceived error:{} \n error msg:{}", e.getMessage(),msg);
            ctx.writeAndFlush(new ChatTransmission(-1, ChatTransmissionEnum.HANDLER_EXCEPTION, new Result(ChatResultEnum.ERROR, "json parse error")).toString());
            return;
        }
        log.info("messageReceived:{}", message);
        ChatHandlerInter chatHandlerInter = ChatHandlerMapper.getMapper(ChatType.valueOf(message.getType())).get(message.getMapping());
        if (chatHandlerInter != null) {
            ctx.writeAndFlush((chatHandlerInter.handle(ctx, message).toString()));
            return;
        }
        log.info("no handler found for type:{} mapping:{}", message.getType(), message.getMapping());
        ctx.writeAndFlush(new ChatTransmission(message.getId(), ChatTransmissionEnum.HANDLER_EXCEPTION, new Result(ChatResultEnum.ERROR, "no handler found")).toString());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        //关闭通道
        ctx.close();
    }
    /**
     * 手动解析chatTransmission
     *    long id;
     *    int type;
     *    String mapping;
     *    String data;
     * */
    private ChatMessage parse(String json){
        JSONObject jsonObject = JSON.parseObject(json);
        Long id = jsonObject.getLong("id");
        Integer type = jsonObject.getInteger("type");
        String mapping = jsonObject.getString("mapping");
        JSONObject data = jsonObject.getJSONObject("data");
        return new ChatMessage(id,type,mapping,data);
    }
}
