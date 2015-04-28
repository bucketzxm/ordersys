package com.sh.weiyue.ordersys.web.persistence.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class CartRepositoryTest {
	@Autowired
	CartRepository repository;
	
	@Test
	public void inertOrderitem(){
		//repository.insertOrderitem(33, 1);
	}
	
	@Test
	public void getTotalC(){
		System.out.println("getTotalC:" + repository.getTotalC(44));
	}
	
	@Test
	public void getTotalF(){
		System.out.println("getFoodAmount:" + repository.getFoodAmount( 19, 1));
		System.out.println("getTotalF:" + repository.getTotalF(44));
		System.out.println("getTotalCost:" + repository.getTotalCost(44));
		System.out.println("getPlatformMoney:" + repository.getPlatformMoney(44));
		System.out.println("getShopperMoney:" + repository.getShopperMoney(44));
		System.out.println("getDeskIdByOrder:" + repository.getDeskIdByOrder(44));
		System.out.println("getpersonNumByOrder:" + repository.getpersonNumByOrder(44));
		
	}
	
	
}
