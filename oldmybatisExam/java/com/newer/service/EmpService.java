package com.newer.service;

import com.newer.domain.Emp;
import com.newer.mapper.EmpMapper;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author shining
 */
public class EmpService {

    private SqlSession sqlSession;
    private EmpMapper empMapper;

    private void init(){
        sqlSession= SqlSessionUtil.getSqlSession();
        empMapper=sqlSession.getMapper(EmpMapper.class);
    }

    public int addEmp(Emp emp){
        init();
        int rows=empMapper.addEmp(emp);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return rows;
    }
}
