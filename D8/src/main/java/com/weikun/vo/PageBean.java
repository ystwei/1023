package com.weikun.vo;

import java.io.Serializable;
import java.util.List;

public class PageBean implements Serializable {
	private int curPage;//当前页码
	private int maxPage;//最大页数
	private int rowsPerPage;//每页的行数
	private int maxRows;//最大的行数
	private List<Article> data;//每页的数据
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getRowsPerPage() {
		return rowsPerPage;
	}
	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}
	public int getMaxRows() {
		return maxRows;
	}
	public void setMaxRows(int maxRows) {
		this.maxRows = maxRows;
	}
	public List<Article> getData() {
		return data;
	}
	public void setData(List<Article> data) {
		this.data = data;
	}
	
}
