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
 * Servlet implementation class AddOrUpdateDeptServlet
 */
@WebServlet("/AddOrUpdateDeptServlet")
public class AddOrUpdateDeptServlet extends HttpServlet {
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
		//设置编码格式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String flag = request.getParameter("flag");
		String name = request.getParameter("name");
		String tele = request.getParameter("tele");
		String uuid = request.getParameter("uuid");
		if(flag.equals("")) {
			//添加
			int i = service.addDept(name,tele);
		}else if(flag.equals("1")) {
			//修改
			int j = service.updateDept(uuid,name,tele);
		}
		
		response.sendRedirect("FindDeptList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
