package com.newer.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.newer.entity.AuthorityUser;
import com.newer.entity.UserInfo;
import com.newer.util.DBUtil;

public class UserDao {
	
	private Connection conn;
	private QueryRunner query;
	
	public UserInfo findByParam(String username,String password) {
		UserInfo user=null;
		String sql="select * from sys_user "
				+ "where username=? and password=?";
		
		try {
			conn=DBUtil.getConnection();
			query=new QueryRunner();
			user=query.query(conn, sql, new BeanHandler<>(UserInfo.class), new Object[] {username,password});
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}		
		return user;
	}
	
	/**
	 * 查询所有用户信息
	 * @return
	 */
	public List<UserInfo> findAll() {
		List<UserInfo> list=null;
		String sql="select * from sys_user ";
						
		try {
			conn=DBUtil.getConnection();
			query=new QueryRunner();
			list=query.query(conn, sql, new BeanListHandler<>(UserInfo.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}		
		return list;
	}
	
	/**
	 * 查询所有用户信息
	 * @return
	 */
	public UserInfo findById2(int userId) {
		UserInfo user=null;
		String sql="select u.userid,username,sex,mobile,email,job,ur.roleid "
				+ "from sys_user u left join user_role ur on u.userid=ur.userid "
				+ "where u.userid=?";
						
		try {
			conn=DBUtil.getConnection();
			query=new QueryRunner();
			user=query.query(conn, sql, new BeanHandler<>(UserInfo.class),userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}		
		return user;
	}
	
	public int updatePwd(int userId,String password) {
		int row=0;
		String sql="update sys_user set password=? where userid=?";
		
		try {
			conn=DBUtil.getConnection();
			query=new QueryRunner();
			row=query.update(conn, sql, new Object[] {password,userId});
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}		
		return row;
	}
	
	public int updateState(int userId,int state) {
		int row=0;
		String sql="update sys_user set state=? where userid=?";
		
		try {
			conn=DBUtil.getConnection();
			query=new QueryRunner();
			row=query.update(conn, sql, new Object[] {state,userId});
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}		
		return row;
	}
	
	public AuthorityUser findById(int userid) {
		AuthorityUser user=null;
		String sql="select u.userid,username,id roleid,name rolename from " + 
				" sys_user u join user_role ur on u.userid=ur.userid " + 
				" join sys_role r on ur.roleid=r.id where u.userid=?";		
		try {
			conn=DBUtil.getConnection();
			query=new QueryRunner();
			user=query.query(conn, sql, new BeanHandler<>(AuthorityUser.class), userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}	
		return user;
	}

}
