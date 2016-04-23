package com.weikun.dao;

import java.io.InputStream;
import java.util.List;

import com.weikun.vo.Article;
import com.weikun.vo.BBSUser;

public interface IBBSUserDAO {
	public BBSUser login(BBSUser user);
	public InputStream readPIC(int id) ;
	public void register(BBSUser user);

}
