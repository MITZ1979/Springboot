package springboot.nf.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springboot.nf.book.service.SMSService;

@Controller
public class SenderTestController {

    @Autowired
    private SMSService smsService;

    @GetMapping("/sms")
    public String tosms(){
        smsService.send("13192276358","1515",1);
        return "vue/index";
    }

}
