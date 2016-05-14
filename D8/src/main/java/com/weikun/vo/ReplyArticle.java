package com.weikun.vo;

import java.util.List;

public class ReplyArticle {
	private List<Article> list;//所有回帖
	private String title;//主帖title
	private int ztuid;
	
	public int getZtuid() {
		return ztuid;
	}
	public void setZtuid(int ztuid) {
		this.ztuid = ztuid;
	}
	public List<Article> getList() {
		return list;
	}
	public void setList(List<Article> list) {
		this.list = list;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
