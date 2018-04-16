package root.dao;

import java.util.List;
import java.util.Map;

import root.po.Order_good;
import root.util.DBUtil;

public class Order_goodDao {
	public boolean addOrder(Order_good og) {
		return DBUtil.executeUpdate("insert into order_good(ord_good_id,ord_id,good_id,good_size,good_color) values(?,?,?,?,?)",
				new Object[]{og.getOrd_good_id(),og.getOrd_id(),og.getGood_id(),og.getGood_size(),og.getGood_color()});
		
	}
	public List<Map<String, String>> queryAllOrders() {
		return DBUtil.executeQuery("select * from order_good", null) ;
	}
	public boolean deleteOrder(String ord_good_id) {
		return DBUtil.executeUpdate("delete from order_info where ord_good_id=?", new Object[]{ord_good_id});
	}
		
	}

