package com.baidu.servlet;

import java.io.IOException;
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

/**
 * Servlet implementation class FindDeptList
 * 查询所有部门
 */
@WebServlet("/FindDeptList")
public class FindDeptList extends HttpServlet {
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
		//获取模糊查询到值
		String name = request.getParameter("name");
		String tele = request.getParameter("tele");
		//连接数据库，查询所有部门
		List<Dept> list = service.findDeptList(name,tele);
		//将数据返回到页面
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/jsps/department/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
