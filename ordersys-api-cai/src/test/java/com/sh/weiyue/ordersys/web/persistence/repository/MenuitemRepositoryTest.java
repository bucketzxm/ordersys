package com.sh.weiyue.ordersys.web.persistence.repository;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sh.weiyue.ordersys.web.persistence.domain.Category;
import com.sh.weiyue.ordersys.web.persistence.domain.Food;
import com.sh.weiyue.ordersys.web.persistence.domain.Menuitem;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class MenuitemRepositoryTest {

	@Autowired
	MenuitemRepository repository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	FoodRepository foodRepository;
	
	Logger logger ;
	Menuitem item;

	@Before
	public void setUp() {
		logger = Logger.getRootLogger();
		logger.info("++---------------------------------++");
		Food food = foodRepository.findOne(1);
		Category cg = categoryRepository.findOne(1);
		item = new Menuitem(food,cg);
	}
	
	@Test
	public void findByMenuitemBigsale(){
		item.setMenuitemBigsale(new BigDecimal(0.01));
		item = repository.save(item);
		logger.info(item);
		
		List<Menuitem> menus = repository.findByMenuitemBigsaleLessThan(new BigDecimal(0));
		logger.info("Numbers:" + menus.size());
		logger.info(menus.get(0));
		//assertEquals("Not equal",102, menus.size());
		
		menus = repository.findByMenuitemBigsaleGreaterThan(new BigDecimal(0));
		logger.info("Numbers:" + menus.size());
		logger.info(menus.get(0));
		//assertEquals("Not equal",1, menus.size());
		
		
		menus = repository.findAll();	
		
		logger.info("Numbers:" + menus.size());
		logger.info(menus.get(0));
		//assertEquals("Not equal",103, menus.size());
		
		System.out.println("point----------------");
		repository.delete(item.getMenuitemId());
		logger.info("findByMenuitemBigsale():completed");
	}
	
	@Test
	public void findByMenuitemStatus(){
		List<Menuitem> menus = repository.findByMenuitemStatus((byte)1);
		logger.info("Numbers:" + menus.size());
		logger.info(menus.get(0));
		//assertEquals("Not equal",102, menus.size());
		logger.info("findByMenuitemStatus():completed");
	}

}
