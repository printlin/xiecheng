package root.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import root.po.Good_info;
import root.dao.Good_infoDao;

/**
 * Servlet implementation class UpdateGoodsServlet
 */
@WebServlet("/root/UpdateGoodsServlet")
public class UpdateGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGoodsServlet() {
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
		String type=request.getParameter("type");
		String good_id = request.getParameter("good_id");
		Good_infoDao gi = new Good_infoDao();
		if(type!=null && !"".equals(type)){
			Map<String,String> m = gi.queryGoodsDetail(good_id);
			request.setAttribute("g", m);
			request.getRequestDispatcher("updateGoods.jsp").forward(request, response);
			return;
		}
		
		
			
			//1.得到要保存的参数
			
			
			String good_type=request.getParameter("good_type");
			String good_price = request.getParameter("good_price");
			String good_desc = request.getParameter("good_desc");
			String good_color = request.getParameter("good_color");
			String good_size = request.getParameter("good_size");
			String good_name = request.getParameter("good_name");
			String good_count = request.getParameter("good_count");
			String good_pic = request.getParameter("good_pic");
			
	
			//2.构造对象
			Good_info g = new Good_info();
			g.setGood_id(good_id);
			g.setGood_type(good_type);
			g.setGood_desc(good_desc);
			g.setGood_color(good_color);
			g.setGood_size(good_size);
			g.setGood_count(good_count);
			g.setGood_name(good_name);
			g.setGood_name(good_pic);
			g.setGood_name(good_price);
			
			//3.执行service中的更新方法，显示相应的结果
			if(gi.updateGoods(g)){
				response.getWriter().println("商品更新成功");
				
			}else{
				response.getWriter().println("商品更新失败");
				
			}
			
			
	
	}



}
