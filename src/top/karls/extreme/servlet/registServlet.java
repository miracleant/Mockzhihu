package top.karls.extreme.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import top.karls.extreme.JavaBean.JavaBean;
import top.karls.extreme.service.UserService;
import top.karls.extreme.utils.JudgeEmpty;

public class registServlet extends HttpServlet {
	
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
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		
		//2.校验用户名，密码是否为空
		Map< String, String> map = JudgeEmpty.check(user);
		if(map.size()>0){
			request.setAttribute("errors", map);
			request.getRequestDispatcher("/regist.jsp").forward(request,response);
			return;
		}
		//3.判断验证码正误
        String userAnswer = request.getParameter("checkcode");
        String rightAnswer = (String) request.getSession().getAttribute("checkcode");
		if(rightAnswer==null || !rightAnswer.equalsIgnoreCase(userAnswer)){
			request.setAttribute("check", "验证码输入有误");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		
		//4.调用service保存
		try {
			service.regist(user);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("exception",e.getMessage());
			request.getRequestDispatcher("/regist.jsp").forward(request,response);
			return;
		}
		//5.注册成功，重定向到登陆界面
		response.sendRedirect("/login.jsp");


	}

}
