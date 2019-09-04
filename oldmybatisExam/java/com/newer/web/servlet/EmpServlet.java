package com.newer.web.servlet;

import com.newer.domain.Dept;
import com.newer.domain.Emp;
import com.newer.service.EmpService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

/**
 * @author shining
 */
@WebServlet("/emps")
public class EmpServlet extends HttpServlet{

    private EmpService empService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action=req.getParameter("action");

        if("add".equals(action)){
            addEmp(req,resp);
        }
    }

    private void addEmp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Emp emp=new Emp();
        try {
            BeanUtils.populate(emp,req.getParameterMap());
            int deptno=Integer.parseInt(req.getParameter("deptno"));
            Dept dept=new Dept();
            if(deptno>0){
                dept.setDeptno(deptno);
            }
            emp.setDept(dept);
            int rows=empService.addEmp(emp);
            PrintWriter out=resp.getWriter();
            out.print(rows);
            out.close();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void init() throws ServletException {
        empService=new EmpService();
    }
}
