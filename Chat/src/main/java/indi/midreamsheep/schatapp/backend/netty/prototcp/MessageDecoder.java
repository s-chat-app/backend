package indi.midreamsheep.schatapp.backend.netty.prototcp;

import indi.midreamsheep.schatapp.backend.protocol.chat.MessageProtocol;
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
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        // 将得到的二进制字节码 =》 MessageProtocol 对象
        int len = in.readInt();
        byte[] content = new byte[len];
        in.readBytes(content);
        // 封装成 MessageProtoCol 对象，传递给下一个 handler
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLen(content.length);
        messageProtocol.setContent(content);
        out.add(messageProtocol);
    }
}