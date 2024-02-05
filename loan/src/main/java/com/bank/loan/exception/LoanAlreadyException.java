package com.bank.loan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class LoanAlreadyException extends RuntimeException {

	public LoanAlreadyException(String message) {
		super(message);
	}
}
