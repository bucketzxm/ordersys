package com.sh.weiyue.ordersys.web.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.sh.weiyue.ordersys.web.persistence.domain.Orderitem;

public interface OrderitemRepository extends JpaRepository<Orderitem, Integer> {
	@Modifying@Transactional
	@Query("delete from Orderitem o where o.orderitemId = ?1")
	int deleteOrderitem(int id);
	
	@Query("select orderitemId from Orderitem ")
	public List<Integer> getOrderitem();
}
