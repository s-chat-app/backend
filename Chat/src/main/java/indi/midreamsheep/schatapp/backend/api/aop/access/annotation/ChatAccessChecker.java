package indi.midreamsheep.schatapp.backend.api.aop.access.annotation;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ChatAccessChecker {
    boolean check() default true;
}
