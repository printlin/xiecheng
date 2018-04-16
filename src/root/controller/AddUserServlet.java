package root.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.xiecheng.dao.UserDao;
import com.xiecheng.po.User;
import com.xiecheng.util.Constant;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/root/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
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
		String username=request.getParameter("username");
		String u_pwd=request.getParameter("u_pwd");
		String u_gender=request.getParameter("u_gender");
		
		//进行后端验证
				List<String> errors = new ArrayList<String>();
				if(username==null||username==""){
					errors.add("用户名不能为空");
				}
				if(u_pwd.length()<6){
					errors.add("密码长度小于6");
					
				}
				
				
				if(errors.size()>0){
					request.setAttribute("errors", errors);
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}else{
					User user = new User();
					user.setUsername(username);
					user.setU_pwd(u_pwd);
					user.setU_gender(u_gender);
					UserDao ud= new UserDao();
					if(ud.addUser(user)){
						response.sendRedirect("QueryUserServlet");
						
					}
		
				}
	}
}
