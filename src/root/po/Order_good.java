package root.po;

public class Order_good {
	private String ord_good_id;
	private String good_id;
	private String ord_id;
	private String good_size;
	private String good_color;
	public String getOrd_good_id() {
		return ord_good_id;
	}
	public void setOrd_good_id(String ord_good_id) {
		this.ord_good_id = ord_good_id;
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
	public Order_good(String ord_good_id, String good_id, String ord_id, String good_size, String good_color) {
		super();
		this.ord_good_id = ord_good_id;
		this.good_id = good_id;
		this.ord_id = ord_id;
		this.good_size = good_size;
		this.good_color = good_color;
	}
	public Order_good() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}