package com.weikun.service;

import com.weikun.dao.IUserDAO;
import com.weikun.dao.UserDAOImpl;
import com.weikun.vo.MyUser;

public class UserServiceImpl implements IUserService {
	private IUserDAO dao=new UserDAOImpl();
	@Override
	public boolean login(MyUser user) {
		// TODO Auto-generated method stub
		return dao.login(user);
	}

}
