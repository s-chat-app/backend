package indi.midreamsheep.schatapp.backend.entity.api.chat.handler;

import indi.midreamsheep.schatapp.backend.entity.api.chat.handler.annotation.ChatHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 处理器映射类
 * 用于存储处理器的映射关系
 * {@link ChatHandler}
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HandlerMapper {
    /**
     * 注解 存储处理器的映射路径和类型
     * */
    private ChatHandler chatHandler;
    /**
     * 处理器的类 通过反射实例化
     * */
    private Class<?> aClass;
}
