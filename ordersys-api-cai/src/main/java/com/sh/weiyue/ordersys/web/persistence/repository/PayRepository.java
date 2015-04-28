package com.sh.weiyue.ordersys.web.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sh.weiyue.ordersys.web.persistence.domain.Pay;

public interface PayRepository extends JpaRepository<Pay, Integer> {

	public Pay findByPayName(String payName);
	public List<Pay> findByPayCompany(String payCompany);
	public List<Pay> findByPayMerchant(String payMerchant);
}
