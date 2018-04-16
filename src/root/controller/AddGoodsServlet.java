package root.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import root.dao.Good_infoDao;
import root.po.Good_info;
import root.po.User;


/**
 * Servlet implementation class AddGoodsServlet
 */
@WebServlet("/root/AddGoodsServlet")
public class AddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String good_name = request.getParameter("good_name");
		String good_type = request.getParameter("good_type");
		String good_count=request.getParameter("good_count");
		String good_price=request.getParameter("good_price");
		String good_desc=request.getParameter("good_desc");
		String good_color=request.getParameter("good_color");
		String good_size=request.getParameter("good_size");
		String good_pic=request.getParameter("good_pic");
		
		
		Good_info current_good = (Good_info) request.getSession().getAttribute("good");
		
		Good_info g = new Good_info();
		g.setGood_name(good_name);
		g.setGood_type(good_type);
		g.setGood_count(good_count);
		g.setGood_price(good_price);
		g.setGood_desc(good_desc);
		g.setGood_color(good_color);
		g.setGood_size(good_size);
		g.setGood_pic(good_pic);
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		g.setPubtime(sdf.format(new Date()));
//		g.setUid(current_good.getUid());
		
		Good_infoDao gi = new Good_infoDao();
		if(gi.addGoods(g)){
			response.getWriter().println("发布成功");
		}else{
			response.getWriter().println("发布失败");
			
		}
	}

}
