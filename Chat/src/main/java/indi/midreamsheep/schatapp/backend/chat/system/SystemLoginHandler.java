package indi.midreamsheep.schatapp.backend.chat.system;

import indi.midreamsheep.schatapp.backend.chat.ChannelManager;
import indi.midreamsheep.schatapp.backend.chat.message.ChatType;
import indi.midreamsheep.schatapp.backend.protocol.Result;
import indi.midreamsheep.schatapp.backend.protocol.ResultEnum;
import indi.midreamsheep.schatapp.backend.scan.annotation.ChatHandler;
import indi.midreamsheep.schatapp.backend.scan.inter.ChatHandlerInter;
import indi.midreamsheep.schatapp.backend.until.json.JsonUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import jakarta.annotation.Resource;

@ChatHandler(type = ChatType.SYSTEM, mapping = "login")
public class SystemLoginHandler implements ChatHandlerInter {

    @Resource
    private ChannelManager channelManager;

    @Override
    public void handle(ChannelHandlerContext ctx, String data) {
        PrivateKey jsonToBean = JsonUtil.getJsonToBean(data, PrivateKey.class);
        String privateKey = jsonToBean.getPrivateKey();
        //TODO 向数据库进行检验
        ctx.writeAndFlush(new Result(ResultEnum.SUCCESS,"login success"));
        //处理通道
        Channel channel = ctx.channel();
        //ChannelManager.addChannel(privateKey, channel);
    }
}
