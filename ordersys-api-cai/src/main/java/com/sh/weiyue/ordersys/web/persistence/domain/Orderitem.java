package com.sh.weiyue.ordersys.web.persistence.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the orderitem database table.
 * 
 */
@Entity
@NamedQuery(name="Orderitem.findAll", query="SELECT o FROM Orderitem o")
public class Orderitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="orderitem_id")
	private Integer orderitemId;

	//单品的数量
	@Column(name="orderitem_amount")
	private int orderitemAmount;

	//设置收款方,1：公司  0：商家
	@Column(name="orderitem_owner")
	private Byte orderitemOwner;

	@Column(name="orderitem_price")
	private BigDecimal orderitemPrice;

	@Column(name="orderitem_status")
	private Byte orderitemStatus;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="orderitem_order")
	private Order order;

	//uni-directional many-to-one association to Food
	@ManyToOne
	@JoinColumn(name="orderitem_food")
	private Food food;

	public Orderitem() {
	}

	public Orderitem(int orderitemAmount, Byte orderitemOwner,
			BigDecimal orderitemPrice, Order order, Food food) {
		this.orderitemAmount = orderitemAmount;
		this.orderitemOwner = orderitemOwner;
		this.orderitemPrice = orderitemPrice;
		this.order = order;
		this.food = food;
		this.orderitemStatus = 0;
	}
	public Orderitem(Food food,Order order)
	{
		this.orderitemAmount = 1;
		this.order = order;
		this.food = food;
		this.orderitemStatus = 0;//为确认
	}
	public Orderitem(Order order,Food food)
	{
		this.orderitemAmount = 1;
		this.order = order;
		this.food = food;
		this.orderitemStatus = 0;//为确认
		this.orderitemPrice = food.getRealPrice();
		if(food.getSpecial() !=  null)
		{
			this.orderitemOwner = 1;//表订单项收款方式公司
		}
		else
		{
			this.orderitemOwner = 0;
		}
	}

	public Integer getOrderitemId() {
		return this.orderitemId;
	}

	public int getOrderitemAmount() {
		return this.orderitemAmount;
	}

	public void setOrderitemAmount(int orderitemAmount) {
		this.orderitemAmount = orderitemAmount;
	}

	public Byte getOrderitemOwner() {
		return this.orderitemOwner;
	}

	public void setOrderitemOwner(Byte orderitemOwner) {
		this.orderitemOwner = orderitemOwner;
	}

	public BigDecimal getOrderitemPrice() {
		return this.orderitemPrice;
	}

	public void setOrderitemPrice(BigDecimal orderitemPrice) {
		this.orderitemPrice = orderitemPrice;
	}

	public Byte getOrderitemStatus() {
		return this.orderitemStatus;
	}

	public void setOrderitemStatus(Byte orderitemStatus) {
		this.orderitemStatus = orderitemStatus;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Food getFood() {
		return this.food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	@Override
	public String toString() {
//		return "123";
		return "Orderitem [orderitemId=" + orderitemId + ", orderitemAmount="
				+ orderitemAmount + ", orderitemOwner=" + orderitemOwner
				+ ", orderitemPrice=" + orderitemPrice + ", orderitemStatus="
				+ orderitemStatus + ", order=" + order.getOrderCode() + ", food=" + food.getFoodName() + "]";
	}

}