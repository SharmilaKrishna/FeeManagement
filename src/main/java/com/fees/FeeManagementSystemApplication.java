package com.fees;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.fees.entity")
@EnableJpaRepositories("com.fees.repository")
public class FeeManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeeManagementSystemApplication.class, args);
	}

}
