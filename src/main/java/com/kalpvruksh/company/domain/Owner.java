package com.kalpvruksh.company.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class Owner.
 */
@Embeddable
public class Owner {
	
	/** The owner name. */
	@Column(name = "Owner_Name")
	private String ownerName;
	
	/** The owner address. */
	@Column(name = "Owner_Address")
	private String ownerAddress;
	
	
	/**
	 * Gets the owner name.
	 *
	 * @return the owner name
	 */
	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * Instantiates a new owner.
	 */
	public Owner() {
		super();
	}

	/**
	 * Instantiates a new owner.
	 *
	 * @param ownerName the owner name
	 * @param ownerAddress the owner address
	 */
	public Owner(String ownerName, String ownerAddress) {
		super();
		
		this.ownerName = ownerName;
		this.ownerAddress = ownerAddress;
		
	}

	/**
	 * Sets the owner name.
	 *
	 * @param ownerName the new owner name
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
  
	
	/**
	 * Instantiates a new owner.
	 *
	 * @param ownerName the owner name
	 */
	public Owner(String ownerName) {
		this(ownerName, null);
	}

	/**
	 * Gets the owner address.
	 *
	 * @return the owner address
	 */
	public String getOwnerAddress() {
		return ownerAddress;
	}

	/**
	 * Sets the owner address.
	 *
	 * @param ownerAddress the new owner address
	 */
	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}


}
