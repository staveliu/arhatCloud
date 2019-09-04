package com.newer.mapper;

import com.newer.domain.PrinterAddress;

public interface PrinterAddressMapper {
    int deleteByPrimaryKey(Integer addrid);

    int insert(PrinterAddress record);

    int insertSelective(PrinterAddress record);

    PrinterAddress selectByPrimaryKey(Integer addrid);

    int updateByPrimaryKeySelective(PrinterAddress record);

    int updateByPrimaryKey(PrinterAddress record);
}