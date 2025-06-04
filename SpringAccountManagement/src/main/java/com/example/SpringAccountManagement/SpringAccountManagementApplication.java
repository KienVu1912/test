package com.example.SpringAccountManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.SpringAccountManagement.model.AccountModel;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAccountManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAccountManagementApplication.class, args);
	}
	@Bean
	public AccountModel accountModel() {
		return new AccountModel();
	}
}
