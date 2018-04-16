package root.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import root.dao.UserDao;

/**
 * Servlet implementation class UserDetailServlet
 */
@WebServlet("/root/UserDetailServlet")
public class UserDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailServlet() {
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
		String u_id = request.getParameter("u_id");
		
		UserDao us = new UserDao();
		Map<String,String> m = us.userDetail(u_id);
		
		request.setAttribute("username",m.get("username"));
		request.setAttribute("u_gender",m.get("u_gender"));
		request.setAttribute("u_num",m.get("u_num"));
		request.setAttribute("u_name",m.get("u_name"));
		request.setAttribute("type",m.get("type"));
		request.setAttribute("u_birth",m.get("u_birth"));
		request.setAttribute("u_address",m.get("u_address"));
		request.setAttribute("u_money",m.get("u_money"));
		request.setAttribute("u_birth",m.get("u_birth"));
		
		request.getRequestDispatcher("userDetail.jsp").forward(request, response);
	}

}
