package indi.midreamsheep.schatapp.backend.chat.scan;

import indi.midreamsheep.schatapp.backend.api.chat.handler.HandlerMapper;
import indi.midreamsheep.schatapp.backend.api.chat.handler.annotation.ChatHandler;
import indi.midreamsheep.schatapp.backend.chat.ChatHandlerMapper;
import lombok.NonNull;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.util.Objects;

/**
 * netty聊天服务处理器扫描注入类，用于处理具体的扫描逻辑
 * 扫描过程中并不会将处理器注入到spring容器中，而是将处理器的信息注入到{@link HandlerMapper}中，在spring容器启动完成后，再将处理器注入到spring容器中
 * @author midreamsheep
 * @since 2023/8/1
 * @see ChatHandler 处理器注解
 * */
public class ChatImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * 资源匹配符
     * */
    private static final String RESOURCE_PATTERN = "/**/*.class";

    /**
     * 扫描指定路径下的所有类，并将处理器的信息注入到{@link HandlerMapper}中
     * @param importingClassMetadata 当前类的注解信息
     * @param registry bean定义注册器
     * @param importBeanNameGenerator bean名称生成器
     * */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,@NonNull BeanDefinitionRegistry registry,@NonNull BeanNameGenerator importBeanNameGenerator) {
        String path = (String) Objects.requireNonNull(importingClassMetadata.getAnnotationAttributes(ChatScanConfiguration.class.getName())).get("value");
        //spring工具类，可以获取指定路径下的全部类
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        try {
            String pattern = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
                    ClassUtils.convertClassNameToResourcePath(path) + RESOURCE_PATTERN;
            Resource[] resources = resourcePatternResolver.getResources(pattern);
            //MetadataReader 的工厂类
            MetadataReaderFactory readerFactory = new CachingMetadataReaderFactory(resourcePatternResolver);
            for (Resource resource : resources) {
                //用于读取类信息
                MetadataReader reader = readerFactory.getMetadataReader(resource);
                //扫描到的class
                Class<?> clazz = Class.forName(reader.getClassMetadata().getClassName());
                ChatHandler anno = clazz.getAnnotation(ChatHandler.class);
                if (anno == null) {
                    continue;
                }
                ChatHandlerMapper.REGISTER.add(new HandlerMapper(anno,clazz));
            }
        } catch (IOException | ClassNotFoundException ignored) {
        }
    }
}
