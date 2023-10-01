package indi.midreamsheep.schatapp.backend.netty.prototcp;

import indi.midreamsheep.schatapp.backend.service.chat.ChannelManager;
import indi.midreamsheep.schatapp.backend.util.protocol.AesUtil;
import indi.midreamsheep.schatapp.backend.util.protocol.ECCUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * 解码器
 * */
@Component
public class MessageDecoder extends ReplayingDecoder<Void> {

    @Resource
    private ChannelManager channelManager;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        // 将得到的二进制字节码 =》 MessageProtocol 对象
        int len = in.readInt();
        byte[] content = new byte[len];
        in.readBytes(content);
        // 封装成 MessageProtoCol 对象，传递给下一个 handler
        if (channelManager.getUser(ctx.channel())!=null) {
            //解密数据
            content = Objects.requireNonNull(AesUtil.Decrypt(new String(content), channelManager.getUser(ctx.channel()).getPrivateKey())).getBytes();
        }
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLen(content.length);
        messageProtocol.setContent(content);
        out.add(messageProtocol);
    }
}