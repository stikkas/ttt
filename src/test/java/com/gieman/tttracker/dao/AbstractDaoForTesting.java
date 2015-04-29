package com.gieman.tttracker.dao;

import com.gieman.tttracker.ConfigApp;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfigApp.class)
public abstract class AbstractDaoForTesting extends AbstractTransactionalJUnit4SpringContextTests {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired(required = true)
	protected CompanyDao companyDao;

	@Autowired(required = true)
	protected ProjectDao projectDao;

	@Autowired(required = true)
	protected TaskDao taskDao;

	@Autowired(required = true)
	protected UserDao userDao;

	@Autowired(required = true)
	protected TaskLogDao taskLogDao;

}
