package indi.midreamsheep.schatapp.backend.api.aop.access.annotation;

import indi.midreamsheep.schatapp.backend.api.aop.access.aspect.ChatExceptionHandlerAspect;
import indi.midreamsheep.schatapp.backend.entity.api.chat.exception.ChatException;

import java.lang.annotation.*;

/**
 * 异常处理切面标记
 * @see ChatExceptionHandlerAspect
 * @see ChatException
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ChatExceptionHandler {
}
