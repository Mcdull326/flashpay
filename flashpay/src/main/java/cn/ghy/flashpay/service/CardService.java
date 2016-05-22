package cn.ghy.flashpay.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

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
	
	public boolean recharge(int card_id, BigDecimal amount){
		card entity = cardDao.getByCardId(card_id);
		entity.setBalance(amount.add(entity.getBalance()));
		return cardDao.update(entity);
	}
	
	public boolean consume(int card_id, BigDecimal amount){
		card entity = cardDao.getByCardId(card_id);
		entity.setBalance(entity.getBalance().subtract(amount));
		return cardDao.update(entity);
	}
	
	public List<card> getAll(){
		return cardDao.getAll();
	}
}
