package cn.ghy.flashpay.service;

import cn.ghy.flashpay.dao.CardDao;
import cn.ghy.flashpay.dao.StudentDao;
import cn.ghy.flashpay.model.card;
import cn.ghy.flashpay.model.student;

public class StudentService {

	public boolean addStu(student entity){
		return new StudentDao().add(entity);
	}

	public student login(String id, String pwd){
		student stu = new StudentDao().selectById(id);
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
}
