package com.gieman.tttracker.service;

import com.gieman.tttracker.domain.Company;
import com.gieman.tttracker.dto.Result;
import java.util.List;

/**
 *
 * @author stikkas<stikkas@yandex.ru>
 */
public interface CompanyService {

	public Result<Company> store(
			Integer idCompany,
			String companyName,
			String actionUsername);

	public Result<Company> remove(Integer idCompany, String actionUsername);

	public Result<Company> find(Integer idCompany, String actionUsername);

	public Result<List<Company>> findAll(String actionUsername);

}
