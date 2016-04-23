package com.weikun.service;

import java.util.List;

import com.weikun.dao.ArticleDAOImpl;
import com.weikun.dao.IArticleDAO;
import com.weikun.vo.Article;

public class ArticleServiceImpl implements IArticleService {
	private IArticleDAO dao=new ArticleDAOImpl();
	@Override
	public List<Article> queryArticles() {
		// TODO Auto-generated method stub
		return dao.queryArticles();
	}

}
