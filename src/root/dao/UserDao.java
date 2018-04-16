package root.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import root.po.User;
import root.util.DBUtil;

public class UserDao {
	public boolean addUser(User user) {
		return DBUtil.executeUpdate("insert into user_info(username,u_pwd,u_address,u_birth,u_gender,u_num,u_money,u_name,type,u_pic) values(?,?,?,?,?,?,?,?,?,?)",
				new Object[]{user.getUsername(),user.getU_pwd(),user.getU_address(),user.getU_birth(),user.getU_gender(),user.getU_num(),user.getU_money(),user.getU_name(),user.getType(),user.getU_pic()});
		
		
	}

	public User getUserByNameAndPwd(String username, String u_pwd) {
		List<Map<String,String>> resultlist = DBUtil.executeQuery("select * from user_info where username=? and u_pwd=?", new Object[]{username,u_pwd});
		if(resultlist.size()>0){
			Map<String,String> m = resultlist.get(0);
			User user = new User(m.get("username"), m.get("u_id"), 
					m.get("u_pwd"), m.get("u_address"), m.get("u_birth"), m.get("u_gender"), m.get("u_num"), m.get("u_money"),m.get("u_name"),m.get("type"),m.get("u_pic"));
			return user;
		}else{
			return null;
		}
	}



	public int queryUserCount(String username,String u_gender) {
		// TODO Auto-generated method stub
		String sql = "select count(*) as totalcount from user_info where 1=1";
		List<Object> list = new ArrayList<Object>();
		//判断是否有用户名这个条件
		if(username!=null&&!"".equals(username)){
			sql+=" and username like ?";
			list.add("%"+username+"%");
			
		}
		if(u_gender!=null&&!"".equals(u_gender)){
			sql+=" and u_gender like ?";
			list.add("%"+u_gender+"%");
			
		}
		
		
		return Integer.valueOf(DBUtil.executeQuery(sql, list.size()>0?list.toArray():null).get(0).get("totalcount"));
	}


	public List<Map<String, String>> queryUserByPage(int cpage,int pageSize, String username,String u_gender) {
		String sql = "select * from user_info where 1=1";
		List<Object> list = new ArrayList<Object>();
		//判断是否有用户名这个条件
		if(username!=null&&!"".equals(username)){
			sql+=" and username like ?";
			list.add("%"+username+"%");
			
		}
		if(u_gender!=null&&!"".equals(u_gender)){
			sql+=" and u_gender like ?";
			list.add("%"+u_gender+"%");
			
		}
		
		sql+=" limit ?,?";
		list.add((cpage-1)*pageSize);
		list.add(pageSize);
		return DBUtil.executeQuery(sql, list.toArray());
	}

	public boolean changePassword(String new_u_pwd,String u_id) {
		// TODO Auto-generated method stub
		return DBUtil.executeUpdate("update user_info set u_pwd=? where u_id=?", new Object[]{new_u_pwd,u_id});
	}
	public boolean deleteUser(String u_id) {
		// TODO Auto-generated method stub
		return  DBUtil.executeUpdate("delete from user_info where u_id=?", new Object[]{u_id});
	}
	public Map<String, String> userDetail(String u_id) {
		// TODO Auto-generated method stub
		String sql = "select * from user_info where u_id=?";
		return DBUtil.executeQuery(sql,new Object[]{u_id}).get(0);
	}
}
