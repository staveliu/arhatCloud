package com.newer.entity;

import java.io.Serializable;
import java.util.List;
/**
 * 授权用户类
 * @author fulia
 *
 */
public class AuthorityUser implements Serializable{
	
	private Integer userid;
	private String username;//用户名
	private Integer roleid;
	private String rolename;//角色名
	private List<FirstMenu> firsts;//一级菜单集合
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public List<FirstMenu> getFirsts() {
		return firsts;
	}
	public void setFirsts(List<FirstMenu> firsts) {
		this.firsts = firsts;
	}
	
	

}
