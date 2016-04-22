package com.weikun.service;

import java.io.InputStream;

import com.weikun.dao.BBSUserDAOImpl;
import com.weikun.dao.IBBSUserDAO;
import com.weikun.vo.BBSUser;

public class BBSUserServiceImpl implements IBBSUserService {
	private IBBSUserDAO dao=new BBSUserDAOImpl();
	@Override
	public BBSUser login(BBSUser user) {
		// TODO Auto-generated method stub
		return dao.login(user);
	}
	@Override
	public InputStream readPIC(int id) {
		// TODO Auto-generated method stub
		return dao.readPIC(id);
	}

}
