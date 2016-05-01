package cn.ghy.flashpay;

import java.sql.Timestamp;
import java.util.Date;

import cn.ghy.flashpay.dao.LocationDao;
import cn.ghy.flashpay.model.location;

public class TestJson {

	public static void main(String args[]){
		LocationDao locationDao = new LocationDao();
		
		location entity = new location();
		entity.setName("home");
		entity.setBegintime(new Timestamp(new Date().getTime()));
		entity.setEndtime(new Timestamp(new Date().getTime()));
		entity.setStatus(1);
		boolean result = locationDao.add(entity);
		
		System.out.println(result);
	}
}
