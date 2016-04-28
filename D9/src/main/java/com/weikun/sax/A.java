package com.weikun.sax;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.DefaultHandler;

public class A extends DefaultHandler{
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("开始读取文档");
	}
	
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("结束读取文档");
	}
	@Override
	public void startElement(String arg0, String arg1, String arg2,
			Attributes arg3) throws SAXException {
		// TODO Auto-generated method stub
		//super.startElement(arg0, arg1, arg2, arg3);
		System.out.println("开始读取元素"+arg2);
		if(arg3.getValue("id")!=null){
			System.out.println(arg3.getValue("id"));
		}
	}
	@Override
	public void endElement(String arg0, String arg1, String arg2)
			throws SAXException {
		// TODO Auto-generated method stub
	//	super.endElement(arg0, arg1, arg2);
		System.out.println("结束读取元素"+arg2);
	}
	
	@Override
	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(arg0, arg1, arg2);
		System.out.println(new String(arg0,arg1,arg2).trim());
		
	}
	public static void main(String[] args) {
		new A().write();
	}
	public void write(){
		try {
			SAXTransformerFactory sf=(SAXTransformerFactory)SAXTransformerFactory.newInstance();
			TransformerHandler th=sf.newTransformerHandler();
			Transformer tf=th.getTransformer();
			
			tf.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			String path=A.class.getClassLoader().getResource("").getPath()+"//yst4.xml";
			FileOutputStream fos=new FileOutputStream(new File(path));
			
			
			Result res=new StreamResult(fos);
			
			
			th.setResult(res);
			th.startDocument();
			AttributesImpl as=new AttributesImpl();
			th.startElement("", "", "yst", as);
			
			for(int i=1;i<3;i++){
				as.addAttribute("","", "id", "", "0"+i);
				
				th.startElement("", "", "student", as);
				
				as.removeAttribute(0);
				
				th.startElement("", "", "name", as);
				String value="李刚"+i;
				th.characters(value.toCharArray(), 0, value.length());		
				
				th.endElement("", "", "name");
				
				
				th.startElement("", "", "address", as);
				String address="哈尔滨"+i;
				th.characters(address.toCharArray(), 0, address.length());		
				
				th.endElement("", "", "address");
				
				
				th.endElement("", "", "student");
			}
			
			
			th.endElement("", "", "yst");
			th.endDocument();
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public void read(){
		SAXParserFactory sf=null;
		try {
			InputStream is=A.class.getClassLoader().getSystemResourceAsStream("yst.xml");
			sf=SAXParserFactory.newInstance();
			SAXParser sp=sf.newSAXParser();
			
			
			sp.parse(is, new A());
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	

}
