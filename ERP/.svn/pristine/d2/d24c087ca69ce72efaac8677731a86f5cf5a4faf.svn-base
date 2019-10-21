package com.baidu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.baidu.entity.User;
import com.baidu.service.ERPService;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/loginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
	
	@Autowired
	ERPService service;
	
	/**
	* 启动初始化上下文
	*/
	public void init(ServletConfig config) throws ServletException {
		super.init(config);  
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		//获得用户名和密码
		String username  = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		//创建user对象,用来保存用户名和密码
		User u = new User();
		u.setUserName(username);
		u.setPwd(pwd);
		//创建服务层
		User user = service.loginChect(u);
		if(user == null) {
			System.out.println("登陆失败");
			out.write("0");
		}else {
			System.out.println("登陆成功");
			//获取session对象
			HttpSession session = request.getSession();
			//将用户数据保存到session中
			session.setAttribute("user", user);
			out.write("1");
		}
		
		
		System.out.println(user);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
