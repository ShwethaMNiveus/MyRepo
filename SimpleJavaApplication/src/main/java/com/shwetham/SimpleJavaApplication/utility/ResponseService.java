package com.shwetham.SimpleJavaApplication.utility;

import java.util.ArrayList;

public class ResponseService<T> {

	private ArrayList<T> data;
	private String message;
	private int responseCount;
	
	public ArrayList<T> getData() {
		return data;
	}
	public void setT(ArrayList<T> data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getResponseCount() {
		return responseCount;
	}
	public void setResponseCount(int responseCount) {
		this.responseCount = responseCount;
	}
	public ResponseService(ArrayList<T> data, String message, int responseCount) {
		super();
		this.data = data;
		this.message = message;
		this.responseCount = responseCount;
	}
	@Override
	public String toString() {
		return "ResponseService [data=" + data + ", message=" + message + ", responseCount=" + responseCount + "]";
	}
	
	
}
