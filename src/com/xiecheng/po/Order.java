
package com.xiecheng.po;



public class Order {
	private String ord_id;
	private String ord_u_add;
	private String ord_u_name;
	private String ord_price;
	private String ord_type;
	private String ord_date;
	private String u_id;
	private String ord_u_phone;
	private String ord_count;
	public String getOrd_count() {
		return ord_count;
	}
	public void setOrd_count(String ord_count) {
		this.ord_count = ord_count;
	}
	public String getOrd_u_phone() {
		return ord_u_phone;
	}
	public void setOrd_u_phone(String ord_u_phone) {
		this.ord_u_phone = ord_u_phone;
	}
	public String getOrd_id() {
		return ord_id;
	}
	public void setOrd_id(String ord_id) {
		this.ord_id = ord_id;
	}
	public String getOrd_u_add() {
		return ord_u_add;
	}
	public void setOrd_u_add(String ord_u_add) {
		this.ord_u_add = ord_u_add;
	}
	public String getOrd_u_name() {
		return ord_u_name;
	}
	public void setOrd_u_name(String ord_u_name) {
		this.ord_u_name = ord_u_name;
	}
	public String getOrd_price() {
		return ord_price;
	}
	public void setOrd_price(String ord_price) {
		this.ord_price = ord_price;
	}
	public String getOrd_type() {
		return ord_type;
	}
	public void setOrd_type(String ord_type) {
		this.ord_type = ord_type;
	}
	public String getOrd_date() {
		return ord_date;
	}
	public void setOrd_date(String ord_date) {
		this.ord_date = ord_date;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public Order(String ord_id, String ord_u_add, String ord_u_name, String ord_price, String ord_type,
			String ord_date, String u_id) {
		super();
		this.ord_id = ord_id;
		this.ord_u_add = ord_u_add;
		this.ord_u_name = ord_u_name;
		this.ord_price = ord_price;
		this.ord_type = ord_type;
		this.ord_date = ord_date;
		this.u_id = u_id;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
}
