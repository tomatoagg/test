package com.baidu.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.baidu.entity.Dept;
import com.baidu.entity.User;

@Repository(value="dao")
public class ERPDao {

	@Autowired
	JdbcTemplate jdbcT;
	
	/**
	 * 验证用户名和密码
	 */
	public User loginCheckDao(User user) {
		String sql = "select * from tbl_emp where username = '"+user.getUserName()+"' and pwd = '"+user.getPwd()+"'";
		RowMapper<User> row = new BeanPropertyRowMapper<User>(User.class);
		User user1 = jdbcT.queryForObject(sql, row);
		
		return user1;
	}
	/**
	 * 查询所有部门数据
	 */
	public List<Dept> findDeptList(String name ,String tele){
		StringBuilder str = new StringBuilder("select * from tbl_dept where 1=1 ");
		if(name != null || "".equals(name)) {
			str.append("and name like '%");
			str.append(name);
			str.append("%'");
		}
		if(tele != null || "".equals(tele)) {
			str.append("and tele like '%");
			str.append(tele);
			str.append("%'");
		}
		
		RowMapper<Dept> row = new BeanPropertyRowMapper<Dept>(Dept.class);
		List<Dept> list = jdbcT.query(str.toString(), row);
		return list;
	}
	/**
	 * 删除
	 * @param uuid
	 * @return
	 */
	public int deleteDeptByUuid(String uuid) {
		// TODO Auto-generated method stub
		String sql = "delete from tbl_dept where uuid = "+uuid;
		return  jdbcT.update(sql);
	}
	/**
	 * 添加
	 * @param name
	 * @param tele
	 * @return
	 */
	public int addDept(String name, String tele) {
		// TODO Auto-generated method stub
		String sql = "insert into tbl_dept(name,tele) values('"+name+"','"+tele+"')";
		return jdbcT.update(sql);
	}
	/**
	 * 根据uuid查询数据
	 * @param uuid
	 * @return
	 */
	public Dept findDeptByUuid(String uuid) {
		// TODO Auto-generated method stub
		String sql = "select * from tbl_dept where uuid = "+uuid;
		RowMapper<Dept> row = new BeanPropertyRowMapper<>(Dept.class);
		Dept dept = jdbcT.queryForObject(sql,row);
		return dept;
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
		String sql = "update tbl_dept set name = '"+name+"',tele = '"+tele+"' where uuid ="+uuid;
		return jdbcT.update(sql);
	}
	/**
	 * 员工维护
	 * @param user
	 * @return
	 */
	public List<User> findAllEmpList(User user) {
		// TODO Auto-generated method stub
		StringBuffer str = new StringBuffer("select e.uuid,\n" + 
				"e.userName," + 
				"e.pwd," + 
				"e.`name`," + 
				"e.email," + 
				"e.tele," + 
				"e.gender," + 
				"date_format(FROM_UNIXTIME(e.birthday/1000), '%Y-%m-%d') as birthday," + 
				"date_format(FROM_UNIXTIME(e.lastLoginTime/1000), '%Y-%m-%d') as lastLoginTime,"
				+ "d.name as depUuid "
				+ "from tbl_emp e left  join tbl_dept d on e.depUuid = d.uuid where 1=1");
		if(user.getName() != null && !"".equals(user.getName())) {
			str.append(" and name like '%");
			str.append(user.getName());
			str.append("%'");
		}
		RowMapper<User> row = new BeanPropertyRowMapper<User>(User.class);
		
		return jdbcT.query(str.toString(), row);
	}
	/**
	 * 修改用户
	 * @param uuid
	 * @return
	 */
	public User findUserById(String uuid) {
		// TODO Auto-generated method stub
		StringBuffer str = new StringBuffer("select e.uuid,\n" + 
				"e.userName," + 
				"e.pwd," + 
				"e.`name`," + 
				"e.email," + 
				"e.tele," + 
				"e.gender," +
				"e.depUuid,"+
				"e.address,"+
				"date_format(FROM_UNIXTIME(e.birthday/1000), '%Y-%m-%d') as birthday," + 
				"date_format(FROM_UNIXTIME(e.lastLoginTime/1000), '%Y-%m-%d') as lastLoginTime "+
				"from tbl_emp e where e.uuid =");
		str.append(uuid);
		RowMapper<User> row = new BeanPropertyRowMapper<>(User.class);
		User user = jdbcT.queryForObject(str.toString(),row);
		return user;
	}
	
}
