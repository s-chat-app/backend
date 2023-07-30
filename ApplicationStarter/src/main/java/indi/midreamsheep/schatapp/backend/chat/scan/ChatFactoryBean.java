package indi.midreamsheep.schatapp.backend.chat.scan;

import indi.midreamsheep.schatapp.backend.chat.ChatHandlerMapper;
import indi.midreamsheep.schatapp.backend.scan.annotation.ChatHandler;
import indi.midreamsheep.schatapp.backend.scan.inter.ChatHandlerInter;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationTargetException;


public class ChatFactoryBean implements FactoryBean<ChatHandlerInter> {

    public ChatFactoryBean(Class<?> aClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ChatHandler annotation = aClass.getAnnotation(ChatHandler.class);
        ChatHandlerMapper.getMapper(annotation.type()).put(annotation.mapping(), (ChatHandlerInter) aClass.getDeclaredConstructor().newInstance());
    }

    @Override
    public ChatHandlerInter getObject() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
