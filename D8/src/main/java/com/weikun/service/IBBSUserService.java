package com.weikun.service;

import java.io.InputStream;
import java.util.List;

import org.apache.commons.fileupload.FileItemIterator;

import com.weikun.vo.Article;
import com.weikun.vo.BBSUser;

public interface IBBSUserService {
	public BBSUser login(BBSUser user) ;
	public InputStream readPIC(int id) ;
	public void register(BBSUser user) ;
	public BBSUser uploadPic(String tpath,FileItemIterator fi);
	public void updatePageNum(BBSUser user) ;
	
}
