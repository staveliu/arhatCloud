package com.newer.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
 * 数据库连接工具类
 * @author fulia
 *
 */
public class DBUtil {
	
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	static {		
		try {
			Properties prop=new Properties();
			InputStream is=DBUtil.class.getClassLoader().getResourceAsStream("com/newer/util/mysql.properties");
			prop.load(is);
			driver=prop.getProperty("driver");
			url=prop.getProperty("url");
			user=prop.getProperty("user");
			password=prop.getProperty("password");
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 获取连接的静态方法
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	/**
	 * 关闭资源
	 * @param conn
	 * @param st
	 * @throws SQLException 
	 */
	public static void closeAll(Connection conn,Statement st,ResultSet rs) throws SQLException {
		if(rs!=null) {
			rs.close();
		}
		if(st!=null) {
			st.close();
		}
		if(conn!=null) {
			conn.close();
		}
	}

}
