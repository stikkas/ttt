package com.gieman.tttracker.dao;

import com.gieman.tttracker.domain.Task;
import com.gieman.tttracker.domain.TaskLog;
import com.gieman.tttracker.domain.User;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Благодатских С.
 */
public interface TaskLogDao extends GenericDao<TaskLog, Integer> {

	List<TaskLog> findByUser(User user, Date startDate,
			Date endDate);

	long findTaskLogCountByTask(Task task);

	long findTaskLogCountByUser(User user);

}
