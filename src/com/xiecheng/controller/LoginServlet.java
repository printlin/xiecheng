package com.xiecheng.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiecheng.po.User;
import com.xiecheng.util.WebUtil;
import com.xiecheng.dao.UserDao;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String type=request.getParameter("type");
		HashMap<String,String> mes=new HashMap<String, String>();
		PrintWriter out = response.getWriter();
		UserDao ud=new UserDao();
		
		Object s_chackCodeOb=request.getSession().getAttribute("chackCode");
		if(s_chackCodeOb!=null){
			String s_chackCode=(String) s_chackCodeOb;
			String c_chackCode=request.getParameter("chackCode");
			System.out.println("s_chackCode:"+s_chackCode+"     c_chackCode:"+c_chackCode);
			if(username==null || "".equals(username)){
				mes.put("username", "用户名不能为空");
			}else if(!ud.haveUsername(username)){
				mes.put("username", "用户名不存在");
			}else if(password==null || "".equals(password)){
				mes.put("password", "密码不能为空");
			}else if(c_chackCode==null){
				mes.put("chackCode", "*验证码不能为空");
			}else if(!c_chackCode.equals(s_chackCode)){
				mes.put("chackCode", "*验证码错误");
			}else{
				if(type!=null && !"".equals(type)){
					User user=ud.getUserByNameAndPwd(username, password);
					if(user!=null){
						request.getSession().setAttribute("user", user);
						if(user.getType()!=null && user.getType().equals("管理员")){
							mes.put("sucess","管理员");
						}else{
							mes.put("sucess","普通用户");
						}
						
					}else{
						mes.put("addErrorMes", "登录失败");
					}
				}
			}
		}
		out.print(WebUtil.mapToJson(mes));
	}

}

