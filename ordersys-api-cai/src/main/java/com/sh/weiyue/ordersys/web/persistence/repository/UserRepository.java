package com.sh.weiyue.ordersys.web.persistence.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sh.weiyue.ordersys.web.persistence.domain.Role;
import com.sh.weiyue.ordersys.web.persistence.domain.User;

public interface UserRepository  extends JpaRepository<User, Integer>{

	public User findByUserAccount(String userAcount);
	public List<User> findByRole(Role role);
}
