package com.newer.mapper;

import com.newer.domain.Files;

public interface FilesMapper {
    int deleteByPrimaryKey(Integer fid);

    int insert(Files record);

    int insertSelective(Files record);

    Files selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(Files record);

    int updateByPrimaryKey(Files record);
}