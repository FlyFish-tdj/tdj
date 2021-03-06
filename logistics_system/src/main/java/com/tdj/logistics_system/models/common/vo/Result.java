package com.tdj.logistics_system.models.common.vo;

public class Result <T> {

	private int status;
	private String message;
	private T object;
	
	public Result() {
	}
	
	public Result(int status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public Result(int status, String message, T object) {
		super();
		this.status = status;
		this.message = message;
		this.object = object;
	}

	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public T getObject() {
		return object;
	}
	
	public void setObject(T object) {
		this.object = object;
	}
	
	public enum resultStatus {
		
		SUCCESS(200),FAILED(500);
		public int status;

		private resultStatus(int status) {
			this.status = status;
		}
		
	}
	
	
}
