package indi.midreamsheep.schatapp.backend.chat.scan;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * netty处理器扫描注解，用于指定需要扫描的包路径
 * value: 需要扫描的包路径
 * 只用于启动类之上
 * @see ChatImportBeanDefinitionRegistrar 导入的扫描处理器
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target(java.lang.annotation.ElementType.TYPE)
@Import(ChatImportBeanDefinitionRegistrar.class)
public @interface ChatScanConfiguration {
    String value() default "";
}
