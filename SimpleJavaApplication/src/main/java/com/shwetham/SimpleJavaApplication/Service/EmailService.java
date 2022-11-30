package com.shwetham.SimpleJavaApplication.Service;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {
	
	public boolean validateEmail(String email);

}
