package springboot.nf.book.service.sms;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import springboot.nf.book.service.SMSService;
import springboot.nf.book.service.sms.utils.Commons;
import springboot.nf.book.smsyun.ucpaas.restDemo.HttpClientUtil;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

;

@Service
public class YunZhiXunSMSSericelmpl implements SMSService {
    /*    static String HttpUrl="";
        static String ACCOUNT_SID="";
        static String ACCOUNT_APIKEY="";
        static final String CHARSET_UTF8="UTF-8";
        static String extno = "222";*/
// 将参数写在配置文件中
    @Value("${sms.meisheng.url}")
    String HttpUrl;
    @Value("${sms.meisheng.sid}")
    String AccountSid;
    @Value("${sms.meisheng.appid}")
    String appid;
    @Value("${sms.meisheng.apikey}")
    String AccountApikey;
    @Value("${sms.meisheng.extno}")
    String extno;
    @Value("${sms.meisheng.encode}")
    String encoding = "UTF-8";

    /**
     * 发送简单短信
     *
     * @param to
     * @param what
     * @return
     */
    @Override
    public String send(String to, String what) {
        return null;
    }

    /**
     * template:   01 验证码短信
     * 02 祝福短信
     *
     * @param to
     * @param what
     * @param type
     * @return
     */
    @Override
    public String send(String to, String what, int type) {
        String resultJson = "";
        CloseableHttpClient httpClient = null;

        String result = "";

        try {
            String url = HttpUrl;

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("sid", AccountSid);
            jsonObject.put("token", AccountApikey);
            jsonObject.put("appid", appid);
            jsonObject.put("templateid", extno);
            jsonObject.put("param", what);
            jsonObject.put("mobile", to);


            String body = jsonObject.toJSONString();

            System.out.println("body = " + body);

            result = HttpClientUtil.postJson(url, body, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private String encrypt(String msg) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return Commons.md5Digest(Commons.changeCharset(msg, encoding), encoding);
    }
}
