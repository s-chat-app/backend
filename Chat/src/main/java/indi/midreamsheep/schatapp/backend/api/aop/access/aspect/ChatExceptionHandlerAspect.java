package indi.midreamsheep.schatapp.backend.api.aop.access.aspect;

import indi.midreamsheep.schatapp.backend.api.aop.access.annotation.ChatExceptionHandler;
import indi.midreamsheep.schatapp.backend.api.exception.ChatException;
import indi.midreamsheep.schatapp.backend.chat.ChatMessage;
import indi.midreamsheep.schatapp.backend.netty.ResponseProcessor;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
@Order(1)
public class ChatExceptionHandlerAspect {

    @Resource
    private ResponseProcessor responseProcessor;

    @Around(value = "@annotation(chatExceptionHandler)")
    public Object around(ProceedingJoinPoint pjp, ChatExceptionHandler chatExceptionHandler) throws Throwable {
        try {
            return pjp.proceed(pjp.getArgs());
        }catch (ChatException chatException){
            ChatMessage arg = (ChatMessage) pjp.getArgs()[1];
            return responseProcessor.makeExceptionResponse(arg.getId(),arg.getType(), chatException);
        }
    }
}
