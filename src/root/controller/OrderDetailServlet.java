package root.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiecheng.dao.OrderDao;

/**
 * Servlet implementation class OrderDetailServlet
 */
@WebServlet("/root/OrderDetailServlet")
public class OrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetailServlet() {
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
		String ord_id = request.getParameter("ord_id");
		
		OrderDao od = new OrderDao();
		Map<String,String> m = od.queryOrderDetail(ord_id);
		
		request.setAttribute("ord_id",m.get("ord_id"));
		request.setAttribute("ord_u_name",m.get("ord_u_name"));
		request.setAttribute("ord_u_add",m.get("ord_u_add"));
		request.setAttribute("ord_price",m.get("ord_u_add"));
		request.setAttribute("ord_type",m.get("ord_type"));
		request.setAttribute("ord_date",m.get("ord_date"));

		
		request.getRequestDispatcher("orderDetail.jsp").forward(request, response);
	}

}
