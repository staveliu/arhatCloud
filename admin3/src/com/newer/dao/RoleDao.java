package com.newer.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.newer.entity.Role;
import com.newer.entity.UserInfo;
import com.newer.util.DBUtil;

public class RoleDao {
	
	private Connection conn;
	private QueryRunner query;
	
	public List<Role> findAll(){
		List<Role> list=null;
		String sql="select * from sys_role ";
						
		try {
			conn=DBUtil.getConnection();
			query=new QueryRunner();
			list=query.query(conn, sql, new BeanListHandler<>(Role.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}		
		return list;
	}

}
