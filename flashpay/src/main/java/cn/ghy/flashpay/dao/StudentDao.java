package cn.ghy.flashpay.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.ghy.flashpay.mapper.studentMapper;
import cn.ghy.flashpay.model.student;
import cn.ghy.flashpay.util.GetSqlSessionFactory;

public class StudentDao {

	private SqlSessionFactory sqlSessionFactory = GetSqlSessionFactory.getSqlSessionFactory();

	// insert into student ()
	public boolean add(student entity) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		studentMapper mapper = sqlSession.getMapper(studentMapper.class);
		try {
			if (mapper.insert(entity) == 1) {
				sqlSession.commit();
				return true;
			} else {
				return false;
			}
		} finally {
			sqlSession.close();
		}
	}

	// select * from student where id = id;
	public student selectById(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		studentMapper mapper = sqlSession.getMapper(studentMapper.class);
		try {
			return mapper.selectByPrimaryKey(id);
		} finally {
			sqlSession.close();
		}
	}

	// select * from student
	public List<student> getAll() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		studentMapper mapper = sqlSession.getMapper(studentMapper.class);
		try {
			return mapper.selectByExample(null);
		} finally {
			sqlSession.close();
		}
	}
}
