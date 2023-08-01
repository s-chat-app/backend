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

public class ChatImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    private static final String RESOURCE_PATTERN = "/**/*.class";

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
