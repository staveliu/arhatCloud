package com.newer.entity;

import java.io.Serializable;
import java.util.List;
/**
 * 一级菜单类
 * @author fulia
 *
 */
public class FirstMenu implements Serializable{
	
	private Menu first;//一级对象
	private List<Menu> seconds;//一级菜单包含的二级菜单集合
	
	
	public Menu getFirst() {
		return first;
	}
	public void setFirst(Menu first) {
		this.first = first;
	}
	public List<Menu> getSeconds() {
		return seconds;
	}
	public void setSeconds(List<Menu> seconds) {
		this.seconds = seconds;
	}
	
	
	
	

}
