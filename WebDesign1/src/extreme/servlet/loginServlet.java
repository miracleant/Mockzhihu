package extreme.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.commons.beanutils.BeanUtils;

import extreme.JavaBean.JavaBean;
import extreme.service.UserService;
import extreme.utils.JudgeEmpty;

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
		//user.setUsername(request.getParameter("username"));
		//user.setPassword(request.getParameter("passowrd"));
		
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
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
		request.getSession().setAttribute("user", exist);
		//5.判断是否记住用户名
		Cookie cookie = new Cookie("remember", exist.getUsername());
		String checkString = (String) request.getParameter("box");
		if("yes".equals(checkString)){
			cookie.setMaxAge(60*60*2);
		}else{
			cookie.setMaxAge(0);
		}
		response.addCookie(cookie);
		//登陆成功，重定向到列表servlet
		response.sendRedirect("/listServlet");



	}

}
