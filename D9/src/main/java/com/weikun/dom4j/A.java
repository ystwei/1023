package com.weikun.dom4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class A {
	public static void main(String[] args) {
		new A().write();
	}
	public void read(){
		try {
			InputStream is=new FileInputStream(A.class.getClassLoader().getResource("").getPath()+"//yst.xml");

			BufferedReader br= new BufferedReader( new InputStreamReader(is,"utf-8"));
			String s="";
			StringBuffer sb=new StringBuffer();
			while( (s=br.readLine())!=null){
				sb.append(s.trim());
			}
			Document doc=DocumentHelper.parseText(sb.toString());
			
			Element root=doc.getRootElement();
			
			System.out.println(root.getName());
			List<Element> list=root.elements("student");
			for(Element student :list){
				
				System.out.println(student.attributeValue("id"));
				Element name=student.element("name");
				
				
				System.out.println(name.getTextTrim());
				
				
				Element address=student.element("address");
				System.out.println(address.getTextTrim());
				
			}
					
			
			
			is.close();
			br.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{


		}

	}
	public void write(){
		String path=A.class.getClassLoader().getResource("").getPath()+"//yst2.xml";
		File file=new File(path);
		try {
			FileOutputStream fos=new FileOutputStream(file);
			OutputFormat of=OutputFormat.createPrettyPrint();
			of.setEncoding("utf-8");
			of.setIndentSize(4);
			XMLWriter w=null;
			try {
				w= new XMLWriter(fos,of);

				Document doc=DocumentHelper.createDocument();

				Element root=doc.addElement("yst");

				for(int i=1;i<3;i++){
					Element student =root.addElement("student");
					student.addAttribute("id", "0"+i);

					Element name=student.addElement("name");
					name.setText("李刚"+i);

					Element address=student.addElement("address");
					address.setText("哈尔滨"+i);
				}				

				try {
					//2写在内存中
					System.out.println(doc.asXML());
					
					//1写在硬盘中
					
					w.write(doc);
					w.flush();
					w.close();
					
					
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}



			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}





	}
}
