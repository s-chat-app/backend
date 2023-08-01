package indi.midreamsheep.schatapp.backend.chat.system;

import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.chat.message.ChatType;
import indi.midreamsheep.schatapp.backend.dao.mysql.User;
import indi.midreamsheep.schatapp.backend.dao.mysql.UserMapper;
import indi.midreamsheep.schatapp.backend.protocol.Result;
import indi.midreamsheep.schatapp.backend.protocol.ResultEnum;
import indi.midreamsheep.schatapp.backend.api.chat.handler.annotation.ChatHandler;
import indi.midreamsheep.schatapp.backend.api.scan.inter.ChatHandlerInter;
import indi.midreamsheep.schatapp.backend.service.chat.ChannelManager;
import indi.midreamsheep.schatapp.backend.until.json.JsonUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@ChatHandler(type = ChatType.SYSTEM, mapping = "login")
@Component
public class SystemLoginHandler implements ChatHandlerInter {

    @Resource
    private ChannelManager channelManager;

    @Resource
    private UserMapper userMapper;

    @Override
    public void handle(ChannelHandlerContext ctx, String data) {
        System.out.println("SystemLoginHandler");
        User user1 = userMapper.selectById(1);
        System.out.println(user1);

        PrivateKey jsonToBean = JsonUtil.getJsonToBean(data, PrivateKey.class);
        String privateKey = jsonToBean.getPrivateKey();
        //TODO 向数据库进行检验
        SChatUser user = new SChatUser();
        ctx.writeAndFlush(JsonUtil.getBeanToJson(new Result(ResultEnum.SUCCESS, "login success")));
        System.out.println("数据发送成功");
        //处理通道
        Channel channel = ctx.channel();
        user.setChannel(channel);
        channelManager.addChannel(user);
        System.out.println("用户登录成功");
    }
}
