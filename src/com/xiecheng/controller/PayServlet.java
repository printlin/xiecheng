package com.xiecheng.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiecheng.dao.OrderDao;
import com.xiecheng.dao.UserDao;
import com.xiecheng.po.Order;
import com.xiecheng.po.User;

public class PayServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public PayServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String ord_id=request.getParameter("ord_id");
		String ord_u_name=request.getParameter("ord_u_name");
		String ord_u_add=request.getParameter("ord_u_add");
		String ord_u_phone=request.getParameter("ord_u_phone");
		String payPass=request.getParameter("payPass");
		Object ob=request.getSession(false).getAttribute("user");
		if(ob==null){
			response.sendRedirect("../login.jsp");
			return;
		}
		User user=(User)ob;
		OrderDao od=new OrderDao();
		Map<String, String> map=od.queryOrderDetail(ord_id);
		Order order=new Order();
		order.setOrd_count(map.get("ord_count"));
		order.setOrd_date(map.get("ord_date"));
		order.setOrd_id(ord_id);
		order.setOrd_price(map.get("ord_price"));
		order.setOrd_type(map.get("ord_type"));
		order.setOrd_u_add(ord_u_add);
		order.setOrd_u_name(ord_u_name);
		order.setOrd_u_phone(ord_u_phone);
		order.setU_id(map.get("u_id"));
		if(user.getU_pwd().equals(payPass)){
			float uM=Float.valueOf(user.getU_money());
			float gM=Float.valueOf(order.getOrd_price());
			if(uM>=gM){
				UserDao ud=new UserDao();
				user.setU_money(String.valueOf(uM-gM));
				ud.updateUser(user);
				order.setOrd_type("已付款");
				if(od.updateOrder(order)){
					out.print("付款成功");
				}else{
					out.print("保存到数据库失败");
				}
			}else{
				out.print("余额不足");
			}
			
		}else{
			out.print("密码错误");
		}
		out.print("<a href='../jumpIndex.jsp'>回到首页</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {

	}

}
