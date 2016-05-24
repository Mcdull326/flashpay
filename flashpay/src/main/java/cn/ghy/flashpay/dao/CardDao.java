package cn.ghy.flashpay.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.ghy.flashpay.mapper.cardMapper;
import cn.ghy.flashpay.model.card;
import cn.ghy.flashpay.model.cardExample;
import cn.ghy.flashpay.util.GetSqlSessionFactory;

public class CardDao {

	private SqlSessionFactory sqlSessionFactory = GetSqlSessionFactory.getSqlSessionFactory();

	// insert into card ()
	public boolean add(card entity) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		cardMapper mapper = sqlSession.getMapper(cardMapper.class);
		try {
			if (mapper.insert(entity) == 1) {
				sqlSession.commit();
				return true;
			}
			return false;
		} finally {
			sqlSession.close();
		}
	}

	// select * from card where id = card_id and status =1;
	public card getByCardId(int card_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		cardMapper mapper = sqlSession.getMapper(cardMapper.class);
		try {
			return mapper.selectByPrimaryKey(card_id);
		} finally {
			sqlSession.close();
		}
	}

	// select * from card where stu_id = stu_id and status = 1;
	public card getByStuId(String stu_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		cardMapper mapper = sqlSession.getMapper(cardMapper.class);
		try {
			cardExample example = new cardExample();
			example.or().andStuIdEqualTo(stu_id).andStatusEqualTo(1);
			List<card> cardList = mapper.selectByExample(example);
			if (cardList.isEmpty()) {
				return null;
			}
			return cardList.get(0);
		} finally {
			sqlSession.close();
		}
	}

	// update card
	public boolean update(card entity) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		cardMapper mapper = sqlSession.getMapper(cardMapper.class);
		try {
			if (mapper.updateByPrimaryKey(entity) == 1) {
				sqlSession.commit();
				return true;
			}
			return false;
		} finally {
			sqlSession.close();
		}
	}

	// select * from card where status = 1;
	public List<card> getAll() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		cardMapper mapper = sqlSession.getMapper(cardMapper.class);
		try {
			return mapper.selectByExample(null);
		} finally {
			sqlSession.close();
		}
	}
}
