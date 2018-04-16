package com.xiecheng.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.xiecheng.po.User;
import com.xiecheng.util.DBUtil;

public class UserDao {
	public boolean haveUsername(String username){
		return DBUtil.executeQuery("select * from user_info where username=?", new Object[]{username}).size()>0;
		
	}
	
	public boolean addUser(User user) {
		return DBUtil.executeUpdate("insert into user_info(username,u_pwd,u_address,u_birth,u_gender,u_num,u_money,u_name,`type`,u_pic) values(?,?,?,?,?,?,?,?,?,?)",
				new Object[]{user.getUsername(),user.getU_pwd(),user.getU_address(),user.getU_birth(),user.getU_gender(),user.getU_num(),user.getU_money(),user.getU_name(),user.getType(),user.getU_pic()});
		
		
	}
	public boolean updateUser(User user) {
		return DBUtil.executeUpdate("update user_info set username=?,u_pwd=?,u_address=?,u_birth=?,u_gender=?,u_num=?,u_money=?,u_name=?,`type`=?,u_pic=? where u_id=?",
				new Object[]{user.getUsername(),user.getU_pwd(),user.getU_address(),user.getU_birth(),user.getU_gender(),user.getU_num(),user.getU_money(),user.getU_name(),user.getType(),user.getU_pic(),user.getU_id()});
		
		
	}

	public User getUserByNameAndPwd(String username, String u_pwd) {
		List<Map<String,String>> resultlist = DBUtil.executeQuery("select * from user_info where username=? and u_pwd=?", new Object[]{username,u_pwd});
		if(resultlist.size()>0){
			Map<String,String> m = resultlist.get(0);
			User user = new User();
			user.setType(m.get("type"));
			user.setU_address(m.get("u_address"));
			user.setU_birth(m.get("u_birth"));
			user.setU_gender(m.get("u_gender"));
			user.setU_id(m.get("u_id"));
			user.setU_money(m.get("u_money"));
			user.setU_name(m.get("u_name"));
			user.setU_num(m.get("u_num"));
			user.setU_pic(m.get("u_pic"));
			user.setU_pwd(m.get("u_pwd"));
			user.setUsername(m.get("username"));
			return user;
		}else{
			return null;
		}
	}



	public int queryUserCount(String uname) {
		// TODO Auto-generated method stub
		String sql = "select count(*) as totalcount from user_info where 1=1";
		List<Object> list = new ArrayList<Object>();
		//判断是否有用户名这个条件
		if(uname!=null&&!"".equals(uname)){
			sql+=" and username like ?";
			list.add("%"+uname+"%");
			
		}
		
		
		return Integer.valueOf(DBUtil.executeQuery(sql, list.size()>0?list.toArray():null).get(0).get("totalcount"));
	}


	public List<Map<String, String>> queryUserByPage(int cpage,int pageSize, String uname) {
		String sql = "select * from userinfo where 1=1";
		List<Object> list = new ArrayList<Object>();
		//判断是否有用户名这个条件
		if(uname!=null&&!"".equals(uname)){
			sql+=" and username like ?";
			list.add("%"+uname+"%");
			
		}
		
		sql+=" limit ?,?";
		list.add((cpage-1)*pageSize);
		list.add(pageSize);
		return DBUtil.executeQuery(sql, list.toArray());
	}

	public boolean changePassword(String npassword,String uid) {
		// TODO Auto-generated method stub
		return DBUtil.executeUpdate("update user_info set u_pwd=? where u_id=?", new Object[]{npassword,uid});
	}
	public boolean deleteUser(String uid) {
		// TODO Auto-generated method stub
		return  DBUtil.executeUpdate("delete from user_info where u_id=?", new Object[]{uid});
	}
	public Map<String, String> userDetail(String uid) {
		// TODO Auto-generated method stub
		String sql = "select * from user_info where uid=?";
		return DBUtil.executeQuery(sql,new Object[]{uid}).get(0);
	}
}
