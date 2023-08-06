package indi.midreamsheep.schatapp.backend.api.aop.access.annotation;

import indi.midreamsheep.schatapp.backend.api.aop.access.aspect.ChatExceptionHandlerAspect;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * 异常处理切面标记
 * @see ChatExceptionHandlerAspect
 * @see indi.midreamsheep.schatapp.backend.api.exception.ChatException
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ChatExceptionHandler {
}
