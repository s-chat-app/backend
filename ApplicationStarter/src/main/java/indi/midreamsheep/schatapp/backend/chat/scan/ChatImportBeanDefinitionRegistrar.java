package indi.midreamsheep.schatapp.backend.chat.scan;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class ChatImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        //获取扫描器
        ChatScanner scanner = new ChatScanner(registry);
        scanner.addIncludeFilter((metadataReader, metadataReaderFactory) -> true);
        //扫描
        scanner.scan((String) importingClassMetadata.getAnnotationAttributes(ChatScanConfiguration.class.getName()).get("value"));
    }
}
