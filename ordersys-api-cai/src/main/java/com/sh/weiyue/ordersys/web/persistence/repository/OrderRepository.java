package com.sh.weiyue.ordersys.web.persistence.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.sh.weiyue.ordersys.web.persistence.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	public Order findByOrderCode(String orderCode);
	public Order findByorderId(int orderId);
	
	//public Order findByOutTradeNum(int outTradeNum);
	
	public List<Order> findByOrderState(Boolean orderState);
	public List<Order> findByorderDeskIdAndOrderState(Integer deskId,Boolean state);
	
	
	@Modifying@Transactional
	@Query("update Order o set o.orderState = ?1 where o.orderId = ?2")
	int setOrderState(Boolean state,int id);

	@Modifying@Transactional
	@Query("update Order o set o.orderIsSent = ?1 where o.orderId = ?2")
	int setOrderIsSent(Boolean state,int id);

	@Modifying@Transactional
    @Query("update Order o set o.orderMermoney = ?1 where o.orderId = ?2")
    int setOrderMermoney( BigDecimal d ,int id);

    @Modifying@Transactional
    @Query("update Order o set o.orderCommoney = ?1 where o.orderId = ?2")
    int setOrderCommoney( BigDecimal d ,int id);
    
	
    @Modifying@Transactional
    @Query("update Order o set o.out_trade_no = ?1 where o.orderId = ?2")
    int setOutTradeNum(String out_trade_num,int id);
    
    
    @Query("select o.orderDeskId from Order o where o.isWaiterConfirm = null")
	public List<Integer> getUnconfirmOrder();
	
	@Query("select orderDeskId from Order")
	public List<Integer> getAllOrder();
	
	
	@Query("delete from Order where orderid = ?1")
	public void deleteOrder(int id);
	
}
