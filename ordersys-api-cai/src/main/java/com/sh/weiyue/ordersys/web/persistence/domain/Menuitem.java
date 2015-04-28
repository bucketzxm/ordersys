package com.sh.weiyue.ordersys.web.persistence.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the menuitem database table.
 * 
 */
@Entity
@NamedQuery(name="Menuitem.findAll", query="SELECT m FROM Menuitem m")
public class Menuitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="menuitem_id")
	private Integer menuitemId;

	@Column(name="menuitem_bigsale")
	private BigDecimal menuitemBigsale;

	@Column(name="menuitem_status")
	private byte menuitemStatus;

	//uni-directional many-to-one association to Food
	@ManyToOne
	@JoinColumn(name="menuitem_food")
	private Food food;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="menuitem_category")
	private Category category;

	public Menuitem() {
	}

	public Menuitem(Food food, Category category) {
		this.food = food;
		this.category = category;
		this.menuitemBigsale = new BigDecimal(-1);
		this.menuitemStatus = 1;
	}

	public Menuitem(BigDecimal menuitemBigsale, Food food, Category category) {
		this.menuitemBigsale = menuitemBigsale;
		this.food = food;
		this.category = category;
		this.menuitemStatus = 1;
	}

	public Integer getMenuitemId() {
		return this.menuitemId;
	}

	public BigDecimal getMenuitemBigsale() {
		return this.menuitemBigsale;
	}

	public void setMenuitemBigsale(BigDecimal menuitemBigsale) {
		this.menuitemBigsale = menuitemBigsale;
	}

	public byte getMenuitemStatus() {
		return this.menuitemStatus;
	}

	public void setMenuitemStatus(byte menuitemStatus) {
		this.menuitemStatus = menuitemStatus;
	}

	public Food getFood() {
		return this.food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Menuitem [menuitemId=" + menuitemId + ", menuitemBigsale="
				+ menuitemBigsale + ", menuitemStatus=" + menuitemStatus
				+ ", food=" + food.getFoodName() + ", category=" + category.getCategoryName() + "]";
	}

}