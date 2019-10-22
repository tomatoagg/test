package com.baidu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.dao.ERPDao;
import com.baidu.entity.Dept;
import com.baidu.entity.User;
@Service("service")
public class ERPService {
	
	@Autowired
	ERPDao dao;

	/**
	 * 验证用户名和密码
	 */
	public User loginChect(User user) {
		return dao.loginCheckDao(user);
	}
	/**
	 * 查询所有部门
	 */
	public List<Dept> findDeptList(String name , String tele){
		return dao.findDeptList(name,tele);
	}
	/**
	 * 删除
	 * @param uuid
	 * @return
	 */
	public int deleteDeptByUuid(String uuid) {
		// TODO Auto-generated method stub
		return dao.deleteDeptByUuid(uuid);
	}
	/**
	 * 添加
	 * @param name
	 * @param tele
	 * @return
	 */
	public int addDept(String name, String tele) {
		// TODO Auto-generated method stub
		return dao.addDept(name,tele);
	}
	/**
	 * 根据id查询数据
	 * @param uuid
	 * @return
	 */
	public Dept FindDeptByUuid(String uuid) {
		// TODO Auto-generated method stub
		return dao.findDeptByUuid(uuid);
	}
	/**
	 * 修改
	 * @param uuid
	 * @param name
	 * @param tele
	 * @return
	 */
	public int updateDept(String uuid, String name, String tele) {
		// TODO Auto-generated method stub
		return dao.updateDept(uuid,name,tele);
	}
	/**
	 * 员工维护,查询所有
	 * @param user
	 * @return
	 */
	public List<User> findAllEmpList(User user) {
		// TODO Auto-generated method stub
		return dao.findAllEmpList(user);
	}
	/**
	 * 
	 * @param uuid
	 * @return
	 */
	public User findUserById(String uuid) {
		// TODO Auto-generated method stub
		return dao.findUserById(uuid);
	}
}
