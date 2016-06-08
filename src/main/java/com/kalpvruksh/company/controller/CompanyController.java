package com.kalpvruksh.company.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
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
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<Company> getAllCompanies() {
		return companyService.getAllCompanies();
	}

	/**
	 * Gets the pots.
	 *
	 * @param companyIds
	 *            the company ids
	 * @return the pots
	 */
	@RequestMapping(value = "/read/ids", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public List<Company> getPots(@RequestBody LinkedHashSet<String> companyIds) {
		return companyService.findCompaniesByIds(companyIds);
	}

	/**
	 * Save.
	 *
	 * @param companies
	 *            the companies
	 * @return the list
	 */
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	@ResponseBody
	public List<String> save(@Valid @RequestBody List<Company> companies) {
		companyService.saveUpdate(companies);
		List<String> lstCompanyIds = new ArrayList<String>();
		for (Company company : companies) {
			lstCompanyIds.add(company.getCompanyId());
		}
		return lstCompanyIds;
	}

	/**
	 * Fetch.
	 *
	 * @param id
	 *            the id
	 * @return the list
	 */
	@RequestMapping(value = "/details/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<Company> fetch(@PathVariable("companyId") String id) {
		Set<String> lstCompanyId = new HashSet<>();
		lstCompanyId.add(id);
		return companyService.findCompaniesByIds(lstCompanyId);
	}

	/**
	 * Update company.
	 *
	 * @param company
	 *            the company
	 * @return the string
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseBody
	public String updateCompany(@RequestBody Company company) {
		List<Company> listCompany = new ArrayList<Company>();
		listCompany.add(company);
		companyService.saveUpdate(listCompany);

		return company.getCompanyId();

	}

	@RequestMapping(value = "/testing", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> testing(@RequestParam("card") String card, @RequestParam("mm") String mm,
			@RequestParam("yy") String yy, @RequestParam("cvv") String cvv) {

		WebDriver driver;
		Map<String, String> testData = new HashMap<>();
		driver = new HtmlUnitDriver();
		
		if(card!=null && card.startsWith("4")){
			driver.navigate().to("https://www.vanillavisa.com/home.html?product=giftcard&csrfToken=");
			String strPageTitle = driver.getTitle();
			System.out.println("Page title: - " + strPageTitle);
			// 4847180675236409"
			WebElement nameInputField = driver.findElement(By.id("card"));
			nameInputField.sendKeys(card);
	
			// 07
			WebElement monthInputField = driver.findElement(By.id("mm"));
			monthInputField.sendKeys(mm);
	
			// 23
			WebElement yearInputField = driver.findElement(By.id("yy"));
			yearInputField.sendKeys(yy);
	
			// 271
			WebElement cvvInputField = driver.findElement(By.name("creditCardID"));
			cvvInputField.sendKeys(cvv);
	
			WebElement element = driver.findElement(By.name("go"));
			element.sendKeys(Keys.ENTER);	
			
		}else if(card!=null && card.startsWith("5")){
			driver.navigate().to("https://www.vanillamastercard.com/home.html?locale=en_US&product=giftcard&csrfToken=");
			String strPageTitle = driver.getTitle();
			System.out.println("Page title: - " + strPageTitle);
			// 4847180675236409"
			WebElement nameInputField = driver.findElement(By.id("card"));
			nameInputField.sendKeys(card);
	
			// 07
			WebElement monthInputField = driver.findElement(By.id("expiryMonth"));
			monthInputField.sendKeys(mm);
	
			// 23
			WebElement yearInputField = driver.findElement(By.id("expiryYear"));
			yearInputField.sendKeys(yy);
	
			// 271
			WebElement cvvInputField = driver.findElement(By.name("creditCardID"));
			cvvInputField.sendKeys(cvv);
			
			WebElement element = driver.findElement(By.name("go"));
			element.sendKeys(Keys.ENTER);

			
		}
		try{
			WebElement tableElement = driver.findElement(By.className("reportTable"));
			java.util.List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
			for (WebElement row : rows) {
				java.util.List<WebElement> cols = row.findElements(By.tagName("td"));
				for (WebElement col : cols) {
					testData.put(col.getText().split(":")[0], col.getText().split(":")[1]);
				}
			}
	
			WebElement avlBalance = driver.findElement(By.xpath("//td[.='Available Gift Card Balance']/../td[last()]"));
			testData.put("Available Gift Card Balance", avlBalance.getText());
		}catch(Exception e){
			System.out.println(e);
		}

		driver.quit();

		return testData;
	}

	/**
	 * Handle exception.
	 *
	 * @param e
	 *            the e
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
	 * @param e
	 *            the e
	 * @return the string
	 */
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String handleException(Exception e) {
		return e.getMessage();
	}

}
