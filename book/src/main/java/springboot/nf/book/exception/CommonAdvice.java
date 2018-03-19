package springboot.nf.book.exception;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice   /*SpringMVC中定义为异常统一处理类*/
public class CommonAdvice {
    /**
     * @ExceptionHandler
     */
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public String handleEmptyResult(HttpServletRequest request, Model model, Exception ex){
        model.addAttribute("err","[error]:"+ex.getMessage());
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(HttpServletRequest request, Model model, Exception ex){
        model.addAttribute("err","[error]:"+ex.getMessage());
        return "error";
    }
}
