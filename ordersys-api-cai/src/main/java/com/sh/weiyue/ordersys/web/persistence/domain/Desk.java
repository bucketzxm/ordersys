package com.sh.weiyue.ordersys.web.persistence.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the desk database table.
 * 
 */
@Entity
@NamedQuery(name="Desk.findAll", query="SELECT d FROM Desk d")
public class Desk implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="desk_num")
	private Integer deskNum;


	public Integer getDeskNum() {
		return deskNum;
	}

	public void setDeskNum(Integer deskNum) {
		this.deskNum = deskNum;
	}

	public Desk() {
	}
	
	@Override
	public String toString() {
		return "Desk [deskId=" + deskNum + "]";
	}
}