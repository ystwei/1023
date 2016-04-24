package com.weikun.service;

import java.util.List;

import com.weikun.dao.ArticleDAOImpl;
import com.weikun.dao.IArticleDAO;
import com.weikun.vo.Article;
import com.weikun.vo.PageBean;

public class ArticleServiceImpl implements IArticleService {
	private IArticleDAO dao=new ArticleDAOImpl();
	@Override
	public PageBean queryArticles(int curPage ,int userid) {
		// TODO Auto-generated method stub
		return dao.queryArticles(curPage,userid);
	}
	@Override
	public PageBean deleteArticle(int id) {
		// TODO Auto-generated method stub
		return dao.deleteArticle(id);
	}

}
