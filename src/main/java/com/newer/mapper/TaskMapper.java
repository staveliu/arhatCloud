package com.newer.mapper;

import com.newer.domain.Task;

import java.util.List;

public interface TaskMapper {
    int deleteByPrimaryKey(Integer taskid);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(Integer taskid);

    List<Task> selectByUid(Integer uid);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);
}