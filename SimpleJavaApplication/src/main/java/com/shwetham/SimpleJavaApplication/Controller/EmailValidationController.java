package com.shwetham.SimpleJavaApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.shwetham.SimpleJavaApplication.Service.EmailService;


@RestController
public class EmailValidationController {
	
	@Autowired
	EmailService emailServiceObj;
		
	
	@GetMapping("/")
	public ModelAndView getEmailPage() {
		ModelAndView mvn = new ModelAndView();
		mvn.setViewName("index.html");
		return mvn;
	}

	@PostMapping("/submit")
	public String validateEmail(@RequestParam("email") String email) {
		try {
			if(emailServiceObj.validateEmail(email)) {
				return "Valid email";
			}else {
				return "Invaid email";
			}
			
		}catch(Exception e) {
			System.err.println("EmailValidationController validateEmail error: " + e.getMessage());
			return null;
		}
	}

}
