package indi.midreamsheep.schatapp.backend.netty.prototcp;

import indi.midreamsheep.schatapp.backend.service.chat.ChannelManager;
import indi.midreamsheep.schatapp.backend.util.protocol.AesUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * netty编码器
 * */
@Component
public class MessageEncoder extends MessageToByteEncoder<MessageProtocol> {

    @Resource
    private ChannelManager channelManager;

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MessageProtocol msg, ByteBuf out) throws Exception {
        byte[] content = msg.getContent();
        if (channelManager.getUser(channelHandlerContext.channel()) != null){
            //加密数据
           content = Objects.requireNonNull(AesUtil.Encrypt(new String(content), channelManager.getUser(channelHandlerContext.channel()).getPrivateKey())).getBytes();
        }
        out.writeInt(content.length);
        out.writeBytes(content);
    }
}