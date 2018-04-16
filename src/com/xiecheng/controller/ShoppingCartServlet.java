package com.xiecheng.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiecheng.dao.Shopping_cartDao;
import com.xiecheng.po.User;

public class ShoppingCartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ShoppingCartServlet() {
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
		Shopping_cartDao sd=new Shopping_cartDao();
		List<Map<String, String>> list=sd.queryAllGoods(user.getU_id());
		request.setAttribute("list", list);
		request.getRequestDispatcher("../shoppingCart.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {

	}

}
