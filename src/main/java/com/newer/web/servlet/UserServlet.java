package com.newer.web.servlet;

import com.google.gson.JsonObject;
import com.newer.domain.User;
import com.newer.service.UserService;
import com.newer.util.MD5Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out=response.getWriter();
        String action = "";
        action = request.getParameter("action");
        JsonObject json = new JsonObject();
        if (action.equals("login")){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            try {
                User user = userService.verifyLogin(username, password);
                if (user != null){
                    HttpSession session = request.getSession();
                    session.setAttribute("user",user);
                    json.addProperty("status",200);
                    json.addProperty("message","登陆成功");
                }else{
                    json.addProperty("status",401);
                    json.addProperty("message","登陆失败");
                }
            }catch (NullPointerException e){
                e.printStackTrace();
                json.addProperty("status",500);
                json.addProperty("message","登陆失败");
            }finally {
                out.write(json.toString());
                out.close();
            }

        }else if (action.equals("register")){
            HttpSession session = request.getSession();
            Integer verifyCode = Integer.valueOf(request.getParameter("verify"));
            Integer sessionCode = (Integer)session.getAttribute("mobileCode");
            if (!verifyCode.equals(sessionCode)){
                json.addProperty("status",402);
                json.addProperty("message","手机验证码错误");
                out.write(json.toString());
            }else {
                session.setAttribute("mobileCode",0);
                User user = new User();
                user.setUsername(request.getParameter("username"));
                user.setPassword(MD5Utils.MD5Encode(request.getParameter("password"), "utf8"));
                user.setRid(0);
                user.setEmail(request.getParameter("email"));
                user.setMobile(request.getParameter("mobile"));
                user.setIconurl("img/timg1.jpg");
                user.setStatus(1);
                int row = userService.addUser(user);
                if (row > 0) {
                    json.addProperty("status", 200);
                    json.addProperty("message", "注册成功");
                } else {
                    json.addProperty("status", 401);
                    json.addProperty("message", "注册失败");
                }
                out.write(json.toString());
            }
        }else if (action.equals("user")){
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user==null){
                json.addProperty("status",401);
                json.addProperty("message","未登录");
            }else{
                json.addProperty("status",200);
                json.addProperty("username",user.getUsername());
                json.addProperty("email",user.getEmail());
                json.addProperty("mobile",user.getMobile());
                json.addProperty("iconurl",user.getIconurl());
            }
            out.write(json.toString());
        }else if (action.equals("logout")){
            HttpSession session = request.getSession();
            session.invalidate();
            json.addProperty("status",true);
            out.write(json.toString());
        }else if (action.equals("changepwd")){

            HttpSession session = request.getSession();

            Integer verifyCode = Integer.valueOf(request.getParameter("verify"));
            Integer sessionCode = (Integer)session.getAttribute("mobileCode");
            if (!verifyCode.equals(sessionCode)){
                json.addProperty("status",402);
                json.addProperty("message","手机验证码错误");
                out.write(json.toString());
            }else {
                User user = (User) session.getAttribute("user");
                if (user == null) {
                    json.addProperty("status", 401);
                    json.addProperty("message", "未登录");
                } else {
                    String newpwd = request.getParameter("newpwd");
                    int row = userService.changePwd(user,newpwd);
                    if (row>0){
                        json.addProperty("status",200);
                        json.addProperty("message","修改成功");
                        session.invalidate();
                    }else{
                        json.addProperty("status",500);
                        json.addProperty("message","修改失败，未知错误");
                    }
                }
                out.write(json.toString());
            }
        }
        out.close();
    }
}
