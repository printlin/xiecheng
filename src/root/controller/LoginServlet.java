package root.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiecheng.po.User;
import com.xiecheng.dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/root/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String username=request.getParameter("username");
		String u_pwd=request.getParameter("u_pwd");
		UserDao userDao = new UserDao();
		User user = userDao.getUserByNameAndPwd(username,u_pwd);
		if(user!=null){
			request.getSession().invalidate();
			request.getSession().setAttribute("user", user);
			response.sendRedirect("index.jsp");
		}else{
			request.getSession().setAttribute("error","用户名或密码错误");
			response.sendRedirect("login.jsp");
		}
	}

	}

