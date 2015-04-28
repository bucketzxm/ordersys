package com.sh.weiyue.ordersys.web.persistence.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sh.weiyue.ordersys.web.persistence.domain.Role;
import com.sh.weiyue.ordersys.web.persistence.domain.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
@Transactional
public class UserRepositoryTest {

	@Autowired
	UserRepository repository;
	
	@Autowired
	RoleRepository roleRepository;
	
	Logger logger ;
	
	User user;
	Role role;

	@Before
	public void setUp() {
		logger = Logger.getRootLogger();
		logger.info("++---------------------------------++");
		role = roleRepository.findOne(1);
		user = new User("test@126.com","test","test",role);
	}
	
	@Test
	public void findByUserAccount(){
		user = repository.save(user);
		User tUser = repository.findByUserAccount("test@126.com");
		logger.info(user);
		logger.info(tUser);
		assertEquals("Not equal", user.getUserId(), tUser.getUserId());
		repository.delete(user);
		logger.info("findByUserAcount():completed");
	}
	
	@Test
	public void findByRole(){
		user = repository.save(user);
		List<User> users = repository.findByRole(role);
		logger.info(user);
		logger.info("Number :" +users.size());
		assertTrue("Not botain", users.contains(user));
		repository.delete(user);
		logger.info("findByRole():completed");
	}
	
}
