package com.newer.mapper;

import com.newer.domain.PrinterLog;

public interface PrinterLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PrinterLog record);

    int insertSelective(PrinterLog record);

    PrinterLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PrinterLog record);

    int updateByPrimaryKey(PrinterLog record);
}