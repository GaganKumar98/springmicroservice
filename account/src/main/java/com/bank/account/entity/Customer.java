package com.bank.account.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class Customer extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Long customerId;

	private String name;

	private String email;

	@Column(name = "mobile_number")
	private String mobileNumber;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(LocalDateTime createAt, String createdBy, LocalDateTime updateAt, String updateBy) {
		super(createAt, createdBy, updateAt, updateBy);
		// TODO Auto-generated constructor stub
	}

	public Customer(Long customerId, String name, String email, String mobileNumber) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, email, mobileNumber, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(customerId, other.customerId) && Objects.equals(email, other.email)
				&& Objects.equals(mobileNumber, other.mobileNumber) && Objects.equals(name, other.name);
	}

}
