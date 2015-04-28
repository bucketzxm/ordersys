package com.sh.weiyue.ordersys.web.persistence.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sh.weiyue.ordersys.web.persistence.domain.Desk;
import com.sh.weiyue.ordersys.web.persistence.domain.Pay;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class PayRepositoryTest {

	@Autowired
	PayRepository repository;
	Logger logger ;
	Pay pay;
	
	@Before
	public void setUp() {
		logger = Logger.getRootLogger();
		logger.info("++---------------------------------++");
		pay = new Pay("#test0", "#test1", "#test2");	
	}
	
	@Test
	public void findByPayName(){
		pay = repository.save(pay);
		pay = repository.findByPayName("#test0");
		logger.info(pay);
		assertEquals("Not equal", "#test0", pay.getPayName());
		logger.info("findByPayName():completed");
		repository.delete(pay);
	}
	
	@Test
	public void findByPayCompany(){
		pay = repository.save(pay);
		List<Pay> pays = repository.findByPayCompany("#test1");
		logger.info("Number:" + pays.size());
		assertEquals("Not equal", 1, pays.size());
		repository.delete(pay);
		logger.info("findByPayCompany():completed");
		
	}
	
	@Test
	public void findByPayMerchant(){
		pay = repository.save(pay);
		List<Pay> pays = repository.findByPayMerchant("#test2");
		logger.info("Number:" + pays.size());
		assertEquals("Not equal", 1, pays.size());
		repository.delete(pay);
		logger.info("findByPayMerchant():completed");
	}

}
