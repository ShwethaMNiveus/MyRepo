package com.shwetham.SimpleJavaApplication.Service.Impl;

import org.springframework.stereotype.Component;

import com.shwetham.SimpleJavaApplication.Service.EmailService;

@Component
public class EmailServiceImpl implements EmailService {

	/*
	 * Function name: validateEmail; Purpose: Checks whether the input email address
	 * is valid or not; Returns: boolean
	 */
	@Override
	public boolean validateEmail(String email) {
		try {
			if (email.matches("[a-zA-Z0-9]+[^0-9a-zA-Z@]*[a-zA-Z0-9]*[@][a-z]+[/.][a-z]{2,3}")) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.err.println("EmailServiceImpl ValidateEmail error: " + e.getMessage());
			return false;
		}

	}

}
