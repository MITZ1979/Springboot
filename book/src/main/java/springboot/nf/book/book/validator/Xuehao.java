package springboot.nf.book.book.validator;
/**
 * 自定义验证:通过
 * 1、注解（类）
 * 2、验证器（类）
 * 完成
 */

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/*
* 注解类
* */
@Target({METHOD , FIELD})  // @Target 表示该注解 可以使用该注解的目标类型
@Retention(RUNTIME)        //@Retention 表示注解的保留期限
@Documented                 //注解表明这个注解应该被 javadoc工具记录
@Constraint(validatedBy = XuehaoValidator.class)//注解 应该被约束的类
public @interface Xuehao {

    String message() default "学号的格式不正确";

    Class<?>[] groups() default{ };

    Class<? extends Payload>[] payload() default { };
}