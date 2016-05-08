package com.weikun.vo;

import java.io.Serializable;

public class City implements Serializable {
	private String name;
	private String value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public City(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
	
}
