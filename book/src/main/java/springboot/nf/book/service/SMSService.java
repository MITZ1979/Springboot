package springboot.nf.book.service;


/**
 * 短信接口
 */
public interface SMSService {

    /**
     * 发送简单短信
     * @param to
     * @param what
     * @return
     */
    String send(String to , String what);

    /**
     * template:   01 验证码短信
     *             02 祝福短信
     * @param to
     * @param what
     * @param type
     * @return
     */
    // 发送定制模板
    String send(String to , String what , int type);
}
