package indi.midreamsheep.schatapp.backend.netty.prototcp;

import indi.midreamsheep.schatapp.backend.entity.protocol.chat.resonse.ChatTransmission;
import indi.midreamsheep.schatapp.backend.util.protocol.AesUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.springframework.stereotype.Component;

/**
 * netty编码器
 * */
@Component
public class MessageEncoder extends MessageToByteEncoder<ChatTransmission> {

    public MessageEncoder() {
        super();
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, ChatTransmission transmission, ByteBuf out) throws Exception {
        //将MessageProtocol转换成二进制数据
        out.writeLong(transmission.getId());
        out.writeInt(transmission.getType());
        String data = transmission.getData();
        if (!transmission.getAESKey().isEmpty()) {
            data = AesUtil.Encrypt(data, transmission.getAESKey());
        }
        assert data != null;
        byte[] content = data.getBytes();
        out.writeInt(content.length);
        out.writeBytes(content);
    }
}