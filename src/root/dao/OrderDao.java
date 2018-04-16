package root.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import root.po.Order;
import root.util.DBUtil;

public class OrderDao {
	public boolean addOrder(Order order) {
		return DBUtil.executeUpdate("insert into order_info(ord_u_name,ord_u_add,ord_price,ord_type,ord_date,u_id) values(?,?,?,?,?,?)",
				new Object[]{order.getOrd_u_name(),order.getOrd_u_add(),order.getOrd_price(),order.getOrd_type(),order.getOrd_date(),order.getU_id()});
		
		
	}

	public List<Map<String, String>> queryAllOrders() {
		return DBUtil.executeQuery("select * from order_info", null) ;
	}

	
	public int queryOrdersCount(String ord_id,String ord_type) {
		
		String sql = "select count(*) as totalcount from order_info where 1=1 ";
		List<Object> list = new ArrayList<Object>();
	
		if(ord_type!=null&&!"".equals(ord_type)){
			sql+=" and ord_type like ?";
			list.add("%"+ord_type+"%");
			
		}
	
		if(ord_id!=null&&!"".equals(ord_id)){
			//like模糊查询
			sql+=" and ord_id like ?";
			list.add("%"+ord_id+"%");
			
		}
		
		return Integer.valueOf(DBUtil.executeQuery(sql, list.size()>0?list.toArray():null).get(0).get("totalcount"));
	}

	//根据分页查询新闻(有条件)

	public List<Map<String, String>> queryOrdersByPage(int cpage,int pagesize,String ord_id,String ord_type) {
		String sql = "select * from order_info where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		//判断是否有标题这个条件
		if(ord_id!=null&&!"".equals(ord_id)){
			sql+=" and ord_id like ?";
			list.add("%"+ord_id+"%");
			
		}
		//判断是否有用户名这个条件 
		if(ord_type!=null&&!"".equals(ord_type)){
			sql+=" and ord_type like ?";
			list.add("%"+ord_type+"%");
			
		}
		sql+=" limit ?,?";
		list.add((cpage-1)*pagesize);
		list.add(pagesize);
		return DBUtil.executeQuery(sql, list.toArray());
	}

	
	public Map<String, String> queryOrderDetail(String ord_id) {
		String sql = "select o.*,u.username from order_info o,user u where o.u_id=u.u_id and o.ord_id=?";
		return DBUtil.executeQuery(sql,new Object[]{ord_id}).get(0);
		
		
	}

	public boolean deleteOrder(String ord_id) {
		return DBUtil.executeUpdate("delete from order_info where ord_id=?", new Object[]{ord_id});
	}
/*修改订单
	public boolean updateOrder(Order n) {
		return DBUtil.executeUpdate("update order_info set where ord_id=?", new Object[]{n.get,n.getContent(),n.getNid()});
	}
	*/
}