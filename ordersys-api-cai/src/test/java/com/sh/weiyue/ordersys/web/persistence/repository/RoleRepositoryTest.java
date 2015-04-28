package com.sh.weiyue.ordersys.web.persistence.repository;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sh.weiyue.ordersys.web.persistence.domain.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class RoleRepositoryTest {

	@Autowired
	RoleRepository repository;
	Role role;
	Logger logger ;

	@Before
	public void setUp() {
		logger = Logger.getRootLogger();
		logger.info("++---------------------------------++");
		role = new Role("test");
	}
	
	@Test
	public void findRoleById(){
		role = repository.save(role);
		Role tRole = repository.findOne(role.getRoleId());
		logger.info(tRole.toString());
		logger.info(role.toString());
		assertEquals("Not equal",role.getRoleName(), tRole.getRoleName());
		logger.info("findOne():completed");
		repository.delete(role);
	}
	
	@Test
	public void findRoleByRoleName(){
		role = repository.save(role);
		Role tRole = repository.findByRoleName("test");
		logger.info(role.toString());
		logger.info(tRole.toString());
		assertEquals("Not equal", role.getRoleId(), tRole.getRoleId());
		logger.info("findByRoleName():completed");
		repository.delete(role);
	}

}
