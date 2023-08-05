package indi.midreamsheep.schatapp.backend.api.aop.access.aspect;

import indi.midreamsheep.schatapp.backend.api.aop.access.annotation.ChatAccessChecker;
import indi.midreamsheep.schatapp.backend.chat.ChatMessage;
import indi.midreamsheep.schatapp.backend.util.response.Result;
import indi.midreamsheep.schatapp.backend.util.response.ResultEnum;
import indi.midreamsheep.schatapp.backend.service.chat.ChannelManager;
import io.netty.channel.ChannelHandlerContext;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 权限检查切面
 * 用于检查用户是否登录, 未登录则不允许访问
 * 判断用户是否登录的依据是channel是否在channelManager中
 * */
@Aspect
@Slf4j
@Component
public class AccountCheckerAspect {

    @Resource
    private ChannelManager channelManager;

    @Around(value = "@annotation(chatAccessChecker)")
    public Object around(ProceedingJoinPoint pjp, ChatAccessChecker chatAccessChecker) throws Throwable {
        Object obj = pjp.getArgs()[0];
        if(!(obj instanceof ChannelHandlerContext ctx)){
            return pjp.proceed(pjp.getArgs());
        }
        if (channelManager.getChannelMap().containsKey(ctx.channel())) {
            return pjp.proceed(pjp.getArgs());
        } else {
            Object arg = pjp.getArgs()[1];
            log.info("用户未登录");
            ctx.writeAndFlush(new Result(ResultEnum.ACCESS_CHECK_FAILED,((ChatMessage)arg).getId() ,"用户未登录"));
            return null;
        }
    }

}
