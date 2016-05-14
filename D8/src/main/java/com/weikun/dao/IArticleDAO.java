package com.weikun.dao;

import java.util.List;

import com.weikun.vo.Article;
import com.weikun.vo.PageBean;
import com.weikun.vo.ReplyArticle;

public interface IArticleDAO {
	public PageBean queryArticles(int curPage,int userid);
	public PageBean deleteArticle(int id);
	public PageBean addArticle(Article a);
	public ReplyArticle queryCTById(int id);//根据主帖id，查到所有从贴，返回所有从贴，并带主帖title
	public ReplyArticle deleteCtById(int id,int rootid);
	
}
