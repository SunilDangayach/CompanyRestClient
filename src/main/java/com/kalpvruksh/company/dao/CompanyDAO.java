package com.kalpvruksh.company.dao;

import java.util.List;
import java.util.Set;

import com.kalpvruksh.company.domain.Company;

/**
 * The Interface CompanyDAO.
 */
public interface CompanyDAO {
	
	/**
	 * Gets the list of company by ids.
	 *
	 * @param ids the ids
	 * @return the list of company by ids
	 */
	@SuppressWarnings("rawtypes")
	List<Company> getListOfCompanyByIds(Set ids);

	/**
	 * Save update po ts.
	 *
	 * @param companies the companies
	 */
	void saveUpdatePOTs(List<Company> companies);
	
	/**
	 * Gets the all companies.
	 *
	 * @return the all companies
	 */
	List<Company> getAllCompanies();

}
