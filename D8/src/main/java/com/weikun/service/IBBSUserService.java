package com.weikun.service;

import java.io.InputStream;

import com.weikun.vo.BBSUser;

public interface IBBSUserService {
	public BBSUser login(BBSUser user) ;
	public InputStream readPIC(int id) ;
}
