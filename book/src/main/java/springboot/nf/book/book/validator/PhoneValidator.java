package springboot.nf.book.book.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 电话号码验证器
 * 验证： 第一为1开头;第二位 3、4、5、6、7、8开头的电话号码;
 *        后九位数是【0-9】
 *        的电话号码
 */
public class PhoneValidator implements ConstraintValidator<Phone , String>{
    @Override
    public void initialize(Phone constraintAnnotation) {
        System.out.println("实例化开始！");
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;
    }
}
