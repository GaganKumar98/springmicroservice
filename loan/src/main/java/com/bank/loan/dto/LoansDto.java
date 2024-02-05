package com.bank.loan.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Schema(name = "Loans", description = "Schema to hold Loan information")
public class LoansDto {

	@Schema(description = "Mobile Number of Customer", example = "4365327698")
	@NotEmpty(message = "Mobile Number can not be Null or Empty")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "mobile number must of 10 Digit")
	private String mobileNumber;

	@Schema(description = "Loan Number of the customer", example = "548732457654")
	@NotEmpty(message = "Loan number cannot be Null or Empty")
	@Pattern(regexp = "(^$|[0-9]{12})", message = "Loan number must of 12 Digit")
	private String loanNumber;

	@Schema(description = "Type of the loan", example = "Home Loan")
	@NotEmpty(message = "Loan Type cannot be Null or Empty")
	private String loanType;

	@Schema(description = "Total loan amount", example = "100000")
	@Positive(message = "Total loan amount should be greater than zero")
	private int totalLoan;

	@Schema(description = "Total loan amount paid", example = "1000")
	@PositiveOrZero(message = "Total loan amount paid should be equal or greater than zero")
	private int amountPaid;

	@Schema(description = "Total outstanding amount against a loan", example = "99000")
	@PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero")
	private int outstandingAmount;

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public int getTotalLoan() {
		return totalLoan;
	}

	public void setTotalLoan(int totalLoan) {
		this.totalLoan = totalLoan;
	}

	public int getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}

	public int getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(int outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public LoansDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoansDto(String mobileNumber, String loanNumber, String loanType, int totalLoan, int amountPaid,
			int outstandingAmount) {
		super();
		this.mobileNumber = mobileNumber;
		this.loanNumber = loanNumber;
		this.loanType = loanType;
		this.totalLoan = totalLoan;
		this.amountPaid = amountPaid;
		this.outstandingAmount = outstandingAmount;
	}

	@Override
	public String toString() {
		return "LoansDto [mobileNumber=" + mobileNumber + ", loanNumber=" + loanNumber + ", loanType=" + loanType
				+ ", totalLoan=" + totalLoan + ", amountPaid=" + amountPaid + ", outstandingAmount=" + outstandingAmount
				+ "]";
	}

}
