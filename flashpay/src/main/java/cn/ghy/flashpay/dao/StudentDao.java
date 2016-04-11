package cn.ghy.flashpay.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.ghy.flashpay.mapper.studentMapper;
import cn.ghy.flashpay.model.student;
import cn.ghy.flashpay.model.studentExample;
import cn.ghy.flashpay.util.GetSqlSession;

public class StudentDao {

	// DB Connect
	private SqlSession sqlSession = GetSqlSession.getSqlSession();
	// Mapper
	private studentMapper mapper = sqlSession.getMapper(studentMapper.class);

	//insert into student ()
	public boolean add(student entity){
		try{
			if(mapper.insert(entity) == 1){
				sqlSession.commit();
				return true;
			}else{
				return false;
			}
		}finally{
			sqlSession.close();
		}
	}
	
	//select * from student where id = id;
	public student selectById(String id){
		try{
			return mapper.selectByPrimaryKey(id);
		}finally{
			sqlSession.close();
		}
	}
	
	// select * from student where status = 0 or 1
	public List<student> getAll() throws SQLException {
		try {
			studentExample example = new studentExample();
			List<Integer> values = new ArrayList<Integer>();
			values.add(0);
			values.add(1);
			example.or().andStatusIn(values);

			return mapper.selectByExample(example);

		} finally {
			sqlSession.close();
		}
	}
}
