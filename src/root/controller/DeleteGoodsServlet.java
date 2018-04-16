package root.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.xiecheng.dao.Good_infoDao;

/**
 * Servlet implementation class DeleteGoodsServlet
 */
@WebServlet("/root/DeleteGoodsServlet")
public class DeleteGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteGoodsServlet() {
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
		
		boolean result = gi.deleteGoods(good_id);
		if(result){
			response.getWriter().println("删除成功<a href='QueryGoodsServlet'>返回</a>");
			
		}else{
			response.getWriter().println("删除失败<a href='QueryGoodsServlet'>返回</a");
			
		}
		
		

}

}
