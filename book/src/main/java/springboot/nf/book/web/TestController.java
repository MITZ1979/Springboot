package springboot.nf.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springboot.nf.book.service.mail.service.MailService;

@Controller
public class TestController {

    @Autowired
    private MailService mailService;

    @RequestMapping("/send")
    public String test(){
        mailService.sendSimple("1519792930@qq.com","你吃了吗？");
        return "successful";
    }

}
