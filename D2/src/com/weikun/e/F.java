package com.weikun.e;

import java.io.File;

public class F {
	public static void main(String[] args) {
		new F().ok("C:\\");
	}
	
	public void ok(String folder){		
		File file=new File(folder);
		File fs []=file.listFiles();
		for(File f :fs){
			if(f.isDirectory()){
				ok(f.getPath());
			}else{
				System.out.println(f.getAbsolutePath());
			}
		}
		
	}

}
