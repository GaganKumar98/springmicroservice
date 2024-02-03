package com.bank.account.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.bank.account.entity.Accounts;

import jakarta.transaction.Transactional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

	Optional<Accounts> findByCustomerId(Long cutomerId);
	
//	Optional<Customer> findByMobileNumber(String number);
	
	@Transactional
	@Modifying
	void deleteByCustomerId(Long customerId);

}
