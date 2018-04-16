package com.xiecheng.po;

public class Shopping_cart {
	private String shop_id;
	private String good_id;
	private String good_name;
	private String good_count;
	private String good_price;
	private String u_id;
	private String good_pic;
	private String good_size;
	private String good_color;
	
	public String getGood_pic() {
		return good_pic;
	}
	public void setGood_pic(String good_pic) {
		this.good_pic = good_pic;
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
	public String getShop_id() {
		return shop_id;
	}
	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}
	public String getGood_id() {
		return good_id;
	}
	public void setGood_id(String good_id) {
		this.good_id = good_id;
	}
	public String getGood_name() {
		return good_name;
	}
	public void setGood_name(String good_name) {
		this.good_name = good_name;
	}
	public String getGood_count() {
		return good_count;
	}
	public void setGood_count(String good_count) {
		this.good_count = good_count;
	}
	public String getGood_price() {
		return good_price;
	}
	public void setGood_price(String good_price) {
		this.good_price = good_price;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public Shopping_cart(String shop_id, String good_id, String good_name, String good_count, String good_price,
			String u_id, String good_pic, String good_size, String good_color) {
		super();
		this.shop_id = shop_id;
		this.good_id = good_id;
		this.good_name = good_name;
		this.good_count = good_count;
		this.good_price = good_price;
		this.u_id = u_id;
		this.good_pic = good_pic;
		this.good_size = good_size;
		this.good_color = good_color;
	}
	public Shopping_cart() {
		super();
		// TODO Auto-generated constructor stub
	}
}
