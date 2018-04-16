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
import root.dao.UserDao;
import root.util.Constant;

/**
 * Servlet implementation class QueryUserServlet
 */
@WebServlet("/root/QueryUserServlet")
public class QueryUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryUserServlet() {
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
		String username = request.getParameter("username");//得到条件--用户名称
		String u_gender = request.getParameter("u_gender");//得到条件--用户性别

		
		//分页部分
		String page = request.getParameter("page");
		int cpage = 1;
		if(page!=null&&!("").equals(page)){
			cpage = Integer.valueOf(page);
		}
		
		
		
		UserDao gi = new UserDao();
		//不分页
//		List<Map<String,String>> newsList = ns.queryAllNews();
		//分页
		List<Map<String,String>> goodsList = gi.queryUserByPage(cpage, Constant.PAGESIZE,username,u_gender);
		int totalcount = gi.queryUserCount(username,u_gender);
		
		int pageCount=(totalcount%Constant.PAGESIZE==0)?totalcount/Constant.PAGESIZE:totalcount/Constant.PAGESIZE+1;
		if(pageCount<=0){
		cpage=0;
		}
		request.setAttribute("page", cpage);
		request.setAttribute("pageCount",pageCount) ;
		request.setAttribute("goodsList", goodsList);
		request.getRequestDispatcher("queryUser.jsp").forward(request, response);
	}
}

