package root.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import root.dao.OrderDao;
import root.util.Constant;

/**
 * Servlet implementation class QueryOrderServlet
 */
@WebServlet("/root/QueryOrderServlet")
public class QueryOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryOrderServlet() {
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
		String ord_id = request.getParameter("ord_id");//得到条件--订单ID
		String ord_type = request.getParameter("ord_type");//得到条件--订单类型
		System.out.println(ord_id);
		if(ord_id!=null){
			ord_id = URLDecoder.decode(ord_id,"utf-8");//解码
		}
		if(ord_type!=null){
			ord_type = URLDecoder.decode(ord_type,"utf-8");//解码
		}
		
		
		//分页部分
		String page = request.getParameter("page");
		int cpage = 1;
		if(page!=null&&!("").equals(page)){
			cpage = Integer.valueOf(page);
		}
		
		
		
		OrderDao od = new OrderDao();
		//不分页
//		List<Map<String,String>> newsList = ns.queryAllNews();
		//分页
		List<Map<String,String>> ordersList = od.queryOrdersByPage(cpage, Constant.PAGESIZE,ord_id,ord_type);
		int totalcount = od.queryOrdersCount(ord_id,ord_type);
		
		
		if(ord_id!=null){
			//两次编码，并将其放入request域
			request.setAttribute("ord_id", URLEncoder.encode(URLEncoder.encode(ord_id, "utf-8")));
		}else{
			request.setAttribute("ord_id", ord_id);
		}
		if(ord_type!=null){
			//两次编码，并将其放入request域
			request.setAttribute("ord_type", URLEncoder.encode(URLEncoder.encode(ord_type, "utf-8")));
		}else{
			request.setAttribute("ord_type", ord_type);
		}
		request.setAttribute("page", cpage);
		request.setAttribute("pageCount", (totalcount%Constant.PAGESIZE==0)?totalcount/Constant.PAGESIZE:totalcount/Constant.PAGESIZE+1);
		request.setAttribute("ordersList", ordersList);
		request.getRequestDispatcher("queryOrder.jsp").forward(request, response);
	}
	}


