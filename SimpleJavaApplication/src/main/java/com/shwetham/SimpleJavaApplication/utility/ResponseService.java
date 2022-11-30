package com.shwetham.SimpleJavaApplication.utility;

public class ResponseService<T> {

	private T t;
	private String message;
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ResponseService(T t, String message) {
		super();
		this.t = t;
		this.message = message;
	}
	@Override
	public String toString() {
		return "ResponseService [t=" + t + ", message=" + message + "]";
	}
	
	
}
