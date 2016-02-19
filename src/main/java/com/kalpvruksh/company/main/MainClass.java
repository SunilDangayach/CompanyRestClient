package com.kalpvruksh.company.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.kalpvruksh.company.domain.Company;
import com.kalpvruksh.company.domain.Owner;

public class MainClass {

	public static void main(String args[]) {

		ObjectMapper mapper = new ObjectMapper();

		Company comp = new Company();
		comp.setCompanyName("Kalpvruksh");
		comp.setCompanyCountry("Europe");
		comp.setCompanyEmailId("test@test.com");
		comp.setPhoneNumber(1231312l);
		comp.setCompanyCity("Mumbai");
		comp.setCompanyAddress("indaia");
		
		Owner owner1 = new Owner("Sunil");
		Owner owner2 = new Owner("Kalpesh");
		List<Owner> lstOwners = new ArrayList<>();
		lstOwners.add(owner1);
		lstOwners.add(owner2);
		comp.setListOwner(lstOwners);



		String jsonInString = null;
		try {
			jsonInString = mapper.writeValueAsString(comp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(jsonInString);

	}

}
