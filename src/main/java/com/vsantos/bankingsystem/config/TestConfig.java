package com.vsantos.bankingsystem.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.vsantos.bankingsystem.entities.Account;
import com.vsantos.bankingsystem.entities.enums.AccountEnum;
import com.vsantos.bankingsystem.repositories.AccountRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	
	@Autowired
	private AccountRepository accountRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Account a1 = new Account(null, "Vinicyus","vini@gmail.com", 123, LocalDate.now(), 500.00, AccountEnum.PF);
		accountRepository.save(a1);
		
	}

}
