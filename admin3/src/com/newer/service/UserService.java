package com.newer.service;

import java.util.ArrayList;
import java.util.List;

import com.newer.dao.MenuDao;
import com.newer.dao.RoleDao;
import com.newer.dao.UserDao;
import com.newer.entity.AuthorityUser;
import com.newer.entity.FirstMenu;
import com.newer.entity.Menu;
import com.newer.entity.Role;
import com.newer.entity.UserInfo;
import com.newer.util.MD5;
/**
 * 用户业务类
 * @author fulia
 *
 */
public class UserService {
	
	private UserDao userDao;
	private MenuDao menuDao;
	private RoleDao roleDao;
	
	
	
	
	public UserService() {
		userDao=new UserDao();
		menuDao=new MenuDao();
		roleDao=new RoleDao();
	}
	
	public UserInfo login(String username,String password) {
		//对原始密码进行加密
		String pwd=MD5.getInstance().getMD5ofStr(password);
		return userDao.findByParam(username, pwd);
	}
	
	public List<UserInfo> findAll(){
		return userDao.findAll();
	}
	
	public int updateState(int userId,int state) {
		return userDao.updateState(userId, state);
	}
	
	public int changPwd(int userId,String password) {
		String pwd=MD5.getInstance().getMD5ofStr(password);
		return userDao.updatePwd(userId, pwd);
	}
	/**
	 * 封装授权用户信息
	 * @param userid
	 * @return
	 */
	public AuthorityUser getUser(int userid) {
		AuthorityUser user=userDao.findById(userid);
		//创建一级菜单集合对象
		List<FirstMenu> list=new ArrayList<FirstMenu>();
		//按角色编号查询一级菜单集合，遍历集合
		menuDao.findFirsts(user.getRoleid()).forEach(menu->{
			FirstMenu fm=new FirstMenu();
			fm.setFirst(menu);
			//按角色编号和一级菜单编号查询二级菜单集合
			fm.setSeconds(menuDao.findSeconds(user.getRoleid(), menu.getId()));
			list.add(fm);
		});
		
		user.setFirsts(list);
		return user;
	}
	
	public List<Role> findAllRole(){
		return roleDao.findAll();
	}
	/**
	 * 按用户编号查询用于信息：用于修改
	 * @param userId
	 * @return
	 */
	public UserInfo findById(int userId) {
		return userDao.findById2(userId);
	}

	
}
