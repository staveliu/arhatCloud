package com.newer.web.servlet;

import com.google.gson.JsonObject;
import com.newer.util.HttpUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/mobileCode")
public class MobileVerify extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");

        HttpSession session = request.getSession();
        JsonObject json = new JsonObject();
        //if (((int)session.getAttribute("sendtime")+60)>new Date().getTime()){
        if(false){
            json.addProperty("status","false");
        }else{
            int code = (int)((Math.random()*9+1)*100000);
            String mobile = request.getParameter("mobile");
            session.setAttribute("mobileCode",code);
            mobile(code,mobile);
            session.setAttribute("sendtime",new Date().getTime());
            json.addProperty("status",true);
        }
        PrintWriter io = response.getWriter();
        io.write(json.toString());
        io.close();
    }
    public void mobile(int code,String mobile){
        String host = "http://yzxyzm.market.alicloudapi.com";
        String path = "/yzx/verifySms";
        String method = "POST";
        String appcode = "4ca189e3ab2f42bf96ecdc52b95b0a6f";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("phone", mobile);
        querys.put("templateId", "TP18040314");
        querys.put("variable", "code:"+code);
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
