package com.xiecheng.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiecheng.dao.Good_infoDao;
import com.xiecheng.util.Constant;
import com.xiecheng.util.StaticData;

public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public IndexServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String size=request.getParameter("size");
		String color=request.getParameter("color");
		String good_type=request.getParameter("good_type");
		String good_name=request.getParameter("good_name");
		String page=request.getParameter("page");
		Good_infoDao gi=new Good_infoDao();
		List<Map<String, String>> goods=gi.queryGoodsByPage(good_name, color, size, good_type, Integer.valueOf(page), StaticData.pageLength);
		double count=gi.queryGoodsCount(good_name, color, size, good_type);
		double length=Constant.pageLength;
		int allPage=(int) Math.ceil(count/length);
		request.setAttribute("goods", goods);
		request.setAttribute("allPage", allPage);
		request.setAttribute("good_name", good_name);
		request.setAttribute("color", color);
		request.setAttribute("size", size);
	    request.setAttribute("page", page);
	    request.setAttribute("type", good_type);
	    request.getRequestDispatcher("../index.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {

	}

}
