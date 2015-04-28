package com.sh.weiyue.ordersys.web.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sh.weiyue.ordersys.web.persistence.domain.Desk;

public interface DeskRepository extends JpaRepository<Desk, Integer> {

	
}
