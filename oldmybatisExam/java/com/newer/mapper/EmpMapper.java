package com.newer.mapper;

import com.newer.domain.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author shining
 */
public interface EmpMapper {

    @Insert("insert into emp values(#{empno},#{ename}," +
            "#{sal},#{hiredate},#{dept.deptno},#{job})")
    int addEmp(Emp emp);

    @Update("update emp set ename=#{ename},sal=#{sal}," +
            "hiredate=#{hiredate},deptno=#{dept.deptno}," +
            "job=#{job} where empno=#{empno}")
    int updateEmp(Emp emp);
    @Delete("delete from emp where empno=#{empno}")
    int deleteEmp(@Param("empno")int empno);

    @Select("select * from emp where empno=#{empno}")
    Emp findByNo(@Param("empno")int empno);

    @Results(value = {@Result(property = "empno",column = "empno",id = true),
                      @Result(property = "ename",column = "ename"),
                       @Result(property="sal",column = "sal"),
                       @Result(property = "hiredate",column = "hiredate"),
                      @Result(property = "job",column = "job"),
                       @Result(property = "dept",column = "deptno",javaType = com.newer.domain.Dept.class,
                                one = @One(select = "com.newer.mapper.DeptMapper.findByNo")) })
    @Select("select * from emp")
    List<Emp> findAll();

    List<Emp> findAll2();

}
