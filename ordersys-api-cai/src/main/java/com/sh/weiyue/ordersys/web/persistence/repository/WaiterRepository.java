package com.sh.weiyue.ordersys.web.persistence.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.sh.weiyue.ordersys.web.persistence.domain.Order;

public interface WaiterRepository extends JpaRepository<Order, Integer>{
	@Query("select o.orderId from Order o where o.orderDeskId = ?1 and o.orderState = 0")
	public Integer getOrderIdOfDesk(int deskId);
	
	@Query("select o.orderDeskId from Order o where o.orderIsSent = 1 and o.orderState = 0")
	public List<Integer> getDeskAlreadySentOrder();
	
	@Query("select o.orderDeskId from Order o where o.isHumanPay = 1 and o.orderState = 0")
	public List<Integer> getDeskHumanPay();	
	
	@Modifying@Transactional
    @Query("update Order o set o.isWaiterConfirm = 1 where o.orderId = ?1")
    int setWaiterConfirm( int orderId);	
	
	@Modifying@Transactional
    @Query("update Order o set o.isHumanPay = 1 where o.orderId = ?1")
    int setHumanPay( int orderId );	
	
	@Query("select o.orderDeskId from Order o where o.isWaiterConfirm = 1 and o.orderState = 0")
	public List<Integer> getDeskAlreadyConfirm();
	
	@Modifying@Transactional
    @Query("delete from Order o where o.orderDeskId = ?1 and o.orderState = 0")
    int deleteOrder( int deskId );
}
