package com.newer.service;

import com.newer.domain.User;
import com.newer.mapper.UserMapper;
import com.newer.util.MD5Utils;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class UserService {
    private SqlSession sqlSession;
    private UserMapper userMapper;

    private void init(){
        sqlSession= SqlSessionUtil.getSqlSession();
        userMapper=sqlSession.getMapper(UserMapper.class);
    }

    public User verifyLogin(String username, String password){
        password = MD5Utils.MD5Encode(password,"utf8");
        User user = userMapper.selectByUserPass(username,password);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return user;
    }

    public int addUser(User user){
        int row = userMapper.insert(user);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return row;
    }

}
