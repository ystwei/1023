package com.weikun.vo;

import java.io.Serializable;

public class Article implements Serializable {
	private int id;
	private String title;
	private int rootid;
	private String content;
	private String datetime;
	private String userid;
	private BBSUser user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getRootid() {
		return rootid;
	}
	public void setRootid(int rootid) {
		this.rootid = rootid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public BBSUser getUser() {
		return user;
	}
	public void setUser(BBSUser user) {
		this.user = user;
	}
	
}
