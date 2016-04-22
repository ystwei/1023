package com.weikun.dao;

import java.io.InputStream;

import com.weikun.vo.BBSUser;

public interface IBBSUserDAO {
	public BBSUser login(BBSUser user);
	public InputStream readPIC(int id) ;
}
