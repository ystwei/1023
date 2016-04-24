package com.weikun.dao;

import java.util.List;

import com.weikun.vo.Article;
import com.weikun.vo.PageBean;

public interface IArticleDAO {
	public PageBean queryArticles(int curPage,int userid);
	public PageBean deleteArticle(int id);
}
