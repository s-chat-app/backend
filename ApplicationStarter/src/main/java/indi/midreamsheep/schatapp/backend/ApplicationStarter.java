package indi.midreamsheep.schatapp.backend;

import indi.midreamsheep.schatapp.backend.chat.ChatHandlerMapper;
import indi.midreamsheep.schatapp.backend.chat.scan.ChatScanConfiguration;
import indi.midreamsheep.schatapp.backend.netty.ChatServer;
import jakarta.annotation.Resource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;

@SpringBootApplication
@ChatScanConfiguration("indi.midreamsheep.schatapp.backend.chat")
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
@MapperScan("indi.midreamsheep.schatapp.backend.dao.mysql")
public class ApplicationStarter implements CommandLineRunner {

    @Resource
    private ChatServer chatServer;

    @Resource
    private ConfigurableApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        ChatHandlerMapper.init(context);
        chatServer.run(7524);
    }
}
