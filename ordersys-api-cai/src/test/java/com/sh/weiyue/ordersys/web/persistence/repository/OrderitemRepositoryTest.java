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
import com.sh.weiyue.ordersys.web.persistence.domain.Order;
import com.sh.weiyue.ordersys.web.persistence.domain.Orderitem;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class OrderitemRepositoryTest {

	@Autowired
	OrderitemRepository repository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	FoodRepository foodRepository;
	
	Logger logger ;
	Orderitem item;

	@Before
	public void setUp() {
		logger = Logger.getRootLogger();
		logger.info("++---------------------------------++");
		Food food = foodRepository.findOne(1);
		Order order = orderRepository.findOne(36);
		item = new Orderitem(order,food);
	}
	
	@Test
	public void findByMenuitemBigsale(){

		item = repository.save(item);
		logger.info(item);
		
		System.out.println("point----------------"+item.getOrderitemId());
		repository.deleteOrderitem(item.getOrderitemId());
		logger.info("findByMenuitemBigsale():completed");
	}
}
