package com.gieman.tttracker.service;

import com.gieman.tttracker.domain.Project;
import com.gieman.tttracker.dto.Result;
import java.util.List;

/**
 *
 * @author stikkas<stikkas@yandex.ru>
 */
public interface ProjectService {

	public Result<Project> store(
			Integer idProject,
			Integer idCompany,
			String projectName,
			String actionUsername);

	public Result<Project> remove(Integer idProject, String actionUsername);

	public Result<Project> find(Integer idProject, String actionUsername);

	public Result<List<Project>> findAll(String actionUsername);

}
