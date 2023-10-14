package indi.midreamsheep.schatapp.backend.entity.api.chat.handler.annotation;

import indi.midreamsheep.schatapp.backend.entity.protocol.chat.request.ChatMapping;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 处理器注解，用于指定处理器的映射路径,需要在处理器类上实现接口ChatHandlerInter
 * mapping: 映射路径{@link ChatMapping}
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target(java.lang.annotation.ElementType.TYPE)
@Documented
public @interface ChatHandler {
    String value();
}
