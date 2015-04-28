package com.sh.weiyue.ordersys.web.persistence.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sh.weiyue.ordersys.web.persistence.domain.Agent;

public interface AgentRepository extends JpaRepository<Agent, Integer> {
	public List<Agent> findByAgentMoneyGreaterThan(BigDecimal agentMoney);
}
