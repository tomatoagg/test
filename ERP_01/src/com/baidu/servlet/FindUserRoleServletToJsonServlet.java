package com.baidu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.baidu.entity.EmpRole;
import com.baidu.entity.Role;
import com.baidu.service.ERPService;
import com.google.gson.Gson;

/**
 * Servlet implementation class FindUserRoleServletToJsonServlet
 */
@WebServlet("/FindUserRoleServletToJsonServlet")
public class FindUserRoleServletToJsonServlet extends HttpServlet {
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
		// TODO Auto-generated method stub
		//获取用户的 id
		String uuid = request.getParameter("uuid");
		List<EmpRole> list = service.findUserRoleServletToJson(uuid);
		
		PrintWriter out = response.getWriter();
		//创建Gson对象，将list集合转换成string
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		out.write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
