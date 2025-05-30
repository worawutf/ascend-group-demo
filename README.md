# Getting Started

### Install MySQL
### Connection to DB : 
* Host : <yourhost> (eg., localhost)
* Port : 3306
* User : root
* Password : P@ssw0rd

- Create scheme by :
  * CREATE DATABASE `ascend_test`
- Create Table by :
  * CREATE TABLE `books` (
	  `id` bigint NOT NULL AUTO_INCREMENT,
	  `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
	  `author` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
	  `published_date` datetime(6) DEFAULT NULL,
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
	
### Install Lib
 * mvn clean install
 
### Run API
	Run file >> /ascend-group-demo/src/main/java/ascend/group/demo/DemoApplication.java

### Integration tests.
	Run file >> /ascend-group-demo/src/test/java/ascend/group/demo/controller/BookControllerTest.java
	
### Example API requests and expected responses.
* API Get books by author http://localhost:8080/books?author={author}
* Response Body 
	[
		{
			"id": 1,
			"title": "First book",
			"author": "Worawut F.",
			"publishedDate": "2025-05-30"
		},
		{
			"id": 2,
			"title": "Sec Book",
			"author": "Worawut F.",
			"publishedDate": "2025-05-29"
		},
		{
			"id": 3,
			"title": "Rd. book",
			"author": "Worawut F.",
			"publishedDate": "2025-05-30"
		}
	]
* API Post Create Books http://localhost:8080/books
* Requests Body
	{
		"title": "First book", //Is Require
		"author": "Worawut F.", //Is Require
		"publishedDate": "2025-05-30" //should be a valid date (e.g., >1000 and <= current year)., Format yyyy-MM-dd
	}
* Response Body
	{
		"id": 1,
		"title": "First book",
		"author": "Worawut F.",
		"publishedDate": "2025-05-30"
	}
