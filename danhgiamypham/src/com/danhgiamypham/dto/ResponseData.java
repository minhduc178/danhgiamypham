package com.danhgiamypham.dto;

import java.util.Set;

import com.danhgiamypham.model.CauHoi;

public class ResponseData<T>{

	private String errorMessage="";
	private T data;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}
