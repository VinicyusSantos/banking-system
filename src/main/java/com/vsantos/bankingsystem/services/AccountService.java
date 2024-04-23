package com.vsantos.bankingsystem.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsantos.bankingsystem.entities.Account;
import com.vsantos.bankingsystem.entities.UserRecord;
import com.vsantos.bankingsystem.entities.enums.AccountEnum;
import com.vsantos.bankingsystem.repositories.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repository;

	public Account findAccount(Long id) {
		Optional<Account> obj = repository.findById(id);
		return obj.get();
	}
	
	public List<Account> findAll(){
		return repository.findAll();
	}
	
	public Account createAccount(UserRecord user) {
		Account account = new Account(null, user.name(), user.email(), user.password(), LocalDate.now(), 0.0, user.accountType());
		repository.save(account);
		return account;
	}

	public Account deposito(Long id, Double value, String email, Integer password) {
		Account entity = findAccount(id);
		if(entity.getNumOfOperations() < 10) {
			if (entity.getEmail().equals(email) && entity.getPassword().equals(password)) {
				entity.setAmount(value);
				entity.setNumOfOperations();
			}
			return repository.save(entity);
		}
		else {
			return null;
		}
	}
	
	public Account saque(Long id, Double value, String email, Integer password) {
		Account entity = findAccount(id);
		if(entity.getNumOfOperations() < 10) {
			if(entity.getEmail().equals(email) && entity.getPassword().equals(password)) {
				if(entity.getAccountType() == AccountEnum.PJ) {
					entity.setAmountSaque(value + 5.0);
				}
				else {
					entity.setAmountSaque(value);
				}
				entity.setNumOfOperations();
			}
			return repository.save(entity);
		}
		else {
			return null;
		}
	}

}
