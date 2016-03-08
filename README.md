# CompanyRestClient
This to perform CRUD operations on company object.

1. To Create the new Company.
	URL - localhost:8090/company-operations-service/write
	
	Request Type - POST
	
	Sample Data Input -	[{"companyId":null,"companyName":"Kalpvruksh","companyAddress":"INDIA","companyCity":"DenMark","companyCountry":"Europe","companyEmailId":"test@test.com","phoneNumber":null,"listOwner":[{"ownerId":null,"ownerName":"Sunil","ownerAddress":"testl","company":"test"},{"ownerId":null,"ownerName":"Kalpesh","ownerAddress":"test","company":"test"}]]

	Sample Data Output -
	[8a5f27cd52e64ac10152e64b38b00000]
In this we can pass list of company at a single time, It will return us newly crated company Ids.


2. Get company details by comapany ID.
	URL - localhost:8090/company-operations-service/details/8a5f27cd52e64ac10152e64b38b00000
	
	Request Type - GET
	
	Output - 	[{"companyId":"8a5f27cd52e64ac10152e64b38b00000","companyName":"Kalpvruksh","companyAddress":"INDIA","companyCity":"DenMark","companyCountry":"Europe","companyEmailId":"test@test.com","phoneNumber":null,"listOwner":[{"ownerId":"8a5f27cd52e64ac10152e64b38b01212","ownerName":"Sunil","ownerAddress":"testl","company":"test"},{"ownerId":"8a5f27cd52e64acasdfadsf64b38b00000","ownerName":"Kalpesh","ownerAddress":"test","company":"test"}]]
	
3. Get company details by List of Comapny Ids.
	URL - localhost:8090/company-operations-service/read/ids
	
	Request Type - POST
	
	Sample Data Input - ["8a5f27cd52e64ac10152e64c042e0001","8a5f27cd52e64ac10152e64b38b00000"]

	Sample Data Output - It will show the details of both of id in the JSON format.
	

4. To Update the company Details/ Company owner details / Add new owner.

	URL - localhost:8090/company-operations-service/update
	
	Request Type - PUT.
	
	Sample Data Input - {"companyId":"8a5f27cd52e64ac10152e64b38b00000","companyName":"Kalpvruksh","companyAddress":"INDIA","companyCity":"DenMark","companyCountry":"Europe","companyEmailId":"test@test.com","phoneNumber":null,"listOwner":[{"ownerId":"8a5f27cd52e64ac10152e64b38b01212","ownerName":"Sunil","ownerAddress":"testl","company":"test"},{"ownerId":"8a5f27cd52e64acasdfadsf64b38b00000","ownerName":"Kalpesh","ownerAddress":"test","company":"test"}]
	
	sample Data output - 
	[8a5f27cd52e64ac10152e64b38b00000]
	
5. To Add the new owner.
	We can use this URL - localhost:8090/company-operations-service/update
	Request Type - PUT.
	
	Sample Data Input - {"companyId":"8a5f27cd52e64ac10152e64b38b00000","companyName":"Kalpvruksh","companyAddress":"INDIA","companyCity":"DenMark","companyCountry":"Europe","companyEmailId":"test@test.com","phoneNumber":null,"listOwner":[{"ownerId":"8a5f27cd52e64ac10152e64b38b01212","ownerName":"Sunil","ownerAddress":"testl","company":"test"},{"ownerId":"8a5f27cd52e64acasdfadsf64b38b00000","ownerName":"Kalpesh","ownerAddress":"test","company":"test"}]
	
	sample Data output - 
	[8a5f27cd52e64ac10152e64b38b00000]
	
	[{"companyId":"8a5f27cd52e64ac10152e64b38b00000","companyName":"Kalpvruksh","companyAddress":"INDIA","companyCity":"DenMark","companyCountry":"Europe","companyEmailId":"test@test.com","phoneNumber":null,"listOwner":[{"ownerId":"8a5f27cd52e64ac10152e64b38b01212","ownerName":"Sunil","ownerAddress":"testl","company":"test"},{"ownerId":"8a5f27cd52e64acasdfadsf64b38b00000","ownerName":"Kalpesh","ownerAddress":"test","company":"test"}]]
	
6. To get all the companies.
	URL - localhost:8090/company-operations-service/allcompanies
	
	Request Type - GET
	
7. Swagger UI URL http://localhost:8090/company-operations-service/swagger-ui.html
	
Database Setup
-------------------------------

1. We are using postgres open source database for database setup.
2. To setup the new data base we just need to edit the file src/main/resources/company-db.properties
	contents of the file.
		company.hibernate.dialect=org.hibernate.spatial.dialect.postgis.PostgisDialect
		company.hibernate.hbm2ddl.auto=update
		company.jdbc.driver=org.postgresql.Driver
		company.jdbc.url=jdbc:postgresql://localhost:5434/postgres
		company.jdbc.username=drivemetadata
		company.jdbc.password=password
	Please change the configuration as per the database.
	
Future Implementation
--------------------------------------------
1. Will implement the HATEOS in it.
2. Batch execution in Queries.
3. Sort the multiple list as per the client requirement.
4. Authentication


