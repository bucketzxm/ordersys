package com.sh.weiyue.ordersys.web.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.sh.weiyue.ordersys.web.persistence.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	public Role findByRoleName(String roleName);
	
}
