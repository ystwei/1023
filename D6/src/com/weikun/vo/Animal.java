package com.weikun.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Animal {
	
	private String name;
	private int old;
	private List pig;
	private String[] duck;
	
	public String[] getDuck() {
		return duck;
	}
	public void setDuck(String[] duck) {
		this.duck = duck;
	}
	public List getPig() {
		return pig;
	}
	public void setPig(List pig) {
		this.pig = pig;
	}
	private HashMap dog;
	
	public HashMap getDog() {
		return dog;
	}
	public void setDog(HashMap dog) {
		this.dog = dog;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		
		if(name.equals("√®")){
			this.name = name;
		}else if(name.equals("π∑")){
			dog=new HashMap();
			dog.put("red", "∫Ïπ∑");
			dog.put("green", "¬Ãπ∑");
			dog.put("yellow", "ª∆π∑");
			
			
		}else if(name.equals("÷Ì")){
			pig=new ArrayList();
			pig.add("∫Ï÷Ì");
			pig.add("¬Ã÷Ì");
			pig.add("ª∆÷Ì");
			
		}else if(name.equals("—º")){
			duck=new String[3];
			duck[0]="øæ—º";
			
			
		}
	}
	public int getOld() {
		return old;
	}
	public void setOld(int old) {
		this.old = old;
	}
	
}
