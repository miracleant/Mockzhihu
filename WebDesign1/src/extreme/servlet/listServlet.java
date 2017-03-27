package extreme.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import extreme.JavaBean.JavaBean;
import extreme.service.UserService;

public class listServlet extends HttpServlet {
	
	private UserService service = new UserService();


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);


	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.判断用户是否登陆
		JavaBean demouser = (JavaBean) request.getSession().getAttribute("user");
		if(demouser==null){
			response.sendRedirect("/login.jsp");
			return;
		}
		//2.调用service ，获取列表
		List<JavaBean> list = null;
		try {
			list = service.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//3.list保存到request，转发到list.jsp
		request.setAttribute("list", list);
		request.getRequestDispatcher("/list.jsp").forward(request, response);
		


	}

}
