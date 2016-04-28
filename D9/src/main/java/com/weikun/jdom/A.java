package com.weikun.jdom;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class A {
	public static void main(String[] args) {
		new A().write();
	}
	public void write(){//写yst.xml
		Element root=new Element("yst");
		
		for(int i=1;i<3;i++){
			Element student=new Element("student");
			
			student.setAttribute("id","0"+i);
			
			Element name=new Element("name");
			
			name.setText("李刚"+i);
			
			Element address=new Element("address");
			
			address.setText("哈尔滨"+i);
			
			
			student.addContent(name);
			student.addContent(address);
			root.addContent(student);
			
		}
		Document doc=new Document(root);
		
		XMLOutputter out=new XMLOutputter();
		System.out.println(A.class.getClassLoader().getResource("").getPath());
		String path=A.class.getClassLoader().getResource("").getPath()+"\\yst.xml";
		try {
			//1写在硬盘中
			out.output(doc, new FileOutputStream(new File(path)));
			//2写在内存中
			System.out.println(out.outputString(doc));
			System.out.println("输出成功");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void read(){//读取yst.xml
		//1找到要解析的文件位置
		SAXBuilder sb=new SAXBuilder();
		InputStream is=A.class.getClassLoader().getResourceAsStream("yst.xml");
		try {
			Document doc=sb.build(is);
			
			Element root=doc.getRootElement();
			
			System.out.println(root.getName());
			
			
			List<Element> list=root.getChildren("student");
			
			for(Element student :list){
				System.out.println(student.getAttributeValue("id"));
				Element name=student.getChild("name");
				System.out.println(name.getTextTrim());
				
				Element address=student.getChild("address");
				System.out.println(address.getTextTrim());
			}
			
			
			
			
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
