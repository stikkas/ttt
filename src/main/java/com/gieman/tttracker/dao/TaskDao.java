package com.gieman.tttracker.dao;

import com.gieman.tttracker.domain.Task;
import java.util.List;

/**
 *
 * @author Благодатских С.
 */
public interface TaskDao extends GenericDao<Task, Integer> {

	List<Task> findAll();

}
