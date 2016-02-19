package com.kalpvruksh.company.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kalpvruksh.company.dao.CompanyDAO;
import com.kalpvruksh.company.domain.Company;
import com.kalpvruksh.company.service.CompanyService;

// TODO: Auto-generated Javadoc
/**
 * The Class CompanyServiceImpl.
 */
@Service("companyService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
public class CompanyServiceImpl implements CompanyService{


	/** The company dao. */
	@Autowired
	public CompanyDAO companyDao;
	
	/* (non-Javadoc)
	 * @see com.kalpvruksh.company.service.CompanyService#findCompaniesByIds(java.util.Set)
	 */
	@Override
	public List<Company> findCompaniesByIds(Set<String> ids) {
		final List<Company> lstOfCompany = companyDao.getListOfCompanyByIds(ids);
/*		final List<Company> listOfOrderedCompany = new ArrayList<>();
*/
		/*ids.forEach(companyId ->{
			Optional<Company> result = lstOfCompany.stream().filter(company -> company.getCompanyId().equals(companyId)).findFirst();
			if(result.isPresent()){
				listOfOrderedCompany.add(result.get());
			}
		});*/
		
		return lstOfCompany;
				
	}

	/* (non-Javadoc)
	 * @see com.kalpvruksh.company.service.CompanyService#saveUpdate(java.util.List)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly=false)
	public void saveUpdate(List<Company> companies) {
		companyDao.saveUpdatePOTs(companies);

	}

	/* (non-Javadoc)
	 * @see com.kalpvruksh.company.service.CompanyService#getAllCompanies()
	 */
	@Override
	public List<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		return companyDao.getAllCompanies();
	}
	
	
	


}
