package com.sh.weiyue.ordersys.web.persistence.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the special database table.
 * 
 */
@Entity
@NamedQuery(name="Special.findAll", query="SELECT s FROM Special s")
public class Special implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="special_id")
	private Integer specialId;

	@Column(name="special_price")
	private BigDecimal specialPrice;

	@Column(name="special_quota")
	private int specialQuota;

	@Column(name="special_remain")
	private int specialRemain;
	
	@Column(name="special_picture")
	private String special_picture;

	//uni-directional many-to-one association to Food
	@ManyToOne
	@JoinColumn(name="special_food")
	private Food food;
	public Special() {
	}

	public Special(BigDecimal specialPrice, int specialQuota,
			int specialRemain, Food food) {
		this.specialPrice = specialPrice;
		this.specialQuota = specialQuota;
		this.specialRemain = specialRemain;
		this.food = food;
	}

	public Integer getSpecialId() {
		return this.specialId;
	}

	public BigDecimal getSpecialPrice() {
		return this.specialPrice;
	}

	public void setSpecialPrice(BigDecimal specialPrice) {
		this.specialPrice = specialPrice;
	}

	public int getSpecialQuota() {
		return this.specialQuota;
	}

	public void setSpecialQuota(int specialQuota) {
		this.specialQuota = specialQuota;
	}

	public int getSpecialRemain() {
		return this.specialRemain;
	}

	public void setSpecialRemain(int specialRemain) {
		this.specialRemain = specialRemain;
	}

	public Food getFood() {
		return this.food;
	}

	public void setFood(Food food) {
		this.food = food;
	}
	
	public String getSpecial_picture() {
		return special_picture;
	}

	public void setSpecial_picture(String special_picture) {
		this.special_picture = special_picture;
	}


	@Override
	public String toString() {
		return "Special [specialId=" + specialId + ", specialPrice="
				+ specialPrice + ", specialQuota=" + specialQuota
				+ ", specialRemain=" + specialRemain + ", food=" + food.getFoodName() + "]";
	}

}