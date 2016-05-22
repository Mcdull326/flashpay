package cn.ghy.flashpay.service;

import java.util.List;

import cn.ghy.flashpay.dao.CardDao;
import cn.ghy.flashpay.dao.StudentDao;
import cn.ghy.flashpay.model.card;
import cn.ghy.flashpay.model.student;

public class StudentService {

	private StudentDao studentDao = new StudentDao();
	
	public boolean addStu(student entity){
		return studentDao.add(entity);
	}

	public student login(String id, String pwd){
		student stu = studentDao.selectById(id);
		if(stu != null){
			if(stu.getPassword().equals(pwd)){
				return stu;
			}
		}
		return null;
	}
	
	public card isActive(String stu_id){
		return new CardDao().getByStuId(stu_id);
	}
	
	public List<student> getAll(){
		return studentDao.getAll();
	}
}
