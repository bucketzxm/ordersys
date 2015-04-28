package com.sh.weiyue.ordersys.web;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sh.weiyue.ordersys.web.persistence.repository.RoleRepository;


public class ApplicationConfigTest {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		assertThat(context, is(notNullValue()));
		assertThat(context.getBean(RoleRepository.class), is(notNullValue()));
	}

}
