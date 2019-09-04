package com.newer.web.servlet;

import com.google.gson.Gson;
import com.newer.domain.Dept;
import com.newer.service.DeptService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author shining
 */
@WebServlet("/depts")
public class DeptServlet extends HttpServlet{

    private DeptService deptService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询部门信息
        List<Dept> list=deptService.findAll();
        Gson gson=new Gson();
        PrintWriter out=resp.getWriter();
        //将所有部门信息转换成json数组输出给页面
        out.print(gson.toJson(list));
        out.close();
    }

    @Override
    public void init() throws ServletException {
        deptService=new DeptService();
    }
}
