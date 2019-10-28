package com.baidu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.dao.ERPDao;
import com.baidu.entity.Dept;
import com.baidu.entity.EmpRole;
import com.baidu.entity.Res;
import com.baidu.entity.Role;
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
	 * 根据ID查询用户，修改
	 * @param uuid
	 * @return
	 */
	public User findUserById(String uuid) {
		// TODO Auto-generated method stub
		return dao.findUserById(uuid);
	}
	/**
	 * 查询所有角色信息
	 * @return
	 */
	public List<Role> findRoleAll() {
		// TODO Auto-generated method stub
		return dao.findAllRole();
	}
	/**
	 * 添加用户并返回主键
	 * @param user
	 * @return
	 */
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return dao.insertUser(user);
	}
	/**
	 * 添加用户和角色中间表
	 * @param uuid
	 * @param string
	 */
	public void insertUserRole(int uuid, String string) {
		// TODO Auto-generated method stub
		dao.insertUserRole(uuid,string);
	}
	/**
	 * 查询用户的角色
	 * @param uuid
	 * @return
	 */
	public List<EmpRole> findUserRoleServletToJson(String uuid) {
		// TODO Auto-generated method stub
		return this.dao.findUserRoleServletToJson(uuid);
	}
	/**
	 * 查询所有资源信息
	 * @return
	 */
	
	public List<Res> findResList() {
		// TODO Auto-generated method stub
		return dao.findResList();
	}
	/**
	 * 添加角色并返回主键
	 * @param name
	 * @param code
	 * @return
	 */
	public int insetRole(String name, String code) {
		// TODO Auto-generated method stub
		return dao.insetRole(name,code);
	}
	/**
	 * 添加角色资源中间表
	 * @param uuid
	 * @param id
	 */
	public void insertRoleRes(int uuid, String id) {
		// TODO Auto-generated method stub
		dao.insertRoleRes(uuid,id);
	}
}
