package com.xiecheng.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.xiecheng.po.Order;
import com.xiecheng.po.User;
import com.xiecheng.util.DBUtil;

public class OrderDao {
	public boolean addOrder(Order order) {
		return DBUtil.executeUpdate("insert into order_info(ord_u_name,ord_u_add,ord_price,ord_type,ord_date,u_id,ord_u_phone,ord_count) values(?,?,?,?,?,?,?,?)",
				new Object[]{order.getOrd_u_name(),order.getOrd_u_add(),order.getOrd_price(),order.getOrd_type(),order.getOrd_date(),order.getU_id(),order.getOrd_u_phone(),order.getOrd_count()});
	}

	public List<Map<String, String>> queryAllOrders() {
		return DBUtil.executeQuery("select * from order_info", null) ;
	}
	public List<Map<String, String>> queryOrdersByU_id(String u_id) {
		return DBUtil.executeQuery("select * from order_info where u_id=?", new Object[]{u_id});
	}

	
	public int queryOrdersCount(String ord_type,String ord_u_name) {
		
		String sql = "select count(*) as totalcount from order_info";
		List<Object> list = new ArrayList<Object>();
	
		if(ord_type!=null&&!"".equals(ord_type)){
			sql+=" and ord_type like ?";
			list.add("%"+ord_type+"%");
			
		}
	
		if(ord_u_name!=null&&!"".equals(ord_u_name)){
			//like模糊查询
			sql+=" and ord_u_name like ?";
			list.add("%"+ord_u_name+"%");
			
		}
		
		return Integer.valueOf(DBUtil.executeQuery(sql, list.size()>0?list.toArray():null).get(0).get("totalcount"));
	}

	//根据分页查询新闻(有条件)

	public List<Map<String, String>> queryOrdersByPage(int cpage,int pagesize,String ord_u_name,String ord_u_add) {
		String sql = "select * from order_info";
		List<Object> list = new ArrayList<Object>();
		//判断是否有标题这个条件
		if(ord_u_name!=null&&!"".equals(ord_u_name)){
			sql+=" and ord_u_name like ?";
			list.add("%"+ord_u_name+"%");
			
		}
		//判断是否有用户名这个条件 
		if(ord_u_add!=null&&!"".equals(ord_u_add)){
			sql+=" and ord_u_add like ?";
			list.add("%"+ord_u_add+"%");
			
		}
		sql+=" limit ?,?";
		list.add((cpage-1)*pagesize);
		list.add(pagesize);
		return DBUtil.executeQuery(sql, list.toArray());
	}

	
	public Map<String, String> queryOrderDetail(String ord_id) {
		String sql = "select * from order_info where ord_id=?";
		return DBUtil.executeQuery(sql,new Object[]{ord_id}).get(0);
		
	}
	public Map<String, String> queryOrderDetailByTime(String time) {
		String sql = "select * from order_info where ord_date=?";
		return DBUtil.executeQuery(sql,new Object[]{time}).get(0);
		
	}

	public boolean deleteOrder(String ord_id) {
		return DBUtil.executeUpdate("delete from order_info where ord_id=?", new Object[]{ord_id});
	}

	public boolean updateOrder(Order order) {
		String sql="update order_info set ord_u_name=?,ord_u_add=?,ord_price=?,ord_type=?,ord_date=?,u_id=?,ord_u_phone=?,ord_count=? where ord_id=?";
		return DBUtil.executeUpdate(sql, new Object[]{order.getOrd_u_name(),order.getOrd_u_add(),order.getOrd_price(),order.getOrd_type(),order.getOrd_date(),order.getU_id(),order.getOrd_u_phone(),order.getOrd_count(),order.getOrd_id()});
	}
	
}