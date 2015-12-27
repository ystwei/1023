package com.weikun.nio;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class A {
	public static void main(String[] args) {
		new A().simpleFile();
	}
	public void simpleFile(){
		Path p=Paths.get("c://1.sql");
		try {
			List<String> list=Files.readAllLines(p, StandardCharsets.UTF_8);
//			for(String s :list){
//				System.out.println(s);
//			}
			byte [] buffer=Files.readAllBytes(p);
			System.out.println(new String(buffer,"utf-8"));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public void writeFile(){
		Path p=Paths.get("D://2.sql");
		if(!p.toFile().exists()){
			try {
				p.toFile().createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		BufferedWriter bw =null;
		try {
			bw=Files.newBufferedWriter(p, StandardCharsets.UTF_8,StandardOpenOption.WRITE);
			
			
			bw.write("ฤใบรย่ย่ย่ย่ย่ย่ย่ย่ย่ย่ฤวรดฃก");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bw.flush();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	public void readFile(){
		Path p=Paths.get("c://1.sql");
		BufferedReader br =null;
		try {
			br=Files.newBufferedReader(p, StandardCharsets.UTF_8);
			String line="";
			while((line=br.readLine())!=null){
				System.out.println(line);
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
