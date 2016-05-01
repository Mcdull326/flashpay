package cn.ghy.flashpay.service;

import java.sql.Timestamp;
import java.util.Date;

import cn.ghy.flashpay.dao.CardDao;
import cn.ghy.flashpay.model.card;

public class CardService {

	private CardDao cardDao = new CardDao();
	
	public boolean addCard(card entity){
		return cardDao.add(entity);
	}
	
	public boolean lossCard(String stu_id){
		card entity = cardDao.getByStuId(stu_id);
		entity.setStatus(-1);
		entity.setEndtime(new Timestamp(new Date().getTime()));
		return cardDao.update(entity);
	}
	
	public boolean recharge(int card_id, Long amount){
		card entity = cardDao.getByCardId(card_id);
		entity.setBalance(entity.getBalance() + amount);
		return cardDao.update(entity);
	}
	
	public boolean consume(int card_id, Long amount){
		card entity = cardDao.getByCardId(card_id);
		entity.setBalance(entity.getBalance() - amount);
		return cardDao.update(entity);
	}
}
