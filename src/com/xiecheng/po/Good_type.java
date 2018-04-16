package com.xiecheng.po;

public class Good_type {
	private String type_id;
	private String type_name;
	private String type_desc;
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String type_id) {
		this.type_id = type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getType_desc() {
		return type_desc;
	}
	public void setType_desc(String type_desc) {
		this.type_desc = type_desc;
	}
	public Good_type(String type_id, String type_name, String type_desc) {
		super();
		this.type_id = type_id;
		this.type_name = type_name;
		this.type_desc = type_desc;
	}
	public Good_type() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}