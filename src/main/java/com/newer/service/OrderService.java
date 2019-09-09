package com.newer.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.newer.domain.Invoices;
import com.newer.domain.OrderInfo;
import com.newer.domain.Task;
import com.newer.mapper.InvoicesMapper;
import com.newer.mapper.TaskMapper;
import java.util.List;
import com.newer.util.SqlSessionUtil;

import java.util.LinkedList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;

public class OrderService {
    private SqlSession sqlSession;
    private TaskMapper taskMapper;
    private InvoicesMapper invoicesMapper;

    private void init(){
        sqlSession= SqlSessionUtil.getSqlSession();
        taskMapper=sqlSession.getMapper(TaskMapper.class);
        invoicesMapper=sqlSession.getMapper(InvoicesMapper.class);
    }
    public List<OrderInfo> getTaskList(Integer uid){
        init();
        List<OrderInfo> order = new LinkedList<>();
        List<Task> task = taskMapper.selectByUid(uid);
        for(Task tsk:task){
            JsonArray file = new Gson().fromJson(tsk.getFiles(),JsonArray.class);
            System.out.println(file.toString());
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setFiles(file);
            orderInfo.setCreateTime(tsk.getCreateTime());
            orderInfo.setPrintCode(tsk.getPrintcode());
            orderInfo.setPrintTime(tsk.getPrintTime());
            orderInfo.setStatus(tsk.getStatus());
            Invoices invoices = invoicesMapper.selectByPrimaryKey(tsk.getInvoiceid());
            orderInfo.setTotalPrice(invoices.getPrice());
            order.add(orderInfo);
        }
        SqlSessionUtil.close(sqlSession);
        return order;
    }
}
