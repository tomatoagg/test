package com.baidu.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baidu.dao.ERPDao;
import com.baidu.entity.User;
import com.baidu.service.ERPService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		ERPDao e = (ERPDao)app.getBean("dao");
		
		
		System.out.println(e.insertUser(null));
	}

}
