package com.weikun.dao;

import java.util.List;

import com.weikun.vo.Article;

public interface IArticleDAO {
	public List<Article> queryArticles();
}
