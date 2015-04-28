package com.sh.weiyue.ordersys.web.persistence.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the agent database table.
 * 
 */
@Entity
@NamedQuery(name="Agent.findAll", query="SELECT a FROM Agent a")
public class Agent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="agent_id")
	private Integer agentId;

	@Column(name="agent_money")
	private BigDecimal agentMoney;	

	@Column(name="agent_moneyCopy")
	private BigDecimal agentMoneyCopy;

	@Column(name="agent_order")
	private Integer  orderId;

	public Agent() {
	}
	
	
	public BigDecimal getAgentMoneyCopy() {
		return agentMoneyCopy;
	}



	public void setAgentMoneyCopy(BigDecimal agentMoneyCopy) {
		this.agentMoneyCopy = agentMoneyCopy;
	}

	
	public Agent(BigDecimal agentMoney, int orderId) {
		this.agentMoney = agentMoney;
		this.orderId = orderId;
	}



	public Integer getAgentId() {
		return this.agentId;
	}


	public BigDecimal getAgentMoney() {
		return this.agentMoney;
	}

	public void setAgentMoney(BigDecimal agentMoney) {
		this.agentMoney = agentMoney;
	}



	public Integer getOrderId() {
		return orderId;
	}


	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}


	@Override
	public String toString() {
		return "Agent [agentId=" + agentId + ", agentMoney=" + agentMoney
				+ ", orderId=" + orderId + "]";
	}

}