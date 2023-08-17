package com.varma.inventoryservice;

import com.varma.inventoryservice.entity.Inventory;
import com.varma.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
//		return args -> {
//			Inventory inventory=new Inventory();
//			inventory.setSkuCode("iphone_14");
//			inventory.setQuantity(100);
//
//			Inventory inventory1=new Inventory();
//			inventory1.setSkuCode("iphone_14 pro");
//			inventory1.setQuantity(100);
//
//			inventoryRepository.save(inventory);
//			inventoryRepository.save(inventory1);
//		};

	//}

}
