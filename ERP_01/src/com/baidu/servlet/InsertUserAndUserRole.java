package com.baidu.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.baidu.entity.User;
import com.baidu.service.ERPService;

/**
 * Servlet implementation class InsertUserAndUserRole
 */
@WebServlet("/InsertUserAndUserRole")
public class InsertUserAndUserRole extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	ERPService service;
	
	/**
	* 启动初始化上下文
	*/
	public void init(ServletConfig config) throws ServletException {
		super.init(config);  
		//解决自动注入的问题
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String tele = request.getParameter("tele");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String dept =request.getParameter("dept");
		User user = new User();
		user.setAddress(address);
		user.setDepUuid(dept);
		user.setEmail(email);
		user.setGender(gender);
		user.setName(name);
		user.setUserName(userName);
		user.setPwd(pwd);
		user.setTele(tele);
		
		String[] values = request.getParameterValues("roleId");
		//添加用户表并返回主键
		int uuid = service.insertUser(user);
		//添加用户和角色中间表
		for (String string : values) {
			service.insertUserRole(uuid,string);
		}
		response.sendRedirect("FindEmpListServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
