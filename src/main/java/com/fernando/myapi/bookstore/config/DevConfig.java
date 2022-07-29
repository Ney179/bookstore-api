package com.fernando.myapi.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fernando.myapi.bookstore.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	DBService dbService;
	
	private String strategy;
	
	@Bean
	public boolean instanciaBaseDados() {
		if(strategy.equals("create")) {
			this.dbService.instanciaBaseDados();
		}
		return false;
	}
}
