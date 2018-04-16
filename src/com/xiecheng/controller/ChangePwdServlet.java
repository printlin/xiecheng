package com.xiecheng.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiecheng.dao.UserDao;
import com.xiecheng.po.User;

public class ChangePwdServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ChangePwdServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("oldPassword");
		String np=request.getParameter("newPassword");
		Object ob=request.getSession(false).getAttribute("user");
		PrintWriter out=response.getWriter();
		if(ob==null){
			response.sendRedirect("../login.jsp");
			return;
		}
		User user=(User)ob;
		UserDao ud=new UserDao();
		if(op!=null && !"".equals(op) && np!=null && !"".equals(np)){
			if(op.equals(user.getU_pwd())){
				user.setU_pwd(np);
				if(ud.updateUser(user)){
					out.print("修改成功");
				}else{
					out.print("保存到数据库失败");
				}
			}else{
				out.print("原密码错误");
			}
		}else{
			out.print("有空字段");
		}
		out.print("<a href='../servlet/UserUIServlet'>返回用户页面</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {

	}

}
