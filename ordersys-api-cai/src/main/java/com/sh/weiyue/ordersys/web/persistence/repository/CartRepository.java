package com.sh.weiyue.ordersys.web.persistence.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.sh.weiyue.ordersys.web.persistence.domain.Order;
import com.sh.weiyue.ordersys.web.persistence.domain.Orderitem;

public interface CartRepository extends JpaRepository<Order, Integer> {
	@Query("select o from Orderitem o where o.order.orderId = ?1 and o.food.foodId = ?2")
	public Orderitem findOrderitem(int orderId,int foodId);
	
//	@Modifying@Transactional
//	@Query(value = "insert into `order_sys`.`orderitem` (`orderitem_status`, `orderitem_amount`, `orderitem_order`, `orderitem_food`) VALUES ('0', '1', ?1, '1')",
//			 nativeQuery = true)
//	public int insertOrderitem(int orderId,int foodId);
	
	//几种食物
	@Query("select count(*) from Orderitem o where o.order.orderId = ?1")
	public Integer getTotalC(int orderId);
	
	@Query("select sum(o.orderitemAmount) from Orderitem o where o.order.orderId = ?1 and o.food.foodId = ?2")
	public Integer getFoodAmount(int orderId, int foodId );
	
	@Query("select sum(o.orderitemAmount) from Orderitem o where o.order.orderId = ?1")
	public Integer getTotalF(int orderId);
	
	@Query("select sum(o.orderitemPrice) from Orderitem o where o.order.orderId = ?1")
	public BigDecimal getTotalCost(int orderId);
	
	@Query("select sum(o.orderitemPrice) from Orderitem o where o.order.orderId = ?1 and o.orderitemOwner = 1")
	public BigDecimal getPlatformMoney(int orderId);
	
	@Query("select sum(o.orderitemPrice) from Orderitem o where o.order.orderId = ?1 and o.orderitemOwner = 0")
	public BigDecimal getShopperMoney(int orderId);
	
	@Query("select o.orderDeskId from Order o where o.orderId = ?1")
	public Integer getDeskIdByOrder(int orderId);
	
	@Query("select o.orderPersonNum from Order o where o.orderId = ?1")
	public Integer getpersonNumByOrder(int orderId);
	
	@Query("select m.menuitemStatus from Menuitem m where m.food.foodId = ?1")
	public Integer getFoodStatus(int foodId);
	
	@Query("select o.orderState from Order o where o.orderId = ?1")
	public Boolean getOrderStatus(int orderId);
}
