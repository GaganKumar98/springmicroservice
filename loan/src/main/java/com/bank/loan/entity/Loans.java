package com.bank.loan.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Loans extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loan_id")
	private Long loanId;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "loan_number")
	private String loanNumber;

	@Column(name = "loan_type")
	private String loanType;

	@Column(name = "total_loan")
	private int totalLoan;

	@Column(name = "amount_paid")
	private int amountPaid;

	@Column(name = "outstanding_amount")
	private int outstandingAmount;

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

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

	public Loans() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Loans(String createdBy, LocalDateTime createdAt, String updatedBy, LocalDateTime updatedAt, Long loanId,
			String mobileNumber, String loanNumber, String loanType, int totalLoan, int amountPaid,
			int outstandingAmount) {
		super(createdBy, createdAt, updatedBy, updatedAt);
		this.loanId = loanId;
		this.mobileNumber = mobileNumber;
		this.loanNumber = loanNumber;
		this.loanType = loanType;
		this.totalLoan = totalLoan;
		this.amountPaid = amountPaid;
		this.outstandingAmount = outstandingAmount;
	}

	@Override
	public String toString() {
		return "Loans [loanId=" + loanId + ", mobileNumber=" + mobileNumber + ", loanNumber=" + loanNumber
				+ ", loanType=" + loanType + ", totalLoan=" + totalLoan + ", amountPaid=" + amountPaid
				+ ", outstandingAmount=" + outstandingAmount + "]";
	}

}
