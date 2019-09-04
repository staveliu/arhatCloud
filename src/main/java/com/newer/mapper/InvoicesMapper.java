package com.newer.mapper;

import com.newer.domain.Invoices;

public interface InvoicesMapper {
    int deleteByPrimaryKey(Integer invoiceid);

    int insert(Invoices record);

    int insertSelective(Invoices record);

    Invoices selectByPrimaryKey(Integer invoiceid);

    int updateByPrimaryKeySelective(Invoices record);

    int updateByPrimaryKeyWithBLOBs(Invoices record);

    int updateByPrimaryKey(Invoices record);
}