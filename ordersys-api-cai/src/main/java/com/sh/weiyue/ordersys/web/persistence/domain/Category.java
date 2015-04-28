package com.sh.weiyue.ordersys.web.persistence.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_id")
	private Integer categoryId;

	@Column(name="category_name")
	private String categoryName;
	
	@Column(name="category_picture")
	private String categoryPicture;

	//bi-directional many-to-one association to Menuitem
	@OneToMany(fetch = FetchType.EAGER, mappedBy="category")
	private List<Menuitem> menuitems = new ArrayList<Menuitem>();
	
	

	public Category() {
	}
	
	public Category(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public Category(String categoryName, List<Menuitem> menuitems) {
		this.categoryName = categoryName;
		this.menuitems = menuitems;
	}


	public Integer getCategoryId() {
		return this.categoryId;
	}


	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryPicture() {
		return categoryPicture;
	}

	public void setCategoryPicture(String categoryPicture) {
		this.categoryPicture = categoryPicture;
	}

	public List<Menuitem> getMenuitems() {
		return this.menuitems;
	}

	public void setMenuitems(List<Menuitem> menuitems) {
		this.menuitems = menuitems;
	}

	public Menuitem addMenuitem(Menuitem menuitem) {
		getMenuitems().add(menuitem);
		menuitem.setCategory(this);

		return menuitem;
	}

	public Menuitem removeMenuitem(Menuitem menuitem) {
		getMenuitems().remove(menuitem);
		menuitem.setCategory(null);

		return menuitem;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName="
				+ categoryName + "]";
	}

}