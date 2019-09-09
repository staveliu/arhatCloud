package com.newer.mapper;

import com.newer.domain.Task;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TaskMapper {
    int deleteByPrimaryKey(Integer taskid);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(Integer taskid);
    @Select("SELECT * FROM yin_task where uid=#{uid}")
    List<Task> selectByUid(Integer uid);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);
}