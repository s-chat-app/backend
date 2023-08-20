package indi.midreamsheep.schatapp.backend.api.aop.access.annotation;


import indi.midreamsheep.schatapp.backend.api.aop.access.aspect.ChatAccountCheckerAspect;
import indi.midreamsheep.schatapp.backend.protocol.chat.ChatTransmissionEnum;

import java.lang.annotation.*;


/**
 * 权限检查注解，用于标识需要对其进行是否登录检查的方法
 * @see ChatAccountCheckerAspect
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ChatAccessChecker {
    /**
     * 处理消息的类型
     * */
    ChatTransmissionEnum check();
}
