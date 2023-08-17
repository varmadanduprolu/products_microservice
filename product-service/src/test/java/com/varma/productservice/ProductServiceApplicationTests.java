package com.varma.productservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
//@Testcontainers
class ProductServiceApplicationTests {

//	@Container
//	static PostgreSQLContainer postgreSQLContainer=new PostgreSQLContainer<>("postgres:latest")
//			.withDatabaseName("my db")
//			.withUsername("postgres")
//			.withPassword("1729");
//
//	@DynamicPropertySource
//	static void setProperities(DynamicPropertyRegistry registry){
//	 	registry.add("spring.datasource.url",postgreSQLContainer::getJdbcUrl);
//		 registry.add("spring.datasource.username",postgreSQLContainer::getUsername);
//		 registry.add("spring.datasource.password",postgreSQLContainer::getPassword);
//	}

	@Test
	void shouldCreateProduct() {

	}

}
