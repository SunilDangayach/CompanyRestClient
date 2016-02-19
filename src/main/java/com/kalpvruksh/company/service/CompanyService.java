package com.kalpvruksh.company.service;

import java.util.List;
import java.util.Set;

import com.kalpvruksh.company.domain.Company;

/**
 * The Interface CompanyService.
 */
public interface CompanyService {
	
    /**
     * Find companies by ids.
     *
     * @param ids the ids
     * @return the list
     */
    List<Company> findCompaniesByIds(Set<String> ids);
    
    /**
     * Save update.
     *
     * @param company the company
     */
    void saveUpdate(List<Company> company);
    
    /**
     * Gets the all companies.
     *
     * @return the all companies
     */
    List<Company> getAllCompanies();



}
