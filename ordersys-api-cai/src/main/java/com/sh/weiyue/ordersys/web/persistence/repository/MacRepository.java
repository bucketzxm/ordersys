package com.sh.weiyue.ordersys.web.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sh.weiyue.ordersys.web.persistence.domain.Mac;


public interface MacRepository extends JpaRepository<Mac, Integer>{
	//@Query("select m.order.orderState from Mac m where m.macTime = (select min(macTime) from Mac)")
	@Query("select m from Mac m where m.macTime = (select min(macTime) from Mac m where m.macAddress = ?1) and m.macAddress = ?1")
	public Mac findLatestOrder(String address);
	
	@Query("select min(macTime) from Mac m where m.macAddress = ?1")
	public String findLatestTime(String address);
	
	@Query("select count(*) from Mac m where m.macAddress = ?1")
	public int findMacAddressCount(String address);
	
	@Query("select m.order.orderState from Mac m where m.macTime = (select max(macTime) from Mac m where m.macAddress = ?1) and m.macAddress = ?1")
	public Boolean findLatestOrderState(String address);
	
	@Query("select m.order.orderId from Mac m where m.macTime = (select max(macTime) from Mac m where m.macAddress = ?1) and m.macAddress = ?1")
	public int findLatestOrderId(String address);
}

