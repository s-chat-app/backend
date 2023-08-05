package indi.midreamsheep.schatapp.backend.api.aop.access.annotation;


import indi.midreamsheep.schatapp.backend.protocol.ChatDataTypeEnum;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ChatAccessChecker {
    ChatDataTypeEnum value();
}
