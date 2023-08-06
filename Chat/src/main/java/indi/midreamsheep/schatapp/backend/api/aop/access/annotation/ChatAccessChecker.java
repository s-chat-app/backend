package indi.midreamsheep.schatapp.backend.api.aop.access.annotation;


import indi.midreamsheep.schatapp.backend.protocol.TransmissionEnum;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ChatAccessChecker {
    TransmissionEnum check();
}
