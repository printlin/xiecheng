package root.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiecheng.util.Constant;
import com.xiecheng.dao.UserDao;
import com.xiecheng.po.User;



/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/root/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String type=request.getParameter("type");
		
		User user=new User();
		user.setUsername(username);
		user.setU_pwd(u_pwd);
		user.setType(Constant.TYPE1);
		
		UserDao us=new UserDao();
		boolean result=us.addUser(user);
		if(result){
			response.sendRedirect("login.jsp");
		}
		
	}
	}

