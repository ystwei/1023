package com.weikun.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import com.weikun.dao.BBSUserDAOImpl;
import com.weikun.dao.IBBSUserDAO;
import com.weikun.vo.Article;
import com.weikun.vo.BBSUser;

public class BBSUserServiceImpl implements IBBSUserService {
	//由于要上传文件，我们需要设置文件类型
	private Map<String,String> types=new HashMap<String,String>();
	private File tmpDir = null;  
	/** 初始化上传文件后的保存目录 */  
	private File saveDir = null; 
	
	
	public BBSUserServiceImpl(){
		types.put("image/jpeg", ".jpg");
		types.put("image/gif", ".gif");
		types.put("image/x-ms-bmp", ".bmp");
		types.put("image/png", ".png");
		
		//春芳视频和文件的上传目录
		String uppath=""+System.getProperty("file.separator")+"upload";
		
		
		File uf=new File(uppath);
		
		if(!uf.isDirectory()){
			uf.mkdir();
		}
		
	}
	//tpath:tomcat全局路径
	//上传图片
	public BBSUser uploadPic(String tpath,FileItemIterator fi){
		BBSUser user=new BBSUser();
		try {
			while(fi.hasNext()){
				
				FileItemStream fs=fi.next();
				String filetype=fs.getContentType();//得到当前文件的类型 jpg txt jsp
				String fieldname=fs.getFieldName();//文件名字
				
				InputStream is=fs.openStream();
				if(!fs.isFormField()&&fs.getName().length()>0){//是文件域，并且选择了上传的图片
					
					if(types.get(filetype)==null){//不支持文件类型
						
						
						System.out.println("文件类型错误！");
						return null;
					}
					
					//执行文件拷贝
					
					BufferedInputStream bis=new BufferedInputStream(is);
					
					//确定文件名
					UUID uid=UUID.randomUUID();
					String fname=tpath+"\\upload\\"+uid+types.get(filetype);//生成的文件名字
					
					BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(new File(fname)));
					
					
					Streams.copy(bis, bos, true);
					user.setPicpath(fname);
					
					
				}else{//是表单上传的内容 input type=text
					
					switch (fieldname) {
					case "reusername":
						user.setUsername(Streams.asString(is,"utf-8"));
						
						break;
					case "repassword":
						user.setPassword(Streams.asString(is,"utf-8"));
						
						break;
					default:
						break;
					}
				}
				
				
				
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
			
	
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
	@Override
	public void register(BBSUser user) {
		// TODO Auto-generated method stub
		dao.register(user);
	}
	

}
