package com.example.Shopping;

import com.example.Shopping.entity.Product;
import com.example.Shopping.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@EntityScan(basePackages = "entity")
@SpringBootApplication
public class ShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);
	}
	@Bean
   public CommandLineRunner commandLineRunner (
         ProductRepository productRepository
   ) {return args -> {
          var product = Product.builder().name("iPhone")
                   .description("Best smart phone")
                    .build();
        productRepository.insert(product);
        };
    }
}
