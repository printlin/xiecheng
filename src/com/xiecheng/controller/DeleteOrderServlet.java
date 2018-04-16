package com.xiecheng.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiecheng.dao.OrderDao;

public class DeleteOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public DeleteOrderServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object ob=request.getSession(false).getAttribute("user");
		String ord_id=request.getParameter("ord_id");
		PrintWriter out=response.getWriter();
		if(ob==null){
			response.sendRedirect("../login.jsp");
			return;
		}
		OrderDao od=new OrderDao();
		if(ord_id==null && "".equals(ord_id)){
			out.print("未获取到订单id");
			out.print("<a href='../servlet/UserUIServlet'>返回用户页面</a>");
			return;
		}
		if(od.deleteOrder(ord_id)){
			out.print("删除成功");
		}else{
			out.print("删除失败");
		}
		out.print("<a href='../servlet/UserUIServlet'>返回用户页面</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {

	}

}
