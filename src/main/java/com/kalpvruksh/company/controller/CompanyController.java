package com.kalpvruksh.company.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.kalpvruksh.company.domain.Company;
import com.kalpvruksh.company.service.CompanyService;

/**
 * The Class CompanyController.
 */
@Controller
@RequestMapping(value = "/")
public class CompanyController {

	 /** The company service. */
 	@Autowired
	 private CompanyService companyService;
	
	 /**
 	 * Gets the all companies.
 	 *
 	 * @return the all companies
 	 */
 	@RequestMapping(value = "/allcompanies", method = RequestMethod.GET)
	@ResponseBody
	public List<Company> getAllCompanies(){
		 return companyService.getAllCompanies();
	 }
	    
	 
	/**
	 * Gets the pots.
	 *
	 * @param companyIds the company ids
	 * @return the pots
	 */
	@RequestMapping(value = "/read/ids", method = RequestMethod.POST, produces = "application/json", consumes="application/json" )
	@ResponseBody
    public List<Company> getPots(@RequestBody LinkedHashSet<String> companyIds){
        return companyService.findCompaniesByIds(companyIds);
    }
	 
	 
	/**
	 * Save.
	 *
	 * @param companies the companies
	 * @return the list
	 */
	@RequestMapping(value = "/write", method = RequestMethod.POST)
    @ResponseBody
    public List<String> save(@Valid @RequestBody List<Company> companies) {
      companyService.saveUpdate(companies);
      List<String> lstCompanyIds = new ArrayList<String>();
      for(Company company : companies){
      	lstCompanyIds.add(company.getCompanyId());
      }
      return lstCompanyIds;
     }
    
	/**
	 * Fetch.
	 *
	 * @param id the id
	 * @return the list
	 */
	@RequestMapping(value ="/details/{companyId}" , method=RequestMethod.GET)
	@ResponseBody
    public List<Company> fetch(@PathVariable("companyId") String id) {
		Set<String> lstCompanyId = new HashSet<>();
		lstCompanyId.add(id);
        return companyService.findCompaniesByIds(lstCompanyId);
    }
	
    /**
     * Update company.
     *
     * @param company the company
     * @return the string
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public String updateCompany(@RequestBody Company company){
    	List<Company> listCompany = new ArrayList<Company>();
    	listCompany.add(company);
        companyService.saveUpdate(listCompany);
        
        return company.getCompanyId();

    	
    }

 
    /**
     * Handle exception.
     *
     * @param e the e
     * @return the list
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public List<String> handleException(MethodArgumentNotValidException e) {
        List<String> errors = new ArrayList<>();
        for (ObjectError objectError : e.getBindingResult().getAllErrors()) {
            errors.add(objectError.getDefaultMessage());
        }
        return errors;
    }

    /**
     * Handle exception.
     *
     * @param e the e
     * @return the string
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleException(Exception e) {
    	return e.getMessage();
    }
	 

}
