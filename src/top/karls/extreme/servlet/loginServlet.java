package top.karls.extreme.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.*;


import top.karls.extreme.JavaBean.JavaBean;
import top.karls.extreme.service.UserService;
import top.karls.extreme.utils.JudgeEmpty;

public class loginServlet extends HttpServlet {
	private UserService service = new UserService();


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);


	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置请求端编码格式
		request.setCharacterEncoding("utf-8");
		//1.封装参数
		JavaBean user = new  JavaBean();
		
		//下面两句作用同BeanUtils
        String username = request.getParameter("username");
		user.setUsername(username);
		user.setPassword(request.getParameter("password"));
		
		//2.校验用户名，密码是否为空
		Map< String, String> map = JudgeEmpty.check(user);
		if(map.size()>0){
			request.setAttribute("errors", map);
			request.getRequestDispatcher("/login.jsp").forward(request,response);
			return;
		}
		//3.调用service判断
		JavaBean exist = null;
		try {
			exist = service.login(user);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("exception",e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request,response);
			return;
		}
		//4.将成功标识加入session
		HttpSession session = request.getSession();
		session.setAttribute("user", exist);
		session.setAttribute("username", username);
		System.out.println(username);
		//5.判断是否记住用户名
		Cookie cookie = new Cookie("remember", exist.getUsername());
		String checkString = (String) request.getParameter("box");
		if("yes".equals(checkString)){
			cookie.setMaxAge(60*60*2);
		}else{
			cookie.setMaxAge(0);
		}
		response.addCookie(cookie);
		//登陆成功，重定向到首页
		response.sendRedirect("/index.jsp");



	}

}
