package indi.midreamsheep.schatapp.backend.netty.prototcp;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import indi.midreamsheep.schatapp.backend.protocol.chat.MessageProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.springframework.stereotype.Component;

/**
 * netty编码器
 * */
@Component
public class MessageEncoder extends MessageToByteEncoder<MessageProtocol> {

    public MessageEncoder() {
        super();
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MessageProtocol msg, ByteBuf out) throws Exception {
        byte[] content = msg.getContent();
        out.writeInt(content.length);
        out.writeBytes(content);
    }
}