package com.sh.weiyue.ordersys.web.persistence.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private int roleId;

	@Column(name="role_name")
	private String roleName;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="role")
	private List<User> users = new ArrayList<User>();

	public Role() {
	}

	public Role(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<User> getUsers() {
		return this.users;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
}