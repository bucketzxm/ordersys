package com.sh.weiyue.ordersys.web.persistence.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the pay database table.
 * 
 */
@Entity
@NamedQuery(name="Pay.findAll", query="SELECT p FROM Pay p")
public class Pay implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pay_id")
	private Integer payId;

	@Column(name="pay_company")
	private String payCompany;

	@Column(name="pay_merchant")
	private String payMerchant;

	@Column(name="pay_name")
	private String payName;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="pay")
	private List<Order> orders = new ArrayList<Order>();

	public Pay() {
	}

	public Pay(String payName, String payCompany, String payMerchant) {
		this.payName = payName;
		this.payCompany = payCompany;
		this.payMerchant = payMerchant;
	}



	public Integer getPayId() {
		return this.payId;
	}

	public String getPayCompany() {
		return this.payCompany;
	}

	public void setPayCompany(String payCompany) {
		this.payCompany = payCompany;
	}

	public String getPayMerchant() {
		return this.payMerchant;
	}

	public void setPayMerchant(String payMerchant) {
		this.payMerchant = payMerchant;
	}

	public String getPayName() {
		return this.payName;
	}

	public void setPayName(String payName) {
		this.payName = payName;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	@Override
	public String toString() {
		return "Pay [payId=" + payId + ", payCompany=" + payCompany
				+ ", payMerchant=" + payMerchant + ", payName=" + payName + "]";
	}
	
}