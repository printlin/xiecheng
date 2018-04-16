package com.xiecheng.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.xiecheng.po.Good_info;
import com.xiecheng.util.DBUtil;

public class Good_infoDao {
	public boolean addGoods(Good_info goods) {
		return DBUtil.executeUpdate("insert into good_info(good_id,good_name,good_price,"
				+ "good_desc,good_pic,good_count,good_size,good_color,good_type) values(?,?,?,?,?,?,?,?,?)", 
				new Object[]{goods.getGood_id(),goods.getGood_name(),goods.getGood_price(),goods.getGood_desc(),
						goods.getGood_pic(),goods.getGood_count(),goods.getGood_size(),goods.getGood_color(),goods.getGood_type()});
	}


	public List<Map<String, String>> queryAllGoods() {
		return DBUtil.executeQuery("select * from good_info", null);
	}

	
	public int queryGoodsCount(String good_name,String color,String size,String good_type) {
		
		StringBuffer sql =new StringBuffer();
		sql.append("select count(*) as totalcount from good_info");
		List<Object> list = new ArrayList<Object>();
		if(good_name!=null&&!"".equals(good_name)){
			//like模糊查询
			list.add("good_name like '%"+good_name+"%'");
		}
		if(size!=null&&!"".equals(size)){
			//like模糊查询 
			list.add("good_size like '%"+size+"%'");
		}
		if(color!=null&&!"".equals(color)){
			//like模糊查询
			list.add("good_color like '%"+color+"%'");
		}
		if(good_type!=null&&!"".equals(good_type)){
			//like模糊查询
			list.add("good_type like '%"+good_type+"%'");
		}
		
		
		if(list.size()>0){
			sql.append(" where ");
			int i=0;
			for(int j=list.size();i<j-1;i++){
				sql.append(list.get(i)+" and ");
			}
			sql.append(list.get(i));
		}
		return Integer.valueOf(DBUtil.executeQuery(sql.toString(),null).get(0).get("totalcount"));
	}

	//根据分页查询新闻(有条件)

	public List<Map<String, String>> queryGoodsByPage(String good_name,String color,String size,String good_type,int page,int count) {
		StringBuffer sql =new StringBuffer();
		sql.append("select * from good_info");
		List<Object> list = new ArrayList<Object>();
		String pageT="";
		if(good_name!=null&&!"".equals(good_name)){
			//like模糊查询
			list.add("good_name like '%"+good_name+"%'");
		}
		if(size!=null&&!"".equals(size)){
			//like模糊查询 
			list.add("good_size like '%"+size+"%'");
		}
		if(color!=null&&!"".equals(color)){
			//like模糊查询
			list.add("good_color like '%"+color+"%'");
		}
		if(good_type!=null&&!"".equals(good_type)){
			//like模糊查询
			list.add("good_type like '%"+good_type+"%'");
		}
		
		if(page>0 && count>0){
			pageT=" limit "+(page-1)*count+","+count;
		}
		if(list.size()>0){
			sql.append(" where ");
			int i=0;
			for(int j=list.size();i<j-1;i++){
				sql.append(list.get(i)+" and ");
			}
			sql.append(list.get(i));
		}
		sql.append(pageT);
		return DBUtil.executeQuery(sql.toString(),null);
	}

	
	public Map<String, String> queryGoodsDetail(String good_id) {
		String sql = "select * from Good_info where good_id=?";
		return DBUtil.executeQuery(sql,new Object[]{good_id}).get(0);
		
		
	}

	public boolean deleteGoods(String good_id) {
		return DBUtil.executeUpdate("delete from good_info where good_id=?", new Object[]{good_id});
	}
}
/*删除商品
	public boolean updateGoods(Good_info g) {
		return DBUtil.executeUpdate("update good_info set title=?,content=? where nid=?", new Object[]{n.getTitle(),n.getContent(),n.getNid()});
	}
}
*/
