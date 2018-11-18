package com.probrains.io.entity;

public class UserResponse<T> {

	private int status;
	private boolean isError;
	private long timestamp;
	private String message;
	private T data;
	
	public UserResponse(int status, boolean isError, long timestamp,String message, T data) {
		this.status = status;
		this.isError = isError;
		this.timestamp = timestamp;
		this.message = message;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "UserResponse [status=" + status + ", isError=" + isError + ", timestamp=" + timestamp + ", data=" + data
				+ "]";
	}
}
