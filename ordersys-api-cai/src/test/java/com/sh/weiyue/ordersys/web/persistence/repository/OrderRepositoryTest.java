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






import com.sh.weiyue.ordersys.web.persistence.domain.Desk;
import com.sh.weiyue.ordersys.web.persistence.domain.Food;
import com.sh.weiyue.ordersys.web.persistence.domain.Order;
import com.sh.weiyue.ordersys.web.persistence.domain.Orderitem;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class OrderRepositoryTest {

	@Autowired
	OrderRepository repository;
	
	@Autowired
	DeskRepository deskRepository;
	
	@Autowired
    OrderitemRepository orderitemRepos;
	
	@Autowired
	FoodRepository foodRepos;
	
	Logger logger ;

	@Before
	public void setUp() {
		logger = Logger.getRootLogger();
		logger.info("++---------------------------------++");
	}
	
	@Test
	public void findByOrderCode(){
		/*Desk desk = deskRepository.findOne(1);
		//Desk desk = deskRepository.findByDeskName("#1");
		logger.info(desk);
		logger.info("point1");
		Order order = new Order("0001", new BigDecimal(1.0), "201310271744", new BigDecimal(2.0),desk);
		//Order order=new Order(desk,3);
		//logger.info(order);

		order = repository.save(order);
		//logger.info(order);
		assertEquals("Not equal","0001", repository.findByOrderCode(order.getOrderCode()).getOrderCode());
		//List<Order> orderList=repository.findByDeskAndOrderState(desk, false);//找出所有在“#1”桌，且还没有付款的订单
//		for(int i=0;i<orderList.size();i++)
//		{
//			logger.info( orderList.get(i).getOrderId()+"-------");
//		}
		
		///logger.info("personNum是："+ order2.getOrderPersonNum());
		System.out.println("point4------------");
		repository.delete(order.getOrderId());
		
		logger.info("point3");
		//Orderitem ordi = orderitemRepos.findAll().get(0);
		order = repository.findAll().get(0);
		Food food = foodRepos.findAll().get(0);		
		Orderitem ordi = new Orderitem(order,food);
		ordi = orderitemRepos.save(ordi);
		System.out.println(ordi.getOrderitemId()+"-----------");
		orderitemRepos.delete(ordi.getOrderitemId());
		logger.info("findByOrderCode():completed");*/
	
		System.out.println("哈哈" + repository.setOrderState(true, 39));
	}

}