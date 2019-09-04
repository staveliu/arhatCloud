package com.newer.mapper;

import com.newer.domain.Dept;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author shining
 */
public interface DeptMapper {
    @Select("select * from dept where deptno=#{deptno}")
    Dept findByNo(@Param("deptno")int deptno);
    @Select("select * from dept")
    List<Dept> findAll();
}
