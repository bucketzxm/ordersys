package com.sh.weiyue.ordersys.web.persistence.repository;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sh.weiyue.ordersys.web.persistence.domain.Category;
import com.sh.weiyue.ordersys.web.persistence.domain.Food;
import com.sh.weiyue.ordersys.web.persistence.domain.Menuitem;
import com.sh.weiyue.ordersys.web.persistence.domain.Special;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class SpecialRepositoryTest {

	@Autowired
	SpecialRepository repository;
	
	@Autowired
	FoodRepository foodRepository;
	
	Logger logger ;

	Special special; 
	
	@Before
	public void setUp() {
		logger = Logger.getRootLogger();
		logger.info("++---------------------------------++");
		Food food = foodRepository.findOne(23);
		special = new Special(new BigDecimal(1.0), 5, 4, food);
	}
	
	@Test
	public void findBySpecialRemainGreaterThan(){
		special = repository.save(special);
		logger.info(special);
		List<Special> sps = repository.findBySpecialRemainGreaterThan(0, new Sort(Sort.Direction.ASC, new String[]{"specialRemain"}));
		logger.info("Numbers:" + sps.size());
		assertEquals("Not equal",2, sps.size());
		logger.info(sps.get(0));
		logger.info(sps.get(1));
		logger.info("-----------------------------------------------------------");
		sps = repository.findBySpecialRemainGreaterThan(0, new Sort(Sort.Direction.DESC, new String[]{"specialRemain"}));	
		logger.info("Numbers:" + sps.size());
		assertEquals("Not equal",2, sps.size());
		logger.info(sps.get(0));
		logger.info(sps.get(1));
		repository.delete(special);
		logger.info("findBySpecialRemainGreaterThan():completed");
	}

}
