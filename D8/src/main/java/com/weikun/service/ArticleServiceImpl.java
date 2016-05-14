package com.weikun.service;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.weikun.dao.ArticleDAOImpl;
import com.weikun.dao.IArticleDAO;
import com.weikun.vo.Article;
import com.weikun.vo.PageBean;
import com.weikun.vo.ReplyArticle;

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
	@Override
	public PageBean addArticle(Article a) {
		// TODO Auto-generated method stub
		return dao.addArticle(a);
	}
	@Override
	public  String queryCTById(int id) {
		// TODO Auto-generated method stub
		ReplyArticle ra=dao.queryCTById(id);
		
		
		
		return JSON.toJSONString(ra);
	}
	public static void main(String[] args) {
		System.out.println(new ArticleServiceImpl().queryCTById(168));
	}
	@Override
	public String deleteCtById(int id, int rootid) {
		// TODO Auto-generated method stub
		return JSON.toJSONString(dao.deleteCtById(id, rootid));
	}

}
