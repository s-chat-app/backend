package indi.midreamsheep.schatapp.backend.api.aop.access.aspect;

import indi.midreamsheep.schatapp.backend.api.aop.access.annotation.ChatAccessChecker;
import indi.midreamsheep.schatapp.backend.api.chat.exception.ChatException;
import indi.midreamsheep.schatapp.backend.protocol.data.result.ResultEnum;
import indi.midreamsheep.schatapp.backend.service.chat.ChannelManager;
import io.netty.channel.ChannelHandlerContext;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 权限检查切面
 * 用于检查用户是否登录, 未登录则不允许访问
 * 判断用户是否登录的依据是channel是否在channelManager中
 * */
@Aspect
@Slf4j
@Component
@Order(5)
public class AccountCheckerAspect {

    @Resource
    private ChannelManager channelManager;



    @Around(value = "@annotation(chatAccessChecker)")
    @Order(1)
    public Object around(ProceedingJoinPoint pjp, ChatAccessChecker chatAccessChecker) throws Throwable {
        Object obj = pjp.getArgs()[0];
        if (!(obj instanceof ChannelHandlerContext ctx)) {
            return pjp.proceed(pjp.getArgs());
        }
        System.out.println(ctx.channel().hashCode());
        if (channelManager.getChannelMap().containsKey(ctx.channel())) {
            return pjp.proceed(pjp.getArgs());
        } else {
            throw new ChatException("not login", ResultEnum.ACCESS_CHECK_FAILED);
        }
    }

}
