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
 * Servlet implementation class ChangePwdServlet
 */
@WebServlet("/root/ChangePwdServlet")
public class ChangePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePwdServlet() {
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
		String u_pwd=request.getParameter("u_pwd");
		String new_u_pwd=request.getParameter("new_u_pwd");
		User user=(User)(request.getSession().getAttribute("user"));
		String u_id=user.getU_id();
		UserDao us=new UserDao();
		if(user.getU_pwd().equals(u_pwd)){
			boolean result=us.changePassword(new_u_pwd,u_id);
			if(result){
				response.getWriter().println("修改成功");
			}else{
				response.getWriter().println("修改失败");
			}
		}else{
			System.out.println(user.getU_pwd()+"-------"+u_pwd);
			response.getWriter().println("密码验证错误");
		}
	}

}
