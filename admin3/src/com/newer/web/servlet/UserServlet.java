package com.newer.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.newer.entity.Role;
import com.newer.entity.UserInfo;
import com.newer.service.UserService;
import com.newer.util.MD5;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/users")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	
	private UserService userService;
	
	
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        userService=new UserService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取进行哪种操作的参数
		String action=request.getParameter("action");
		
		if("login".equals(action)) {
			//处理登录
			login(request,response);
		}else if("changePwd".equals(action)) {
			changePwd(request,response);
		}else if("findAll".equals(action)) {
			findAll(request,response);
		}else if("changeState".equals(action)) {
			changeState(request,response);
		}else if("findRole".equals(action)) {
			findRole(request,response);
		}else if("findById".equals(action)) {
			findById(request,response);
		}
		
	}

	private void findById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int userId=Integer.parseInt(request.getParameter("userId"));
		UserInfo user=userService.findById(userId);
		
		PrintWriter out=response.getWriter();
		out.print(new Gson().toJson(user));
		out.close();
	}

	private void findRole(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		List<Role> list=userService.findAllRole();
		
		PrintWriter out=response.getWriter();
		out.print(new Gson().toJson(list));
		out.close();
	}

	private void changeState(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int userId=Integer.parseInt(request.getParameter("userId"));
		int state=Integer.parseInt(request.getParameter("state"));
		
		if(userService.updateState(userId, state)>0) {
			PrintWriter out=response.getWriter();
			out.print(1);
			out.close();
		}
		
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//查询所有用户信息
		List<UserInfo> list=userService.findAll();
		
		Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").excludeFieldsWithoutExposeAnnotation().serializeNulls().registerTypeAdapter(String.class,STRING).create();
		JsonObject jo=new JsonObject();
		jo.add("data", gson.toJsonTree(list));
		PrintWriter out=response.getWriter();
		out.print(jo);
		out.close();
	}

	private void changePwd(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String pwd=request.getParameter("pwd");
		HttpSession session=request.getSession();
		UserInfo loginer=(UserInfo)session.getAttribute("loginer");
		JsonObject jo=new JsonObject();
		
		if(loginer.getPassword().equals(MD5.getInstance().getMD5ofStr(pwd))) {
			String password=request.getParameter("password");
			int rows=userService.changPwd(loginer.getUserId(), password);
			if(rows>0) {
				jo.addProperty("changed", true);
				loginer.setPassword(MD5.getInstance().getMD5ofStr(password));
			}
		}else {
			jo.addProperty("msg", "旧密码错误！");
		}
		
		PrintWriter out=response.getWriter();
		out.print(jo);
		out.close();
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String code=request.getParameter("code");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		//获取服务端保存的验证码
		String verifyCode=(String)session.getAttribute("code");
		//响应客户端的json对象
		JsonObject jo=new JsonObject();
		if(!code.equals(verifyCode)) {
			jo.addProperty("msg", "验证码错误!");
		}else {
			UserInfo loginer=userService.login(username, password);
			if(loginer==null) {
				jo.addProperty("msg", "用户名或密码错误！");
			}else if(loginer.getState()==0) {
				jo.addProperty("msg", "该账户被禁用，请与管理员联系！");
			}else {
				//登录成功
				jo.addProperty("suc",true);
				session.setAttribute("loginer", loginer);
			}
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
	
	
	public static final String EMPTY = "";
	
	/**
     * 对于String 类型 的 策略
     */
    public static final TypeAdapter<String> STRING = new TypeAdapter<String>() {
        //进行反序列化
        @Override
        public String read(JsonReader reader) {
            try {
                if (reader.peek() == JsonToken.NULL) {
                    reader.nextNull();
                    return null;
                }
                //要进行属性值的判断 若为 空字符串 则返回null 否则返回 本身的值
        String result = reader.nextString();
                return result.length() > 0 ? result : null;
            } catch (Exception e) {
                throw new JsonSyntaxException(e);
            }
        }

        // 进行序列化
        @Override
        public void write(JsonWriter writer, String value) {
            try {
                if (value == null) {
                    writer.value(EMPTY);
                    return;
                }
                writer.value(value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    
 



}
