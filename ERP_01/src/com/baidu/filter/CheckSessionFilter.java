package com.baidu.filter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baidu.entity.User;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class CheckSessionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CheckSessionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//请求，转发转换
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp =(HttpServletResponse) response;
		//获取session对象
		HttpSession session = req.getSession();
		//获取登陆用户
		User user = (User)session.getAttribute("userSession");
		// 获得用户请求的URI
        String path = req.getRequestURI();
        System.out.println(path);
        //登陆不需要验证用户是否登陆
        if(path.contains("loginCheckServlet") || path.contains("login.jsp") ||  path.contains("index.jsp")||path.contains(".gif") ||path.contains(".css")  || path.contains(".png")||path.contains(".jpg")) {
        	chain.doFilter(req, resp);
        	return;
        }else {
        	//判断用户是否登陆
        	if(user == null) {
        		resp.sendRedirect(req.getContextPath()+"/jsps/login.jsp");
        	}else {
        		//已登陆放行
        		if(!path.contains(".jsp")) {
        			//获取用户权限
	        		List<Map<String,String>> list = (List<Map<String, String>>) session.getAttribute("resList");
	        		for (Map<String, String> map : list) {
	        			//登陆成功，验证是否有相对应到权限
						if(path.contains(map.get("url"))) {
							System.out.println("存在权限");
							chain.doFilter(req, resp);
			        		return;
						}
					}
	        		//权限 不足
	        		System.out.println("权限不足");
	        		resp.sendRedirect(req.getContextPath()+"/jsps/error.jsp");
	        		return;
        		}
        		chain.doFilter(req, resp);
        		return;
        	}
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
