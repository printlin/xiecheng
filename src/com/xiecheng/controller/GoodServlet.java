package com.xiecheng.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiecheng.dao.Good_infoDao;

public class GoodServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public GoodServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String good_id=request.getParameter("good_id");
		System.out.println(good_id);
		Good_infoDao gi=new Good_infoDao();
		if(good_id!=null || !"".equals(good_id)){
			Map<String, String> map=gi.queryGoodsDetail(good_id);
			request.setAttribute("good", map);
			request.getRequestDispatcher("../good.jsp").forward(request, response);
			return;
		}else{
			response.sendRedirect("../index.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {

	}

}
