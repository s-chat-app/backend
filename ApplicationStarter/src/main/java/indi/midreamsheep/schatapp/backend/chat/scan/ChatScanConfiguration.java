package indi.midreamsheep.schatapp.backend.chat.scan;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(java.lang.annotation.ElementType.TYPE)
@Import(ChatImportBeanDefinitionRegistrar.class)
public @interface ChatScanConfiguration {
    String value() default "";
}
