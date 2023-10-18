package org.startsteps.week7.class_01;

import java.lang.annotation.*;

//@Documented
//@Target({ElementType.FIELD})
//@Retention(RetentionPolicy.RUNTIME)
//public @interface Email {
//    String message() default "Invalid email address";
//}



@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {
    String message() default "Invalid email address";
}
