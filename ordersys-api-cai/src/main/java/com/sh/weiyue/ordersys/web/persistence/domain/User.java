package com.sh.weiyue.ordersys.web.persistence.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer userId;

	@Column(name="user_account")
	private String userAccount;

	@Column(name="user_name")
	private String userName;

	@Column(name="user_passwd")
	private String userPasswd;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="user")
	private List<Order> orders = new ArrayList<Order>();

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="user_role")
	private Role role;

	public User() {
	}

	
	public User(String userAccount, String userName, String userPasswd,
			Role role) {
		this.userAccount = userAccount;
		this.userName = userName;
		this.userPasswd = userPasswd;
		this.role = role;
	}


	public Integer getUserId() {
		return this.userId;
	}


	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPasswd() {
		return this.userPasswd;
	}

	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userAccount=" + userAccount
				+ ", userName=" + userName + ", userPasswd=" + userPasswd + ", role=" +role.getRoleName() +  "]";
	}

	
}