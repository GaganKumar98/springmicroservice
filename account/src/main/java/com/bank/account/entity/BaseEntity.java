package com.bank.account.entity;

import java.time.LocalDateTime;

import org.springframework.boot.actuate.audit.listener.AuditListener;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

	@Column(updatable = false)
	@CreatedDate
	public LocalDateTime createAt;

	@Column(updatable = false)
	@CreatedBy
	public String createdBy;

	@Column(insertable = false)
	@LastModifiedDate
	public LocalDateTime updateAt;

	@Column(insertable = false)
	@LastModifiedBy
	public String updateBy;

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public BaseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BaseEntity(LocalDateTime createAt, String createdBy, LocalDateTime updateAt, String updateBy) {
		super();
		this.createAt = createAt;
		this.createdBy = createdBy;
		this.updateAt = updateAt;
		this.updateBy = updateBy;
	}

	@Override
	public String toString() {
		return "BaseEntity [createAt=" + createAt + ", createdBy=" + createdBy + ", updateAt=" + updateAt
				+ ", updateBy=" + updateBy + "]";
	}

}
