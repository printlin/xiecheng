package com.xiecheng.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.xiecheng.po.Shopping_cart;
import com.xiecheng.util.DBUtil;

public class Shopping_cartDao {
	public boolean addGoods(Shopping_cart sc) {
		return DBUtil.executeUpdate("insert into shopping_cart(good_id,good_name,good_count,good_price,u_id,good_pic,good_color,good_size) values(?,?,?,?,?,?,?,?)", 
				new Object[]{sc.getGood_id(),sc.getGood_name(),sc.getGood_count(),sc.getGood_price(),sc.getU_id(),sc.getGood_pic(),sc.getGood_color(),sc.getGood_size()});
	}


	public List<Map<String, String>> queryAllGoods(String u_id) {
		System.out.println("u_id"+u_id);
		return DBUtil.executeQuery("select * from shopping_cart where u_id=?", new Object[]{u_id});
	}

	
	public int queryGoodsCount(String good_name,String good_id) {
		
		String sql = "select count(*) as totalcount from shopping_cart ";
		List<Object> list = new ArrayList<Object>();
	
		if(good_id!=null&&!"".equals(good_id)){
			sql+=" and n.good_id like ?";
			list.add("%"+good_id+"%");
			
		}
	
		if(good_name!=null&&!"".equals(good_name)){
			//like模糊查询
			sql+=" and u.good_name like ?";
			list.add("%"+good_name+"%");
			
		}
		
		return Integer.valueOf(DBUtil.executeQuery(sql, list.size()>0?list.toArray():null).get(0).get("totalcount"));
	}

	//根据分页查询新闻(有条件)

	public List<Map<String, String>> queryGoodsByPage(int cpage,int pagesize,String good_id,String good_name) {
		String sql = "select s.*,u.username from shopping_cart s,user u where s.uid=u.uid";
		List<Object> list = new ArrayList<Object>();
		//判断是否有标题这个条件
		if(good_id!=null&&!"".equals(good_id)){
			sql+=" and n.good_id like ?";
			list.add("%"+good_id+"%");
			
		}
		//判断是否有用户名这个条件 
		if(good_name!=null&&!"".equals(good_name)){
			sql+=" and u.good_name like ?";
			list.add("%"+good_name+"%");
			
		}
		sql+=" limit ?,?";
		list.add((cpage-1)*pagesize);
		list.add(pagesize);
		return DBUtil.executeQuery(sql, list.toArray());
	}

	
	public Map<String, String> queryGoodsDetail(String good_id) {
		String sql = "select * good_info where good_id=?";
		return DBUtil.executeQuery(sql,new Object[]{good_id}).get(0);
		
		
	}

	public boolean deleteGoods(String shop_id) {
		return DBUtil.executeUpdate("delete from shopping_cart where shop_id=?", new Object[]{shop_id});
	}

	
}
