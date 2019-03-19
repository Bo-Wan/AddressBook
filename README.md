# ReeceTech Code Challenge: Address Book Application
## 1 Key Design and Implementation Nodes:
* The address book entry is named "Customer".
* To enable "search set of entries in multiple address books", optional "tags" feature are implemented for identifying 
different types of entries, and supporting user story "Users should be able to retireve a unique set of all contacts
across multiple address books", i.e.: the implementation can assign tags to users, and retrieve all users that has same 
tag.
* HATEOAS is used for APIs.
* Test cases are ommited but can be done for an extra.
* H2 in-memory database is used as per requirement, and can be migrated to a "real" database seamlessly.

---

## 2 Running the app
### 2.1 Framework, JDK and Dependency
This is a Spring Boot Java application using Java 8 and Maven

### 2.2 Building and running the app
```
$ mvn spring-boot:run
```

---

## 3 Testing the RESTful endpoints
### 3.1 Retrieve
#### Retrieve all Address Books
```
$ curl http://localhost:8080/addressBooks
```

#### Retrieve all Customers
```
$ curl http://localhost:8080/customers
```

#### Retrieve Customers that has certain Tags (across all Address Books)
```
$ curl http://localhost:8080/tags/1/customers
```

#### Retrieve Customers by ID
```
$ curl http://localhost:8080/customers/1
```

#### Retrieve all Addresses
```
$ curl http://localhost:8080/addresses
```

#### Retrieve all Tags
```
curl http://localhost:8080/tags   
```

### 3.2 Delete
#### Delete Customer
```
$ curl http://localhost:8080/customers
$ curl -X DELETE http://localhost:8080/customers/1
$ curl -X DELETE http://localhost:8080/customers/2
$ curl -X DELETE http://localhost:8080/customers/3
$ curl -X DELETE http://localhost:8080/customers/4
$ curl http://localhost:8080/customers
```

### 3.3 Create
#### Create Address
```
$ curl -i -X POST -H "Content-Type:application/json" -d '{"addressLine1": "test address line 1", "addressLine2": "test address line 2", "suburb": "test suburb", "state": "VIC", "postCode": "test post code"}' http://localhost:8080/addresses
$ curl http://localhost:8080/addresses
```

#### Create Customer
```
$ curl -i -X POST -H "Content-Type:application/json" -d '{"firstName": "test first name", "lastName": "test last name", "phoneNumber": "test phone number", "addressBook": "http://localhost:8080/addressBooks/1", "address": "http://localhost:8080/addresses/3"}' http://localhost:8080/customers
$ curl http://localhost:8080/customers
```