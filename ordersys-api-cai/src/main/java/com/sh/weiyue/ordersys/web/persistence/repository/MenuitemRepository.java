package com.sh.weiyue.ordersys.web.persistence.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sh.weiyue.ordersys.web.persistence.domain.Menuitem;

public interface MenuitemRepository extends JpaRepository<Menuitem, Integer> {

	//public List<Menuitem> findByCategory(Category category);
	public List<Menuitem> findByMenuitemBigsaleLessThan(BigDecimal menuitemBigsale);
	public List<Menuitem> findByMenuitemBigsaleGreaterThan(BigDecimal menuitemBigsale);
	public List<Menuitem> findByMenuitemStatus(byte menuitemStatus);
}
