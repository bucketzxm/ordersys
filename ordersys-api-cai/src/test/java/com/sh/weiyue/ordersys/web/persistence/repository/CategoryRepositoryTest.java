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

import com.sh.weiyue.ordersys.web.persistence.domain.Category;
import com.sh.weiyue.ordersys.web.persistence.domain.Menuitem;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class CategoryRepositoryTest {

	@Autowired
	CategoryRepository repository;
	Logger logger ;

	@Before
	public void setUp() {
		logger = Logger.getRootLogger();
		logger.info("++---------------------------------++");
	}
	
	@Test
	public void findByCategoryName(){
		Category cg = repository.findOne(1);
		logger.info(cg);
		List<Menuitem> menus = cg.getMenuitems();
		
		logger.info("Numbers:" + menus.size());
		logger.info(menus.get(0));
		assertEquals("Not equal",12, menus.size());
		List<Category> cgs = repository.findAll();
	    for(int i=0;i<cgs.size();i++)
	    {
	    	logger.info(cgs.get(i).getCategoryName());
	    	
	    }
		logger.info("findCategoryName():completed");
	}

}
