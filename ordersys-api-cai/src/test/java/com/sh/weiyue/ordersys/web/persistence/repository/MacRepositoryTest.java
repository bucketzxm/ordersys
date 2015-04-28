package com.sh.weiyue.ordersys.web.persistence.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class MacRepositoryTest {
	@Autowired
	MacRepository repository;
	
	@Test
	public void findByCategoryName(){
		System.out.println("该用户的订单数量为：" + repository.findMacAddressCount("10-10"));
		System.out.println("该用户最后一笔订单是否已完成:" + repository.findLatestOrderState("10-10"));
		System.out.println("该用户最后一笔订单的id为：" + repository.findLatestOrderId("10-10"));
	}
}
