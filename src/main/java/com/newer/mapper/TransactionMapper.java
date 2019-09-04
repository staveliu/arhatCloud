package com.newer.mapper;

import com.newer.domain.Transaction;

public interface TransactionMapper {
    int deleteByPrimaryKey(Integer transid);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(Integer transid);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);
}