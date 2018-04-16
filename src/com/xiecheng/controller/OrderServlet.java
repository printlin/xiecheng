package com.xiecheng.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiecheng.dao.OrderDao;
import com.xiecheng.dao.Shopping_cartDao;
import com.xiecheng.po.Order;
import com.xiecheng.po.Shopping_cart;
import com.xiecheng.po.User;

public class OrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public OrderServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String color=request.getParameter("color");
		String size=request.getParameter("size");
		String type=request.getParameter("type");
		String count=request.getParameter("count");
		String name=request.getParameter("name");
		String pic=request.getParameter("pic");
		String good_id=request.getParameter("good_id");
		String price=request.getParameter("price");
		PrintWriter out=response.getWriter();
		if(price==null||"".equals(price)||color==null || "".equals(color) || size==null || "".equals(size) || type==null || "".equals(type) || count==null || "".equals(count)){
			out.print("有未填写字段");
			return;
		}
		Object ob=request.getSession(false).getAttribute("user");
		if(ob==null){
			response.sendRedirect("../login.jsp");
			return;
		}
		User user=(User)ob;
		if(type.equals("buy")){
			Order order=new Order();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=sf.format(new Date());
			order.setOrd_type("未付款");
			order.setOrd_date(time);
			order.setU_id(user.getU_id());
			order.setOrd_u_add(user.getU_address());
			order.setOrd_price(price);
			order.setOrd_u_name(user.getU_name());
			order.setOrd_u_phone(user.getU_num());
			order.setOrd_count("1");
			OrderDao od=new OrderDao();
			if(od.addOrder(order)){
				request.setAttribute("order", od.queryOrderDetailByTime(time));
				request.getRequestDispatcher("../pay.jsp").forward(request, response);
			}else{
				response.getWriter().print("保存到数据库失败");
			}
		}else{
			Shopping_cart cart=new Shopping_cart();
			Shopping_cartDao sd=new Shopping_cartDao();
			cart.setGood_color(color);
			cart.setGood_count(count);
			cart.setGood_pic(pic);
			cart.setGood_id(good_id);
			cart.setGood_name(name);
			cart.setGood_size(size);
			cart.setGood_price(price);
			cart.setU_id(user.getU_id());
			if(sd.addGoods(cart)){
				response.sendRedirect("ShoppingCartServlet");
			}else{
				out.print("保存到数据库失败");
			}
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {

	}

}
