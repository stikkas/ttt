package com.gieman.tttracker.service;

import com.gieman.tttracker.dao.UserDao;
import com.gieman.tttracker.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author stikkas<stikkas@yandex.ru>
 */
public class AbstractService {

	final protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	protected UserDao userDao;

	protected final String USER_INVALID = "Not a valid user";
	protected final String USER_NOT_ADMIN = "Not an admin user";

	protected boolean isValidUser(String username) {
		User user = userDao.findByUsername(username);
		return user != null;
	}
}
