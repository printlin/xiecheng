package com.xiecheng.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiecheng.dao.OrderDao;
import com.xiecheng.po.User;


public class UserUIServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UserUIServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object ob=request.getSession(false).getAttribute("user");
		if(ob==null){
			response.sendRedirect("../login.jsp");
			return;
		}
		User user=(User)ob;
		OrderDao od=new OrderDao();
		List<Map<String, String>> list=od.queryOrdersByU_id(user.getU_id());
		System.out.println(list.size());
		request.setAttribute("list", list);
		request.getRequestDispatcher("../user.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {

	}

}
