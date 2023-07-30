package indi.midreamsheep.schatapp.backend.scan.annotation;

import indi.midreamsheep.schatapp.backend.pojo.message.ChatType;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(java.lang.annotation.ElementType.TYPE)
@Documented
public @interface ChatHandler {
    String mapping();
    ChatType type() default ChatType.INDIVIDUAL;
}
