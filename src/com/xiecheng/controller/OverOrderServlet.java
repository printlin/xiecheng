package com.xiecheng.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiecheng.dao.OrderDao;
import com.xiecheng.po.Order;

public class OverOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public OverOrderServlet() {
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
		Order order=new Order();
		Map<String, String> map=od.queryOrderDetail(ord_id);
		order.setOrd_count(map.get("ord_count"));
		order.setOrd_date(map.get("ord_date"));
		order.setOrd_id(map.get("ord_id"));
		order.setOrd_price(map.get("ord_price"));
		order.setOrd_type(map.get("ord_type"));
		order.setOrd_u_add(map.get("ord_u_add"));
		order.setOrd_u_name(map.get("ord_u_name"));
		order.setOrd_u_phone(map.get("ord_u_phone"));
		order.setU_id(map.get("u_id"));
		
		order.setOrd_type("已签收");
		if(od.updateOrder(order)){
			out.print("收货成功");
		}else{
			out.print("保存到数据库失败");
		}
		out.print("<a href='../servlet/UserUIServlet'>返回用户页面</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {

	}

}
