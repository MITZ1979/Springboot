package springboot.nf.book.book.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *学号的验证器
 * @author Adminis
 */

public class XuehaoValidator implements ConstraintValidator<Xuehao, String>{
    @Override
    public void initialize(Xuehao constraintAnnotation) {
        System.out.println("我来这里是为了初始化");
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null){
            return false;
        }
        return true;
    }
}
