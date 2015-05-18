package com.gieman.tttracker.service;

import com.gieman.tttracker.domain.Task;
import com.gieman.tttracker.dto.Result;
import java.util.List;

/**
 *
 * @author stikkas<stikkas@yandex.ru>
 */
public interface TaskService {

	public Result<Task> store(
			Integer idTask,
			Integer idProject,
			String taskName,
			String actionUsername);

	public Result<Task> remove(Integer idTask, String actionUsername);

	public Result<Task> find(Integer idTask, String actionUsername);

	public Result<List<Task>> findAll(String actionUsername);

}
