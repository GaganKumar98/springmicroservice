package com.bank.loan.service.impl;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.loan.contants.LoansConstants;
import com.bank.loan.dto.LoansDto;
import com.bank.loan.entity.Loans;
import com.bank.loan.exception.LoanAlreadyException;
import com.bank.loan.exception.ResourceNotFoundException;
import com.bank.loan.mapper.LoanMapper;
import com.bank.loan.repository.LoanRepository;
import com.bank.loan.service.ILoanService;

@Service
public class LoanService implements ILoanService {

	@Autowired
	private LoanRepository loansRepository;

	@Override
	public void createLoan(String mobileNumber) {
		Optional<Loans> optionalLoan = loansRepository.findByMobileNumber(mobileNumber);
		if (optionalLoan.isPresent()) {
			throw new LoanAlreadyException("Loan already registered with th give mobile number");
		}
		loansRepository.save(createNewLoans(mobileNumber));

	}

	private Loans createNewLoans(String mobilenumber) {
		Loans newLoan = new Loans();
		long randomNumber = 10000000000L + new Random().nextInt();
		newLoan.setLoanNumber(Long.toString(randomNumber));
		newLoan.setMobileNumber(mobilenumber);
		newLoan.setLoanType(LoansConstants.HOME_LOAN);
		newLoan.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
		newLoan.setAmountPaid(0);
		newLoan.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
		return newLoan;
	}

	@Override
	public LoansDto fetchLoan(String mobileNumber) {
		Loans loans = loansRepository.findByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber));

		return LoanMapper.mapToLoansDto(loans, new LoansDto());
	}

	@Override
	public boolean updateLoan(LoansDto loansDto) {
		Loans loans = loansRepository.findByMobileNumber(loansDto.getMobileNumber())
				.orElseThrow(() -> new ResourceNotFoundException("Loan", "LoanNumber", loansDto.getLoanNumber()));

		LoanMapper.mapToLoans(loansDto, loans);
		loansRepository.save(loans);
		return true;
	}

	@Override
	public boolean deleteLoan(String mobileNumber) {
		Loans loans = loansRepository.findByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber));
		loansRepository.deleteById(loans.getLoanId());
		return true;
	}

}
