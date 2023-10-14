package indi.midreamsheep.schatapp.backend.config;

import indi.midreamsheep.schatapp.backend.chat.ChatHandlerMapper;
import indi.midreamsheep.schatapp.backend.config.scan.ChatScanConfiguration;
import indi.midreamsheep.schatapp.backend.netty.ChatServer;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;

/*扫描指定的聊天处理器*/
@ChatScanConfiguration("indi.midreamsheep.schatapp.backend.chat")
public class SChatNettyConfiguration  implements CommandLineRunner {


    /**用于启动netty通讯服务*/
    @Resource
    private ChatServer chatServer;

    /**用于注册netty服务的处理器*/
    @Resource
    private ConfigurableApplicationContext context;


    /**回调启动netty服务*/
    @Override
    public void run(String... args) throws Exception {
        ChatHandlerMapper.init(context);
        chatServer.run(7524);
    }
}
