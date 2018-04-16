package com.xiecheng.po;

import java.sql.Date;

public class User {
	private String u_id;
	private String username;
	private String u_pwd;
	private String u_address;
	private String u_birth;
	private String u_num;
	private String u_gender;
	private String u_money;
	private String u_name;
	private String type;
	private String u_pic;
	public String getU_pic() {
		return u_pic;
	}
	public void setU_pic(String u_pic) {
		this.u_pic = u_pic;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getU_pwd() {
		return u_pwd;
	}
	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}
	public String getU_address() {
		return u_address;
	}
	public void setU_address(String u_address) {
		this.u_address = u_address;
	}
	public String getU_birth() {
		return u_birth;
	}
	public void setU_birth(String u_birth) {
		this.u_birth = u_birth;
	}
	public String getU_num() {
		return u_num;
	}
	public void setU_num(String u_num) {
		this.u_num = u_num;
	}
	public String getU_gender() {
		return u_gender;
	}
	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}
	public String getU_money() {
		return u_money;
	}
	public void setU_money(String u_money) {
		this.u_money = u_money;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public User( String username, String u_id,String u_pwd, String u_address, String u_birth, String u_num,
			String u_gender, String u_money, String u_name, String type) {
		super();
		this.u_id = u_id;
		this.username = username;
		this.u_pwd = u_pwd;
		this.u_address = u_address;
		this.u_birth = u_birth;
		this.u_num = u_num;
		this.u_gender = u_gender;
		this.u_money = u_money;
		this.u_name = u_name;
		this.type = type;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}