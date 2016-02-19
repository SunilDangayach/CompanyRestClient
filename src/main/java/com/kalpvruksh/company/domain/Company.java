package com.kalpvruksh.company.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * The Class Company.
 */
@Entity
@Table(name = "Company")
public class Company {

	/** The company id. */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String companyId;
	
	/** The company name. */
	@Column(name = "Company_Name", nullable = false,length = 50)
	private String companyName;
	 
	/** The company address. */
	@Column(name = "Company_Address", nullable = false,length = 200)
	private String companyAddress;
	
	/** The company city. */
	@Column(name = "Company_City",  nullable = false,length = 50)
	private String companyCity;
	
	/** The company country. */
	@Column(name = "Company_Country", nullable = false, length = 50)
	private String companyCountry;
	
	/** The company email id. */
	@Column(name = "Company_EmailId",length = 50)
	private String companyEmailId;
	
	/** The phone number. */
	@Column(name = "Phone_Number", length = 10)
	private Long phoneNumber;
	
	/** The list owner. */
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="owner_datails")
	
	private Collection<Owner> listOwner = new ArrayList<>();


	/**
	 * Instantiates a new company.
	 */
	public Company(){
		super();
	}
	
	/**
	 * Instantiates a new company.
	 *
	 * @param companyId the company id
	 * @param companyName the company name
	 * @param companyAddress the company address
	 * @param companyCity the company city
	 * @param companyCountry the company country
	 * @param companyEmailId the company email id
	 * @param phoneNumber the phone number
	 * @param listOwner the list owner
	 */
	public Company(String companyId, String companyName, String companyAddress,
			String companyCity, String companyCountry, String companyEmailId,
			Long phoneNumber, Collection<Owner> listOwner) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.companyCity = companyCity;
		this.companyCountry = companyCountry;
		this.companyEmailId = companyEmailId;
		this.phoneNumber = phoneNumber;
		this.listOwner = listOwner;
	}

	/**
	 * Gets the company id.
	 *
	 * @return the company id
	 */
	public String getCompanyId() {
		return companyId;
	}

	/**
	 * Sets the company id.
	 *
	 * @param companyId the new company id
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	/**
	 * Gets the company name.
	 *
	 * @return the company name
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * Sets the company name.
	 *
	 * @param companyName the new company name
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * Gets the company address.
	 *
	 * @return the company address
	 */
	public String getCompanyAddress() {
		return companyAddress;
	}

	/**
	 * Sets the company address.
	 *
	 * @param companyAddress the new company address
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	/**
	 * Gets the company city.
	 *
	 * @return the company city
	 */
	public String getCompanyCity() {
		return companyCity;
	}

	/**
	 * Sets the company city.
	 *
	 * @param companyCity the new company city
	 */
	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}

	/**
	 * Gets the company country.
	 *
	 * @return the company country
	 */
	public String getCompanyCountry() {
		return companyCountry;
	}

	/**
	 * Sets the company country.
	 *
	 * @param companyCountry the new company country
	 */
	public void setCompanyCountry(String companyCountry) {
		this.companyCountry = companyCountry;
	}

	/**
	 * Gets the company email id.
	 *
	 * @return the company email id
	 */
	public String getCompanyEmailId() {
		return companyEmailId;
	}

	/**
	 * Sets the company email id.
	 *
	 * @param companyEmailId the new company email id
	 */
	public void setCompanyEmailId(String companyEmailId) {
		this.companyEmailId = companyEmailId;
	}

	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public Long getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the new phone number
	 */
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the list owner.
	 *
	 * @return the list owner
	 */
	public Collection<Owner> getListOwner() {
		return listOwner;
	}

	/**
	 * Sets the list owner.
	 *
	 * @param listOwner the new list owner
	 */
	public void setListOwner(Collection<Owner> listOwner) {
		this.listOwner = listOwner;
	}
	
	
	
}
