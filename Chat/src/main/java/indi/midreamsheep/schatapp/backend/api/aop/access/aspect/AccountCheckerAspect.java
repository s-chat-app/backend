package indi.midreamsheep.schatapp.backend.api.aop.access.aspect;

import indi.midreamsheep.schatapp.backend.api.aop.access.annotation.ChatAccessChecker;
import indi.midreamsheep.schatapp.backend.protocol.Result;
import indi.midreamsheep.schatapp.backend.protocol.ResultEnum;
import indi.midreamsheep.schatapp.backend.service.chat.ChannelManager;
import io.netty.channel.ChannelHandlerContext;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class AccountCheckerAspect {

    @Resource
    private ChannelManager channelManager;

    @Around(value = "@annotation(chatAccessChecker)")
    public Object around(ProceedingJoinPoint pjp, ChatAccessChecker chatAccessChecker) throws Throwable {
        System.out.println("进入切面");
        Object obj = pjp.getArgs()[0];
        if(!(obj instanceof ChannelHandlerContext ctx)){
            return pjp.proceed(pjp.getArgs());
        }
        if (channelManager.getChannelMap().containsKey(ctx.channel())) {
            return pjp.proceed(pjp.getArgs());
        } else {
            log.info("用户未登录");
            ctx.writeAndFlush(new Result(ResultEnum.ACCESS_CHECK_FAILED, "用户未登录"));
            return null;
        }
    }

}
