package com.bank.account.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(name = "Response", description = "Schema to Hold Successful response information")
public class ResponseDto {

	@Schema(description = "Status Code in the response", example = "200")
	private String statusCode;

	@Schema(description = "Status Message in the response", example = "Request processed successfully")
	private String statusMsg;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMsg() {
		return statusMsg;
	}

	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}

	public ResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseDto(String statusCode, String statusMsg) {
		super();
		this.statusCode = statusCode;
		this.statusMsg = statusMsg;
	}

	@Override
	public String toString() {
		return "ResponseDto [statusCode=" + statusCode + ", statusMsg=" + statusMsg + "]";
	}

}
