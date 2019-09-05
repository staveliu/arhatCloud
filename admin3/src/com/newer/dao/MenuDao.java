package com.newer.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.newer.entity.Menu;
import com.newer.entity.UserInfo;
import com.newer.util.DBUtil;

public class MenuDao {
	
	private Connection conn;
	private QueryRunner query;
	/**
	 * 按角色编号查询一级菜单集合
	 * @param roleid
	 * @return
	 */
	public List<Menu> findFirsts(int roleid) {
		List<Menu> list=null;
		String sql="select m.id,m.name,seq " + 
				"from sys_role r join role_menu rm on " + 
				"r.id=rm.roleid join sys_menu m on rm.menuid=m.id " + 
				"where m.parentid is null and r.id=? order by seq ";
		
		try {
			conn=DBUtil.getConnection();
			query=new QueryRunner();
			list=query.query(conn, sql, new BeanListHandler<>(Menu.class), roleid);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}		
		return list;
	}
	/**
	 * 按角色编号和父菜单编号查询二级菜单集合
	 * @param roleid
	 * @param menuid
	 * @return
	 */
	public List<Menu> findSeconds(int roleid,int menuid){
		List<Menu> list=null;
		String sql="select m.id,m.name,seq,linkurl " + 
				"from sys_role r join role_menu rm on " + 
				"r.id=rm.roleid join sys_menu m on rm.menuid=m.id " + 
				"where m.parentid=? and r.id=? order by seq ";
		
		try {
			conn=DBUtil.getConnection();
			query=new QueryRunner();
			list=query.query(conn, sql, new BeanListHandler<>(Menu.class), new Object[] {menuid,roleid});
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}		
		return list;
	}

}
