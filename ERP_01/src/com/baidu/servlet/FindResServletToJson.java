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

import com.baidu.entity.Res;
import com.baidu.service.ERPService;
import com.google.gson.Gson;

/**
 * Servlet implementation class FindResServletToJson
 */
@WebServlet("/FindResServletToJson")
public class FindResServletToJson extends HttpServlet {
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
		//解决乱码问题
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		List<Res> list = service.findResList();
		
		Gson gson = new Gson();
		out.write(gson.toJson(list));
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
