package com.newer.service;

import com.newer.domain.User;
import com.newer.mapper.UserMapper;
import com.newer.util.MD5Utils;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import javax.jws.soap.SOAPBinding;

public class UserService {
    private SqlSession sqlSession;
    private UserMapper userMapper;

    private void init(){
        sqlSession= SqlSessionUtil.getSqlSession();
        userMapper=sqlSession.getMapper(UserMapper.class);
    }

    public User verifyLogin(String username, String password){
        init();
        User input = new User();
        password = MD5Utils.MD5Encode(password,"utf8");
        input.setUsername(username);
        input.setPassword(password);
        User userReturn = userMapper.selectByUserPass(input);
        SqlSessionUtil.close(sqlSession);
        return userReturn;
    }

    public int addUser(User user){
        init();
        int row = userMapper.insert(user);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return row;
    }

    public int changePwd(User sessionUser,String newPwd){
        init();
        sessionUser.setPassword(MD5Utils.MD5Encode(newPwd,"utf8"));
        int row = userMapper.updateByPrimaryKey(sessionUser);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return row;
    }

}
