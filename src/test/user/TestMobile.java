package user;

import com.newer.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestMobile {
    @Test
    public void mobile(){
        String host = "http://yzxyzm.market.alicloudapi.com";
        String path = "/yzx/verifySms";
        String method = "POST";
        String appcode = "4ca189e3ab2f42bf96ecdc52b95b0a6f";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("phone", "15973732274");
        querys.put("templateId", "TP18040314");
        querys.put("variable", "code:131313");
        Map<String, String> bodys = new HashMap<String, String>();


        try {
            HttpResponse resp = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(resp.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
