package com.weikun.vo;

import java.io.Serializable;
import java.util.List;

public class BBSUser implements Serializable {
	private int id;
	private String username;
	private String password;
	private String picpath;//头像在服务器中的路径
	private List<Article> alist;
	
	public List<Article> getAlist() {
		return alist;
	}
	public void setAlist(List<Article> alist) {
		this.alist = alist;
	}
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	private int pagenum;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	
}
