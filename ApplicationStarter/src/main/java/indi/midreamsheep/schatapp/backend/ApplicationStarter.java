package indi.midreamsheep.schatapp.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;

/**
 * 整个项目的启动类，仅用于启动项目
 * */
/*启动类标识*/
@SpringBootApplication
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
/*扫描指定路径下的mapper*/
public class ApplicationStarter{
    public static void start(Class<?>[] classes,String[] args) {
        SpringApplication.run(classes, args);
    }
}

