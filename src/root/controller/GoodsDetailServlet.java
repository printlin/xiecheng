package root.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiecheng.dao.Good_infoDao;

/**
 * Servlet implementation class UserDetailServlet
 */
@WebServlet("/root/GoodsDetailServlet")
public class GoodsDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsDetailServlet() {
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
		String good_id = request.getParameter("good_id");
		
		Good_infoDao gi = new Good_infoDao();
		Map<String,String> m = gi.queryGoodsDetail(good_id);
		
		request.setAttribute("good_name",m.get("good_name"));
		request.setAttribute("good_color",m.get("good_color"));
		request.setAttribute("good_size",m.get("good_size"));
		request.setAttribute("good_desc",m.get("good_desc"));
		request.setAttribute("good_price",m.get("good_price"));
		request.setAttribute("good_type",m.get("good_type"));
		request.setAttribute("good_count",m.get("good_count"));
		request.setAttribute("good_pic",m.get("good_pic"));

		
		request.getRequestDispatcher("goodsDetail.jsp").forward(request, response);
	}

}
