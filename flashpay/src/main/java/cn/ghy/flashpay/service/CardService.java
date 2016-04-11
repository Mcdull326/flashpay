package cn.ghy.flashpay.service;

import java.sql.Timestamp;
import java.util.Date;

import cn.ghy.flashpay.dao.CardDao;
import cn.ghy.flashpay.model.card;

public class CardService {

	private CardDao cardDao = new CardDao();
	
	public boolean addCard(card entity){
		boolean result = cardDao.add(entity);
		//cardDao.getSqlSession().close();
		return result;
	}
	
	public boolean lossCard(String stu_id){
		card record = cardDao.getByStuId(stu_id);
		record.setStatus(-1);
		record.setEndtime(new Timestamp(new Date().getTime()));
		boolean result = cardDao.updateStatus(record);
		//cardDao.getSqlSession().close();
		return result;
	}
}
