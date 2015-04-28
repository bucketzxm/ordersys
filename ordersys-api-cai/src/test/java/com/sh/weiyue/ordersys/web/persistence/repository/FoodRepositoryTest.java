package com.sh.weiyue.ordersys.web.persistence.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sh.weiyue.ordersys.web.persistence.domain.Food;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
@Transactional
public class FoodRepositoryTest {

	@Autowired
	FoodRepository repository;
	
	Logger logger ;
	
	Food food;

	@Before
	public void setUp() {
		logger = Logger.getRootLogger();
		logger.info("++---------------------------------++");
		food = new Food("#food", new BigDecimal(2.3));
	}
	
	@Test
	public void findByFoodName(){
		food = repository.save(food);
		Food tfood = repository.findByFoodName("#food");
		logger.info(food);
		logger.info(tfood);
		assertEquals("Not equal", food.getFoodId(), tfood.getFoodId());
		repository.delete(food);
		
        Food food1 = repository.findOne(5);
        System.out.println(food1.getMenuitems());
        System.out.println(food1.getSpecial());

		logger.info("findByfoodName():completed");
	}
	
	@Test
	public void findByFoodPriceBetween(){
		food = repository.save(food);
		List<Food> foods = repository.findByFoodPriceBetween(new BigDecimal(0.01), new BigDecimal(4.0));
		logger.info(food);
		logger.info("Number :" +foods.size());
		
		foods = repository.findByFoodPriceBetween(new BigDecimal(0), new BigDecimal(4.0));
		logger.info(food);
		logger.info("Number :" +foods.size());
		
		assertTrue("Not botain", foods.contains(food));
		repository.delete(food);
		logger.info("findByFoodPriceBetween():completed");
	}
	
}
