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

import com.baidu.service.ERPService;

/**
 * Servlet implementation class DeleteDeptByUuid
 */
@WebServlet("/DeleteDeptByUuid")
public class DeleteDeptByUuid extends HttpServlet {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String uuid = request.getParameter("uuid");
		System.out.println(uuid);
		//调用服务层删除到方法
		int i = service.deleteDeptByUuid(uuid);
		
		response.sendRedirect("FindDeptList");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
