package com.newer.web.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.newer.domain.OrderInfo;
import com.newer.domain.User;
import com.newer.service.OrderService;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.StyledEditorKit;
import java.io.IOException;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        String action = "";
        action = request.getParameter("action");
        JsonObject json = new JsonObject();

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        PrintWriter out = response.getWriter();
        if (user==null){
            json.addProperty("status",401);
            json.addProperty("message","未登录");
            out.write(json.toString());
        }else{

            OrderService orderService = new OrderService();
            if (action.equals("list")){
                Integer uid = user.getUid();
                List<OrderInfo> orderInfos = orderService.getTaskList(uid);
                json.addProperty("status",200);
                JsonArray jsonReturn = new JsonArray();
                for (OrderInfo order:orderInfos){
                    jsonReturn.add(new Gson().toJson(order));
                }
                out.write(jsonReturn.toString());
            }
        }
        out.close();
    }
}
