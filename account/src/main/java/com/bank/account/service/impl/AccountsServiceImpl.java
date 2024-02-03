package com.bank.account.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.account.constants.AccountsConstants;
import com.bank.account.dto.AccountsDto;
import com.bank.account.dto.CustomerDto;
import com.bank.account.entity.Accounts;
import com.bank.account.entity.Customer;
import com.bank.account.exception.CustomerAlreadyExistsException;
import com.bank.account.exception.ResourceNotFoundException;
import com.bank.account.mapper.AccountsMapper;
import com.bank.account.mapper.CustomerMapper;
import com.bank.account.repository.AccountsRepository;
import com.bank.account.repository.CustomerRepository;
import com.bank.account.service.IAccountsService;

@Service
public class AccountsServiceImpl implements IAccountsService {

	@Autowired
	private AccountsRepository accountsRepository;

	@Autowired
	private CustomerRepository customerRepository;

	public void createAccounts(CustomerDto customerDto) {
		Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
		Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customer.getMobileNumber());
		if (optionalCustomer.isPresent()) {
			throw new CustomerAlreadyExistsException(
					"customer Already present with th given mobile number" + customerDto.getMobileNumber());
		}

		Customer savCustomer = customerRepository.save(customer);
		accountsRepository.save(createNewCustomer(savCustomer));
	}

	private Accounts createNewCustomer(Customer customer) {
		Accounts accounts = new Accounts();
		accounts.setCustomerId(customer.getCustomerId());
		long randomAccountNumber = 10000000000L + new Random().nextInt();
		accounts.setAccountNumber(randomAccountNumber);
		accounts.setAccountType(AccountsConstants.SAVINGS);
		accounts.setBranchAddress(AccountsConstants.ADDRESS);
		return accounts;
	}

	@Override
	public CustomerDto fetchAccount(String mobileNumber) {
		Customer customer = customerRepository.findByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("customer", "mobile Number", mobileNumber));

		Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
				() -> new ResourceNotFoundException("Accounts", "Customer Id", customer.getCustomerId().toString()));

		CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
		customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));
		return customerDto;
	}

	@Override
	public boolean updateAccount(CustomerDto customerDto) {
		boolean isUpdated = false;
		AccountsDto accountsDto = customerDto.getAccountsDto();
		if (accountsDto != null) {
			Accounts accounts = accountsRepository.findById(accountsDto.getAccountNumber())
					.orElseThrow(() -> new ResourceNotFoundException("Account", "AccountNumber",
							accountsDto.getAccountNumber().toString()));

			AccountsMapper.mapToAccounts(accountsDto, accounts);
			accounts = accountsRepository.save(accounts);

			Long customerId = accounts.getCustomerId();
			Customer customer = customerRepository.findById(customerId)
					.orElseThrow(() -> new ResourceNotFoundException("customer", "customerId", customerId.toString()));

			CustomerMapper.mapToCustomer(customerDto, customer);
			customerRepository.save(customer);
			isUpdated = true;
		}

		return isUpdated;
	}

	@Override
	public boolean deleteAccounts(String mobileNumber) {
		Customer customer = customerRepository.findByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));

		accountsRepository.deleteByCustomerId(customer.getCustomerId());
		customerRepository.deleteById(customer.getCustomerId());
		return true;
	}

}
