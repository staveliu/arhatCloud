package com.newer.mapper;

import com.newer.domain.Printer;

public interface PrinterMapper {
    int deleteByPrimaryKey(Integer printid);

    int insert(Printer record);

    int insertSelective(Printer record);

    Printer selectByPrimaryKey(Integer printid);

    int updateByPrimaryKeySelective(Printer record);

    int updateByPrimaryKeyWithBLOBs(Printer record);

    int updateByPrimaryKey(Printer record);
}