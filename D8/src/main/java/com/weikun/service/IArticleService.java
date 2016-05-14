package com.weikun.service;

import java.util.List;

import com.weikun.vo.Article;
import com.weikun.vo.PageBean;
import com.weikun.vo.ReplyArticle;

public interface IArticleService {
	public PageBean queryArticles( int curPage,int userid);
	public PageBean deleteArticle(int id) ;
	public PageBean addArticle(Article a) ;
	public String queryCTById(int id) ;
	public String deleteCtById(int id,int rootid) ;
}
