package cn.ghy.flashpay.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GetSqlSessionFactory {
	
	public static SqlSessionFactory getSqlSessionFactory(){
		
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("MapperConfig.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
}