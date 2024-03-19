package com.bank.account.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
//import lombok.Data;

//@Data
//@AllArgsConstructor
@Schema(name = "Error Response", description = "Schema to Hold error response information")
public class ErrorResponseDto {

	@Schema(description = "Api path invoked by client")
	private String apiPath;

	@Schema(description = "Error code representing the error happend")
	private HttpStatus errorCode;

	@Schema(description = "Error message representing the error happend")
	private String errorMessage;

	@Schema(description = "Time representing when the error happened")
	private LocalDateTime errorTime;

	public String getApiPath() {
		return apiPath;
	}

	public void setApiPath(String apiPath) {
		this.apiPath = apiPath;
	}

	public HttpStatus getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public LocalDateTime getErrorTime() {
		return errorTime;
	}

	public void setErrorTime(LocalDateTime errorTime) {
		this.errorTime = errorTime;
	}

	public ErrorResponseDto() {
		super();
		
	}

	public ErrorResponseDto(String apiPath, HttpStatus errorCod, String errorMessage, LocalDateTime errorTime) {
		super();
		this.apiPath = apiPath;
		this.errorCode = errorCod;
		this.errorMessage = errorMessage;
		this.errorTime = errorTime;
	}

	@Override
	public String toString() {
		return "ErrorResponseDto [apiPath=" + apiPath + ", errorCod=" + errorCode + ", errorMessage=" + errorMessage
				+ ", errorTime=" + errorTime + "]";
	}

}
