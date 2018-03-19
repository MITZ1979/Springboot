package springboot.nf.book.service.mail.service;

public interface MailService {
    String sendSimple(String to, String what);//简单邮件
    String sendComlex(String to, String what);//模板邮件
}
