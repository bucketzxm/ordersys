package com.sh.weiyue.ordersys.web.persistence.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sh.weiyue.ordersys.web.persistence.domain.Food;

public interface FoodRepository extends JpaRepository<Food, Integer> {

	public Food findByFoodName(String foodName);
	public List<Food> findByFoodPriceBetween(BigDecimal bottom, BigDecimal top);
}
