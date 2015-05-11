package com.gieman.tttracker.dao;

import com.gieman.tttracker.domain.Company;
import com.gieman.tttracker.domain.Project;
import java.util.List;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
import org.junit.Test;

/**
 *
 * @author stikkas<stikkas@yandex.ru>
 */
public class ProjectDaoTest extends AbstractDaoForTesting {

	@Test
	public void findAllTest() {
		List<Project> projects = projectDao.findAll();
		assertNotNull(projects);
		assertTrue(projects.size() > 0);
		assertTrue(projects.size() == countRowsInTable("ttt_project"));
	}

	@Test
	public void findTest() {
		Project p = projectDao.find(1);
		assertNotNull(p);
		assertTrue(p.getId() == 1);
	}

	@Test
	public void persistTest() {
		Project p = new Project();
		List<Company> companies = companyDao.findAll();
		if (companies.isEmpty()) {
			fail("Not found any company");
		}
		p.setCompany(companies.get(0));
		p.setProjectName("New project");
		projectDao.persist(p);
		assertNotNull(p.getId());
	}

	@Test
	public void mergeTest() {
		Project p = projectDao.findAll().get(0);
		String name = p.getProjectName();
		p.setProjectName("New Name");
		projectDao.merge(p);
		assertFalse(p.getProjectName().equals(name));
		assertTrue(p.getProjectName().equals("New Name"));
	}

	public void removeTest() {
		int size = countRowsInTable("ttt_project");
		Project p = projectDao.find(1);
		projectDao.remove(p);
		assertFalse(size == countRowsInTable("ttt_project"));
	}
}
