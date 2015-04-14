package com.gieman.tttracker.dao;

import com.gieman.tttracker.domain.Company;
import java.util.List;

/**
 *
 * @author Благодатских С.
 */
public interface CompanyDao extends GenericDao<Company, Integer> {

	List<Company> findAll();

}
