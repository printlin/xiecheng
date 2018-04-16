package com.xiecheng.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiecheng.dao.OrderDao;
import com.xiecheng.dao.Shopping_cartDao;
import com.xiecheng.po.Order;
import com.xiecheng.po.User;

public class ShoppingCartDoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ShoppingCartDoServlet() {
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
		Order order=new Order();
		Shopping_cartDao sc=new Shopping_cartDao();
		//String count=request.getParameter("count");
		String priceA=request.getParameter("priceA");
		StringBuffer sb=new StringBuffer();
		List<String> list=new ArrayList<String>();
		List<String> idA=new ArrayList<String>();
		Enumeration<String> enu=request.getParameterNames();
		while(enu.hasMoreElements()){
			list.add(request.getParameter(enu.nextElement()));
		}
		for(int i=0,j=list.size();i<j;i++){
			if(list.get(i).indexOf("true-")>-1){
				String id=list.get(i).substring(list.get(i).indexOf("true-")+5);
				idA.add(id);
			}
		}
		for(int i=0,j=idA.size();i<j;i++){
			sb.append(idA.get(i)+"-");
			sc.deleteGoods(idA.get(i));
		}
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=sf.format(new Date());
		order.setOrd_type("未付款");
		order.setOrd_date(time);
		order.setU_id(user.getU_id());
		order.setOrd_u_add(user.getU_address());
		order.setOrd_price(priceA);
		order.setOrd_u_name(user.getU_name());
		order.setOrd_u_phone(user.getU_num());
		order.setOrd_count(sb.toString());
		OrderDao od=new OrderDao();
		if(od.addOrder(order)){
			request.setAttribute("order", od.queryOrderDetailByTime(time));
			request.getRequestDispatcher("../pay.jsp").forward(request, response);
		}else{
			response.getWriter().print("保存到数据库失败");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {

	}

}
