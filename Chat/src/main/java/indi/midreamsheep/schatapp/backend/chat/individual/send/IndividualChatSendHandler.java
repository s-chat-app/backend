package indi.midreamsheep.schatapp.backend.chat.individual.send;

import indi.midreamsheep.schatapp.backend.chat.ChannelManager;
import indi.midreamsheep.schatapp.backend.chat.ChatHandlerMapper;
import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.chat.message.ChatType;
import indi.midreamsheep.schatapp.backend.chat.message.MessageEntity;
import indi.midreamsheep.schatapp.backend.protocol.Result;
import indi.midreamsheep.schatapp.backend.protocol.ResultEnum;
import indi.midreamsheep.schatapp.backend.scan.annotation.ChatHandler;
import indi.midreamsheep.schatapp.backend.scan.inter.ChatHandlerInter;
import indi.midreamsheep.schatapp.backend.until.json.JsonUtil;
import io.netty.channel.ChannelHandlerContext;
import jakarta.annotation.Resource;

@ChatHandler(type = ChatType.INDIVIDUAL, mapping = "SEND")
public class IndividualChatSendHandler implements ChatHandlerInter {

    @Resource
    private ChannelManager channelManager;

    @Override
    public void handle(ChannelHandlerContext ctx, String data) {
        SChatUser user = channelManager.getChannelMap().get(ctx.channel());
        if (user == null) {
            //TODO 未登录
            ctx.writeAndFlush(new Result(ResultEnum.ACCESS_CHECK_FAILED, "not login"));
            return;
        }
        MessageEntity messageEntity = JsonUtil.getJsonToBean(data, MessageEntity.class);
        //TODO 检查数据
        //TODO 检查是否在黑名单中
        //TODO 发生消息
    }
}
