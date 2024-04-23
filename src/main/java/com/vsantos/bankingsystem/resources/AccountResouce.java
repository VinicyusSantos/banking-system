package com.vsantos.bankingsystem.resources;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vsantos.bankingsystem.entities.Account;
import com.vsantos.bankingsystem.entities.UserRecord;
import com.vsantos.bankingsystem.services.AccountService;

@RestController
@RequestMapping(value = "/accounts")
public class AccountResouce {

	@Autowired
	private AccountService service;
	
	@GetMapping
	public ResponseEntity<List<Account>> findAll(){
		List<Account> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Account> findAccount(@PathVariable Long id){
		Account obj = service.findAccount(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Account> createAccount(@RequestBody UserRecord user){
		Account account = service.createAccount(user);
		return ResponseEntity.ok().body(account);
	}
	
	@PutMapping(value = "/{id}/deposito")
	public ResponseEntity<Account> deposito(@PathVariable Long id, @RequestBody Map<String, Object> requestBody){
		Double value = (Double) requestBody.get("value");
	    String email = (String) requestBody.get("email");
	    Integer password = (Integer) requestBody.get("password");
		
		Account obj = service.deposito(id, value, email, password);
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping(value = "/{id}/saque")
	public ResponseEntity<Account> saque(@PathVariable Long id,@RequestBody Map<String, Object> requestBody){
		Double value = (Double) requestBody.get("value");
	    String email = (String) requestBody.get("email");
	    Integer password = (Integer) requestBody.get("password");
	    
	    Account obj = service.saque(id, value, email, password);
	    return ResponseEntity.ok().body(obj);
	}
	
}
