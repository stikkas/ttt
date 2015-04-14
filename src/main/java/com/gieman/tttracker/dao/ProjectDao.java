package com.gieman.tttracker.dao;

import com.gieman.tttracker.domain.Project;
import java.util.List;

/**
 *
 * @author Благодатских С.
 */
public interface ProjectDao extends GenericDao<Project, Integer> {

	List<Project> findAll();

}
