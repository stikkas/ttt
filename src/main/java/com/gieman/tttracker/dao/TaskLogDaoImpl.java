package com.gieman.tttracker.dao;

import com.gieman.tttracker.domain.Task;
import com.gieman.tttracker.domain.TaskLog;
import com.gieman.tttracker.domain.User;
import java.util.Date;
import java.util.List;
import javax.persistence.TemporalType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Благодатских С.
 */
@Repository("taskLogDao")
@Transactional
public class TaskLogDaoImpl extends GenericDaoImpl<TaskLog, Integer>
		implements TaskLogDao {

	public TaskLogDaoImpl() {
		super(TaskLog.class);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<TaskLog> findByUser(User user, Date startDate, Date endDate) {
		return em.createNamedQuery("TaskLog.findByUser")
				.setParameter("user", user)
				.setParameter("startDate", startDate, TemporalType.DATE)
				.setParameter("endDate", endDate, TemporalType.DATE)
				.getResultList();
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public long findTaskLogCountByTask(Task task) {
		return em.createNamedQuery("TaskLog.findTaskLogCountByTask", Long.class)
				.setParameter("task", task)
				.getSingleResult();
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public long findTaskLogCountByUser(User user) {
		return em.createNamedQuery("TaskLog.findTaskLogCountByUser", Long.class)
				.setParameter("task", user)
				.getSingleResult();
	}

}
