package com.shwetham.SimpleJavaApplication.Service;

import org.springframework.stereotype.Service;

import com.shwetham.SimpleJavaApplication.Beans.EmailBean;
import com.shwetham.SimpleJavaApplication.utility.ResponseService;

@Service
public interface EmailService {
	
	public ResponseService<EmailBean> validateEmail(String email, String name, int id);
	public ResponseService<EmailBean> deleteEmail(String email);
	public ResponseService<EmailBean> editEmail(String email, String name);

}
