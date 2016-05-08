package com.weikun.service;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.alibaba.fastjson.JSON;
import com.weikun.vo.City;

public class CityService {
	public String makeCityJSON(String pro){
		
		/*
		 *   [
		 *   	{"name":"哈尔滨","value":"hrb"},
		 *   	{"name":"鹤岗","value":"hg"}
		 *   
		 *   ]
		 * 
		 */
		List<City> list=new ArrayList<City>();
		if(pro.equals("hlj")){
			list.add(new City("哈尔滨","hrb"));
			list.add(new City("鹤岗","hg"));
		}else if(pro.equals("ln")){
			list.add(new City("沈阳","sy"));
			list.add(new City("大连","dl"));
		}
		return JSON.toJSONString(list);
		
	}
	public String makeCityXML(String pro){		
		Document doc=DocumentHelper.createDocument();		
		Element root=doc.addElement("citys");		
		if(pro.equals("hlj")){
			Element city1=root.addElement("city");
			Element name1=city1.addElement("name");
			name1.setText("哈尔滨");
			Element value1=city1.addElement("value");
			value1.setText("heb");
			
			Element city2=root.addElement("city");
			Element name2=city2.addElement("name");
			name2.setText("鹤岗");
			Element value2=city2.addElement("value");
			value2.setText("heg");
			
		}else if(pro.equals("ln")){
			Element city1=root.addElement("city");
			Element name1=city1.addElement("name");
			name1.setText("沈阳");
			Element value1=city1.addElement("value");
			value1.setText("sy");			
			Element city2=root.addElement("city");
			Element name2=city2.addElement("name");
			name2.setText("大连");
			Element value2=city2.addElement("value");
			value2.setText("dl");
		}
		
		return doc.asXML();
	}
	
	public static void main(String[] args) {
		System.out.println(new CityService().makeCityJSON("ln"));
	}
}
