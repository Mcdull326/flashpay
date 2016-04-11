package cn.ghy.flashpay.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.ghy.flashpay.mapper.cardMapper;
import cn.ghy.flashpay.model.card;
import cn.ghy.flashpay.model.cardExample;
import cn.ghy.flashpay.util.GetSqlSession;

public class CardDao {

	// DB Connect
	private SqlSession sqlSession = GetSqlSession.getSqlSession();
	// Mapper
	private cardMapper mapper = sqlSession.getMapper(cardMapper.class);
	
	
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	//insert into student ()
	public boolean add(card entity){
		if(mapper.insert(entity) == 1){
			sqlSession.commit();
			return true;
		}
		return false;
	}
		
	//select * from card where stu_id = stu_id and status = 1;
	public card getByStuId(String stu_id){
		cardExample example = new cardExample();
		example.or().andStuIdEqualTo(stu_id).andStatusEqualTo(1);
		List<card> cardList = mapper.selectByExample(example);
		if(cardList.isEmpty()){
			return null;
		}
		return cardList.get(0);
	}
	
	//update card set status = -1 where ...;
	public boolean updateStatus(card record){
		if(mapper.updateByPrimaryKey(record) == 1){
			sqlSession.commit();
			return true;
		}
		return false;
	}
}
