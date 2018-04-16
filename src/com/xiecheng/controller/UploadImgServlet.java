package com.xiecheng.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.xiecheng.dao.UserDao;
import com.xiecheng.po.User;
import com.xiecheng.util.UploadListener;





public class UploadImgServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UploadImgServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filePath="";
		PrintWriter out=response.getWriter();
		Object ob=request.getSession(false).getAttribute("user");
		if(ob==null){
			response.sendRedirect("../login.jsp");
			return;
		}
		User user=(User)ob;
		UserDao ud=new UserDao();
		// 为解析类提供配置信息
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 创建解析类的实例
		ServletFileUpload sfu = new ServletFileUpload(factory);
		UploadListener listener=new UploadListener(request);
		// 开始解析
		sfu.setProgressListener(listener);
		sfu.setFileSizeMax(1024 * 1024*20);//最大20m
		// 每个表单域中数据会封装到一个对应的FileItem对象上
		try {
			@SuppressWarnings("unchecked")
			List<FileItem> items = sfu.parseRequest(request);
			// 区分表单域
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
				// isFormField为true，表示这不是文件上传表单域
				if (!item.isFormField()) {
					ServletContext sctx = getServletContext();
					// 获得存放文件的物理路径
					String srPath=sctx.getRealPath(sctx.getContextPath());//C:\apache-tomcat-8.5.11\webapps\xiecheng\xiecheng
					srPath=srPath.substring(0, srPath.lastIndexOf("\\"));//C:\apache-tomcat-8.5.11\webapps\xiecheng
					// 获得文件名
					String fileName = item.getName();
					String postfix=fileName.substring(fileName.lastIndexOf(".")+1);//后缀
					if("JPG JPEG GIF PNG BMP jpg jpeg gif png bmp".indexOf(postfix)!=-1){
						Date date=new Date();
						String time=date.getTime()+"";
						String dbPath="images\\user\\"+time+"."+postfix;//  images\ user\1496973777803.jpg
						filePath=srPath+"\\"+dbPath;
						/*System.out.println("srPath:"+srPath);
						System.out.println("dbPath:"+dbPath);
						System.out.println("filePath:"+filePath);*/
						File file = new File(filePath);
						if (!file.exists()) {
							item.write(file);
							deleteFile(user.getU_pic());//删除原图片
							user.setU_pic(dbPath);
							if(ud.updateUser(user)){
								out.print("上传成功");
								
							}else{
								out.print("保存到数据库失败");
							}
						}
					}else{
						out.print("不支持该格式");
						return;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.print("<a href='../servlet/UserUIServlet'>返回用户页面</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {
		
	}
	private boolean deleteFile(String filePath){
		if(filePath==null || "".equals(filePath)){
			return false;
		}
		File file=new File(filePath);
		if (file.exists() && file.isFile()) {//是文件且存在
            if (file.delete()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
	}
}
