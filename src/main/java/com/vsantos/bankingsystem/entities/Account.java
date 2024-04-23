package com.vsantos.bankingsystem.entities;

import java.time.LocalDate;
import java.util.Objects;

import com.vsantos.bankingsystem.entities.enums.AccountEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private Integer password;
	private LocalDate date;
	private Double amount;
	private Integer numOfOperations;
	private AccountEnum accountType;

	public Account() {
	}

	public Account(Long id, String name, String email, Integer password, LocalDate date, Double amount, AccountEnum accountType) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.date = date;
		this.amount = amount;
		this.numOfOperations = 0;
		this.accountType = accountType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setNumOfOperations() {
		this.numOfOperations = numOfOperations + 1;
	}
	
	public Integer getNumOfOperations() {
		return numOfOperations;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPassword() {
		return password;
	}

	public void setPassword(Integer password) {
		this.password = password;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount += amount;
	}
	
	public void setAmountSaque(Double amount) {
		this.amount -= amount;
	}

	public AccountEnum getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountEnum accountType) {
		this.accountType = accountType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(id, other.id);
	}

}
