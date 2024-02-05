package com.bank.card.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

	@Column(updatable = false)
	@CreatedDate
	private LocalDateTime createdAt;

	@Column(updatable = false)
	@CreatedBy
	private String createdBy;

	@Column(insertable = false)
	@LastModifiedDate
	private LocalDateTime updateAt;

	@Column(insertable = false)
	@LastModifiedBy
	private String updatedBy;
}
