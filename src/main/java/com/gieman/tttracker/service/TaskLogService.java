package com.gieman.tttracker.service;

import com.gieman.tttracker.domain.TaskLog;
import com.gieman.tttracker.dto.Result;
import java.util.Date;
import java.util.List;

/**
 *
 * @author stikkas<stikkas@yandex.ru>
 */
public interface TaskLogService {

	public Result<TaskLog> store(
			Integer idTaskLog,
			Integer idTask,
			String username,
			String taskDescription,
			Date taskLogDate,
			int taskMinutes,
			String actionUsername);

	public Result<TaskLog> remove(Integer idTaskLog, String actionUsername);

	public Result<TaskLog> find(Integer idTaskLog, String actionUsername);

	public Result<List<TaskLog>> findByUser(String username, Date startDate, Date endDate, String actionUsername);
}
