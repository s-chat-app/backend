package indi.midreamsheep.schatapp.backend;

import indi.midreamsheep.schatapp.backend.netty.ChatServer;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationStarter implements CommandLineRunner {

    @Resource
    private ChatServer chatServer;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        chatServer.run(7524);
    }
}
