package com.kalpvruksh.company.dao.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.kalpvruksh.company.dao.CompanyDAO;
import com.kalpvruksh.company.domain.Company;

/**
 * The Class CompanyDaoImpl.
 */
@Repository("companyDao")
public class CompanyDaoImpl implements CompanyDAO{

	/** The entity manager. */
	@PersistenceContext
    private EntityManager entityManager;

 

	/* (non-Javadoc)
	 * @see com.kalpvruksh.company.dao.CompanyDAO#getListOfCompanyByIds(java.util.Set)
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public List<Company> getListOfCompanyByIds(@SuppressWarnings("rawtypes") Set ids) {
        Query getPotsQuery = entityManager.createQuery("from Company where companyId in (:ids)");
        getPotsQuery.setParameter("ids", ids);
        return getPotsQuery.<Company>getResultList();
    }

	/* (non-Javadoc)
	 * @see com.kalpvruksh.company.dao.CompanyDAO#saveUpdatePOTs(java.util.List)
	 */
	@Override
	public void saveUpdatePOTs(List<Company> companies) {
		String id;
        Company companyObj;
        boolean isPresent = false;
        for(Company company : companies){
        	id = company.getCompanyId();
            if(id != null) {
            	companyObj = entityManager.find(Company.class, id);
                isPresent = true;
            } else {
            	companyObj = new Company();
            }
            companyObj.setCompanyAddress(company.getCompanyAddress());
            companyObj.setCompanyCity(company.getCompanyCity());
            companyObj.setCompanyName(company.getCompanyName());
            companyObj.setCompanyCountry(company.getCompanyCountry());
            companyObj.setCompanyEmailId(company.getCompanyEmailId());
            companyObj.setListOwner(company.getListOwner());
            companyObj = entityManager.merge(companyObj);
            if(!isPresent) {
            	company.setCompanyId(companyObj.getCompanyId());
                entityManager.merge(company);
                }
        	}
         }

	/* (non-Javadoc)
	 * @see com.kalpvruksh.company.dao.CompanyDAO#getAllCompanies()
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public List<Company> getAllCompanies() {
        Query getPotsQuery = entityManager.createQuery("from Company");
        return getPotsQuery.<Company>getResultList();
        //later we can use batches here.

	}
	
}

