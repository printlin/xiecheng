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

import root.dao.Good_infoDao;
import root.util.Constant;

/**
 * Servlet implementation class QueryGoodsServlet
 */
@WebServlet("/root/QueryGoodsServlet")
public class QueryGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryGoodsServlet() {
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
		//条件查询部分
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");		
		String good_name = request.getParameter("good_name");//得到条件--商品名称
				String good_type = request.getParameter("good_type");//得到条件--商品品牌
				if(good_name!=null){
					good_name = URLDecoder.decode(good_name,"utf-8");//解码
				}
				if(good_type!=null){
					good_type = URLDecoder.decode(good_type,"utf-8");//解码
				}
				
				
				//分页部分
				String page = request.getParameter("page");
				int cpage = 1;
				if(page!=null&&!("").equals(page)){
					cpage = Integer.valueOf(page);
				}
				
				
				
				Good_infoDao gi = new Good_infoDao();
				//不分页
//				List<Map<String,String>> newsList = ns.queryAllNews();
				//分页
				List<Map<String,String>> goodsList = gi.queryGoodsByPage(good_name,"","",good_type,cpage, Constant.PAGESIZE);
				int totalcount = gi.queryGoodsCount(good_name,"","",good_type);
				
				
				if(good_name!=null){
					//两次编码，并将其放入request域
					request.setAttribute("good_name", URLEncoder.encode(URLEncoder.encode(good_name, "utf-8")));
				}else{
					request.setAttribute("good_name", good_name);
				}
				if(good_type!=null){
					//两次编码，并将其放入request域
					request.setAttribute("good_type", URLEncoder.encode(URLEncoder.encode(good_type, "utf-8")));
				}else{
					request.setAttribute("good_type", good_type);
				}
				request.setAttribute("page", cpage);
				request.setAttribute("pageCount", (totalcount%Constant.PAGESIZE==0)?totalcount/Constant.PAGESIZE:totalcount/Constant.PAGESIZE+1);
				request.setAttribute("goodsList", goodsList);
				request.getRequestDispatcher("queryGoods.jsp").forward(request, response);
			}
	}


