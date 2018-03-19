package springboot.nf.book.book.validator;

import org.springframework.context.annotation.Configuration;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 *PhoneNum注解类
 */
@Target({METHOD , TYPE}) // @Target 表示该注解 可以使用该注解的目标类型
@Retention(RUNTIME)
@Documented     //@Documented 注解表明这个注解应该被 javadoc工具记录
@Constraint(validatedBy = PhoneValidator.class)   //注解 应该被约束的类
public @interface Phone {
    String message() default "电话的格式不正确";

    Class<?>[] groups() default{ };

    Class<? extends Payload>[] payload() default { };
}
