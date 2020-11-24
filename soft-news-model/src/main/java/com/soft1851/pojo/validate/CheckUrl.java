package com.soft1851.pojo.validate;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: das
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/24 15:02:25 
 * @Version: V1.0
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckUrlValidate.class)
public @interface CheckUrl {
    String message() default "url不正确";
    Class<?>[] groups()default {};
    Class<? extends Payload>[] payload() default {};
}
