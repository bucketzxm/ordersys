package com.sh.weiyue.ordersys.web.persistence.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the order database table.
 * 
 */
@Entity
@Table(catalog="order_sys")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private Integer orderId;
	
	@Column(name="out_trade_no")
	private String out_trade_no;
	
	@Column(name="order_code")
	private String orderCode;

	@Column(name="order_commoney")
	private BigDecimal orderCommoney;

	@Column(name="order_finishdate")
	private String orderFinishdate;
 
	@Column(name="order_generatedate")
	private String orderGeneratedate;

	@Column(name="order_mermoney")
	private BigDecimal orderMermoney;

	@Column(name="order_state")
	private String orderState;
	
	@Column(name="order_isSent")
	private Boolean orderIsSent;

	@Column(name="order_personNum")
	private Integer orderPersonNum;
	
	@Column(name="order_deskId")
	private Integer orderDeskId;
	
	@Column(name="order_isWaiterConfirm")
	private Integer isWaiterConfirm;
	
	@Column(name="order_isHumanPay")
	private Integer isHumanPay;

	public Integer getIsWaiterConfirm() {
		return isWaiterConfirm;
	}

	public void setIsWaiterConfirm(Integer isWaiterConfirm) {
		this.isWaiterConfirm = isWaiterConfirm;
	}

	public Integer getIsHumanPay() {
		return isHumanPay;
	}

	public void setIsHumanPay(Integer isHumanPay) {
		this.isHumanPay = isHumanPay;
	}
	
	//bi-directional many-to-one association to Pay
	@ManyToOne
	@JoinColumn(name="order_pay")
	private Pay pay;


	//bi-directional many-to-one association to User,对应于订单操作人，在线支付的收银员设置为robot，手工支付的收银员设置为当前收银的人员
	@ManyToOne
	@JoinColumn(name="order_user")
	private User user;

	//bi-directional many-to-one association to Orderitem
	@OneToMany(fetch = FetchType.EAGER, mappedBy="order" ,cascade = CascadeType.ALL)
	private List<Orderitem> orderitems = new ArrayList<Orderitem>();

	public Order() {
	}
	
	public Order( Integer deskId,Integer orderPersonNum) {
		this.orderDeskId = deskId;
		this.orderGeneratedate = new Date().toLocaleString();
		this.orderState="TRADE_NOT_PAID";//订单刚开始创建，状态为“未付款”
		this.orderPersonNum = orderPersonNum;
		this.orderIsSent = false;
	}
	
	public Order(String orderCode, BigDecimal orderCommoney,
			String orderGeneratedate, BigDecimal orderMermoney, Integer deskId) {
		this.orderCode = orderCode;
		this.orderCommoney = orderCommoney;
		this.orderGeneratedate = orderGeneratedate;
		this.orderFinishdate = null;
		this.orderMermoney = orderMermoney;
		this.orderDeskId = deskId;
		this.orderState = "TRADE_NOT_PAID";
		this.orderIsSent = false;
		this.pay = null;
		this.user = null;
	}
	
	
	public Integer getOrderId() {
		return this.orderId;
	}
	
	public String getOutTradeNo(){
		return this.out_trade_no;
	}
	public void setOutTradeNum(String otn){
		this.out_trade_no = otn;
	}

	public String getOrderCode() {
		return this.orderCode;
	}

	public BigDecimal getOrderCommoney() {
		return this.orderCommoney;
	}

	public void setOrderCommoney(BigDecimal orderCommoney) {
		this.orderCommoney = orderCommoney;
	}

	public String getOrderFinishdate() {
		return this.orderFinishdate;
	}

	public void setOrderFinishdate(String orderFinishdate) {
		this.orderFinishdate = orderFinishdate;
	}
	
	public Boolean getOrderIsSent() {
		return orderIsSent;
	}

	public void setOrderIsSent(Boolean orderIsSent) {
		this.orderIsSent = orderIsSent;
	}

	public String getOrderGeneratedate() {
		return this.orderGeneratedate;
	}

	public void setOrderGeneratedate(String orderGeneratedate) {
		this.orderGeneratedate = orderGeneratedate;
	}

	public BigDecimal getOrderMermoney() {
		return this.orderMermoney;
	}

	public void setOrderMermoney(BigDecimal orderMermoney) {
		this.orderMermoney = orderMermoney;
	}

	public String getOrderState() {
		return this.orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public Pay getPay() {
		return this.pay;
	}

	public void setPay(Pay pay) {
		this.pay = pay;
	}

	public Integer getOrderDeskId() {
		return orderDeskId;
	}

	public void setOrderDeskId(Integer orderDeskId) {
		this.orderDeskId = orderDeskId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Orderitem> getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(List<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}

	public Orderitem addOrderitem(Orderitem orderitem) {
		getOrderitems().add(orderitem);
		orderitem.setOrder(this);

		return orderitem;
	}

	public Orderitem removeOrderitem(Orderitem orderitem) {
		getOrderitems().remove(orderitem);
		orderitem.setOrder(null);

		return orderitem;
	}
	
	public Integer getOrderPersonNum() {
		return orderPersonNum;
	}

	public void setOrderPersonNum(Integer orderPersonNum) {
		this.orderPersonNum = orderPersonNum;
	}

	@Override
	public String toString() {
		return "Order [idOrder=" + orderId + ", orderCode=" + orderCode
				+ ", orderCommoney=" + orderCommoney + ", orderGeneratedate=" + orderGeneratedate
				+ ", orderFinishdate=" + orderFinishdate + ", orderMermoney=" + orderMermoney + ", orderState="
				+ orderState + ", pay=" + pay.getPayName() + ", deskId=" +  orderDeskId + ", user="
				+ user.getUserName() + ",orderPersonNum="+orderPersonNum+"]";
	}

}