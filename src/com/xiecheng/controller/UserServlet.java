package com.xiecheng.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiecheng.dao.UserDao;
import com.xiecheng.po.User;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UserServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String u_name=request.getParameter("u_name");
		String u_num=request.getParameter("u_num");
		String u_address=request.getParameter("u_address");
		Object ob=request.getSession(false).getAttribute("user");
		PrintWriter out=response.getWriter();
		if(ob==null){
			response.sendRedirect("../login.jsp");
			return;
		}
		User user=(User)ob;
		UserDao ud=new UserDao();
		if(username!=null && !"".equals(username)&&!ud.haveUsername(username)){
			user.setUsername(username);
		}
		if(u_name!=null && !"".equals(u_name)){
			user.setU_name(u_name);
		}
		if(u_num!=null && !"".equals(u_num)){
			user.setU_num(u_num);
		}
		if(u_address!=null && !"".equals(u_address)){
			user.setU_address(u_address);
		}
		if(ud.updateUser(user)){
			out.print("修改成功");
		}else{
			out.print("加入数据库失败");
		}
		out.print("<a href='../servlet/UserUIServlet'>返回用户页面</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {

	}

}
