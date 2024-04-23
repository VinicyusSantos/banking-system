package com.vsantos.bankingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vsantos.bankingsystem.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
