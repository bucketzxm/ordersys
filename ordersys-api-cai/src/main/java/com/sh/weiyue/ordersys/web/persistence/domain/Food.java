package com.sh.weiyue.ordersys.web.persistence.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the food database table.
 * 
 */
@Entity
@NamedQuery(name="Food.findAll", query="SELECT f FROM Food f")
public class Food implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="food_id")
	private Integer foodId;

	@Column(name="food_description")
	private String foodDescription;

	@Column(name="food_name")
	private String foodName;

	@Column(name="food_picture")
	private String foodPicture;

	@Column(name="food_price")
	private BigDecimal foodPrice;
	
	@Column(name="food_score")
	private BigDecimal foodScore;
    
	public BigDecimal getFoodScore() {
		return foodScore;
	}

	public void setFoodScore(BigDecimal food_score) {
		this.foodScore = food_score;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy="food")
	private List<Menuitem> menuitems = new ArrayList<Menuitem>();
	
	@OneToOne(mappedBy="food",cascade={CascadeType.REFRESH,CascadeType.MERGE,CascadeType.REFRESH})  
	private Special special;
	
	public List<Menuitem> getMenuitems() {
		return menuitems;
	}

	public void setMenuitems(List<Menuitem> menuitems) {
		this.menuitems = menuitems;
	}
	
	public Special getSpecial() {
		return special;
	}

	public void setSpecial(Special special) {
		this.special = special;
	}

	public Food() {
	}

	public Food(String foodName, BigDecimal foodPrice) {
		this.foodName = foodName;
		this.foodPrice = foodPrice;
	}

	public Food(String foodName, BigDecimal foodPrice, String foodPicture,
			String foodDescription) {
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodPicture = foodPicture;
		this.foodDescription = foodDescription;
	}

	public Food(String foodName, BigDecimal foodPrice, String foodDescription) {
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodDescription = foodDescription;
	}


	public Integer getFoodId() {
		return this.foodId;
	}

	public String getFoodDescription() {
		return this.foodDescription;
	}

	public void setFoodDescription(String foodDescription) {
		this.foodDescription = foodDescription;
	}

	public String getFoodName() {
		return this.foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodPicture() {
		return this.foodPicture;
	}

	public void setFoodPicture(String foodPicture) {
		this.foodPicture = foodPicture;
	}

	public BigDecimal getFoodPrice() {
		return this.foodPrice;
	}

	public void setFoodPrice(BigDecimal foodPrice) {
		this.foodPrice = foodPrice;
	}
	
	public BigDecimal getRealPrice() {//获得当前的最低价，若有优惠则取优惠价
		BigDecimal min = this.foodPrice;
		if(this.menuitems != null)
			if(this.menuitems.get(0).getMenuitemBigsale().compareTo(new BigDecimal(0)) >= 0)
			{
				min = this.menuitems.get(0).getMenuitemBigsale();
			}
		if(this.special != null)
			if(this.special.getSpecialPrice().compareTo(min) < 0)
			{
				min = this.special.getSpecialPrice();
			}
		return min;
	}

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodDescription="
				+ foodDescription + ", foodName=" + foodName + ", foodPicture="
				+ foodPicture + ", foodPrice=" + foodPrice + "]";
	}
	
    public String getFormatName()
    {
    	if( foodName.length() <= 6 )
    		return foodName;
		return foodName.substring(0, 6);
    }
    
    //获得该食物在当前订单中的数量
    //public int getCurrentOrderAmount()

}












