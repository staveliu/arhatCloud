package com.newer.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.newer.entity.AuthorityUser;
import com.newer.entity.UserInfo;
import com.newer.service.UserService;

/**
 * Servlet implementation class UserSessionServlet
 */
@WebServlet("/sessionuser")
public class UserSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
        userService=new UserService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		HttpSession session=request.getSession();	
		JsonObject jo=new JsonObject();
		if(action==null) {		
			//获取session中保存的用户登录信息			
			UserInfo loginer=(UserInfo)session.getAttribute("loginer");			
			if(loginer!=null) {
				//返回授权用户信息
				AuthorityUser user=userService.getUser(loginer.getUserId());
				Gson gson=new Gson();
				jo.add("user", gson.toJsonTree(user));
			}			
		}else {
			//执行退出操作
			session.removeAttribute("loginer");
			jo.addProperty("suc", true);
		}
		PrintWriter out=response.getWriter();
		out.print(jo);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
