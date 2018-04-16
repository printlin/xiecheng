package com.xiecheng.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiecheng.util.Constant;
import com.xiecheng.util.WebUtil;
import com.xiecheng.dao.UserDao;
import com.xiecheng.po.User;





public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		HashMap<String,String> mes=new HashMap<String, String>();
		PrintWriter out = response.getWriter();
		UserDao ud=new UserDao();
		
		Object s_chackCodeOb=request.getSession().getAttribute("chackCode");
		if(s_chackCodeOb!=null){
			String s_chackCode=(String) s_chackCodeOb;
			String c_chackCode=request.getParameter("chackCode");
			if(c_chackCode==null){
				mes.put("chackCode", "*验证码不能为空");
			}else if(!c_chackCode.equals(s_chackCode)){
				mes.put("chackCode", "*验证码错误");
			}else{
				if(username==null || "".equals(username)){
					mes.put("username", "用户名不能为空");
				}else if(password==null || "".equals(password)){
					mes.put("password", "密码不能为空");
				}else if(password.length()<6){
					mes.put("password", "密码长度不能小于6");
				}else if(password.length()>16){
					mes.put("password", "密码长度不能大于16");return;
				}else if(ud.haveUsername(username)){
					mes.put("username", "用户名已存在");
				}else{
					User user=new User();
					user.setUsername(username);
					user.setU_pwd(password);
					user.setType(Constant.TYPE1);
					boolean result=ud.addUser(user);
					if(result){
						mes.put("sucess","成功");
					}else{
						mes.put("addErrorMes", "保存到数据库失败");
					}
				}
			}
		}
		
		out.print(WebUtil.mapToJson(mes));
	}
	
}

