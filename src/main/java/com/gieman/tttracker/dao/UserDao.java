package com.gieman.tttracker.dao;

import com.gieman.tttracker.domain.User;
import java.util.List;

/**
 *
 * @author Благодатских С.
 */
public interface UserDao extends GenericDao<User, String> {

	List<User> findAll();

	User findByUsernamePassword(String username, String password);

	User findByUsername(String username);

	User findByEmail(String email);

}
