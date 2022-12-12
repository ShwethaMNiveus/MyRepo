package com.shwetham.SimpleJavaApplication.Beans;

public class EmailBean {

	private String email;
	private String name;
	private int eid;
	
	public int getEid() {
		return eid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public EmailBean(String email, String name, int eid) {
		super();
		this.email = email;
		this.name = name;
		this.eid = eid;
	}
	@Override
	public String toString() {
		return "EmailBean [email=" + email + ", name=" + name + ", eid=" + eid + "]";
	}
	
	
}
