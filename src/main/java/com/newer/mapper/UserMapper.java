package com.newer.mapper;

import com.newer.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    User selectByUserPass(String username,String password);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}