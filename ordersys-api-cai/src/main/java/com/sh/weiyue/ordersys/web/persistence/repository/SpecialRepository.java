package com.sh.weiyue.ordersys.web.persistence.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sh.weiyue.ordersys.web.persistence.domain.Food;
import com.sh.weiyue.ordersys.web.persistence.domain.Special;

public interface SpecialRepository extends JpaRepository<Special, Integer> {
	
	public List<Special> findBySpecialRemainGreaterThan(int specialRemain, Sort sort);
	public List<Special> findByFood(Food food);
}
