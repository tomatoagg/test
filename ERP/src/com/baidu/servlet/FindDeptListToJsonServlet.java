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

import com.baidu.entity.Dept;
import com.baidu.service.ERPService;
import com.google.gson.Gson;

/**
 * Servlet implementation class FindDeptListToJsonServlet
 */
@WebServlet("/FindDeptListToJsonServlet")
public class FindDeptListToJsonServlet extends HttpServlet {
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
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		//连接数据库，查询所有部门
		List<Dept> list = service.findDeptList(null,null);
		//将数据转换成json格式
		Gson gson = new Gson();
		String json = gson.toJson(list);
		
		PrintWriter out = response.getWriter();
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
