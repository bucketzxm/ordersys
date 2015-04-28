package com.sh.weiyue.ordersys.web.persistence.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sh.weiyue.ordersys.web.persistence.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	public Category findByCategoryName(String categoryName);
}
