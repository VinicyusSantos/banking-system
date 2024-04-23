package com.vsantos.bankingsystem.entities;

import com.vsantos.bankingsystem.entities.enums.AccountEnum;

public record UserRecord(String name, String email, Integer password, AccountEnum accountType) {

}
