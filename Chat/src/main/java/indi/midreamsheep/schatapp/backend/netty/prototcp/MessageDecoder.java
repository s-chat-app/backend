package indi.midreamsheep.schatapp.backend.netty.prototcp;

import indi.midreamsheep.schatapp.backend.entity.protocol.chat.request.ChatMessage;
import indi.midreamsheep.schatapp.backend.entity.protocol.chat.resonse.ChatTransmission;
import indi.midreamsheep.schatapp.backend.entity.protocol.chat.resonse.data.result.Result;
import indi.midreamsheep.schatapp.backend.entity.protocol.chat.resonse.data.result.chat.ChatResultEnum;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * 解码器
 * */
public class MessageDecoder extends ReplayingDecoder<Void> {

    public MessageDecoder() {
        super();
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        // 将得到的二进制字节码 =》 ChatMessage 对象
        ChatMessage chatMessage = new ChatMessage();
        // 读取数据
        long id = in.readLong();
        chatMessage.setId(id);
        int mappingLength = in.readInt();
        byte[] mapping = new byte[mappingLength];
        in.readBytes(mapping);
        chatMessage.setMapping(new String(mapping));
        int dataLength = in.readInt();
        byte[] data = new byte[dataLength];
        in.readBytes(data);
        chatMessage.setData(new String(data));

        //进行校验
        if (!chatMessage.check()){
            ctx.writeAndFlush(new ChatTransmission(id, -1, new Result(ChatResultEnum.ERROR, "error data")));
            return;
        }

        out.add(chatMessage);
    }
}