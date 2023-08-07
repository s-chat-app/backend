package indi.midreamsheep.schatapp.backend.api.aop.access.aspect;

import com.alibaba.fastjson.JSONException;
import indi.midreamsheep.schatapp.backend.api.aop.access.annotation.ChatExceptionHandler;
import indi.midreamsheep.schatapp.backend.api.chat.exception.ChatException;
import indi.midreamsheep.schatapp.backend.chat.ChatMessage;
import indi.midreamsheep.schatapp.backend.protocol.ResponseProcessor;
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


    @Around(value = "@annotation(chatExceptionHandler)")
    public Object around(ProceedingJoinPoint pjp, ChatExceptionHandler chatExceptionHandler) throws Throwable {
        try {
            return pjp.proceed(pjp.getArgs());
        }catch (ChatException chatException){
            ChatMessage arg = (ChatMessage) pjp.getArgs()[1];
            log.error("error msg:{},\nChatException: {}",arg.toString(),chatException.getMessage());
            return ResponseProcessor.makeExceptionResultResponse(arg.getId(),arg.getType(), chatException);
        }catch (JSONException jsonException) {
            ChatMessage arg = (ChatMessage) pjp.getArgs()[1];
            log.error("error msg:{},\nJSONException: {}",arg.toString(),jsonException.getMessage());
            return ResponseProcessor.makeExceptionResultResponse(arg.getId(), arg.getType(), "error json format");
        }catch (Throwable throwable){
            ChatMessage arg = (ChatMessage) pjp.getArgs()[1];
            log.error("error msg:{},\nThrowable: {}",arg.toString(),throwable.getMessage());
            return ResponseProcessor.makeExceptionResultResponse(arg.getId(), arg.getType(), throwable.getMessage());
        }
    }
}
