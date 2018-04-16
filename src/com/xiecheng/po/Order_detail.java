package com.xiecheng.po;

public class Order_detail {
	private String detail_id;
	private String good_id;
	private String ord_id;
	private String good_size;
	private String good_color;
	public String getDetail_id() {
		return detail_id;
	}
	public void setDetail_id(String detail_id) {
		this.detail_id = detail_id;
	}
	public String getGood_id() {
		return good_id;
	}
	public void setGood_id(String good_id) {
		this.good_id = good_id;
	}
	public String getOrd_id() {
		return ord_id;
	}
	public void setOrd_id(String ord_id) {
		this.ord_id = ord_id;
	}
	public String getGood_size() {
		return good_size;
	}
	public void setGood_size(String good_size) {
		this.good_size = good_size;
	}
	public String getGood_color() {
		return good_color;
	}
	public void setGood_color(String good_color) {
		this.good_color = good_color;
	}
	public Order_detail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order_detail(String detail_id, String good_id, String ord_id, String good_size, String good_color) {
		super();
		this.detail_id = detail_id;
		this.good_id = good_id;
		this.ord_id = ord_id;
		this.good_size = good_size;
		this.good_color = good_color;
	}
	
	
}