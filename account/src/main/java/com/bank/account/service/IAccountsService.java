package com.bank.account.service;

import com.bank.account.dto.CustomerDto;

public interface IAccountsService {

	void createAccounts(CustomerDto customerDto);
	
	CustomerDto fetchAccount(String mobileNumber);
	
	boolean updateAccount(CustomerDto customerDto);
	
	boolean deleteAccounts(String mobileNumber);
}
