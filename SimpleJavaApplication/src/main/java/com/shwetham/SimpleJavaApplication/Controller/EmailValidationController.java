package com.shwetham.SimpleJavaApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.shwetham.SimpleJavaApplication.Beans.EmailBean;
import com.shwetham.SimpleJavaApplication.Service.EmailService;
import com.shwetham.SimpleJavaApplication.utility.ResponseService;


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
	public ResponseEntity addEmail(@RequestParam("email") String email,@RequestParam("name") String name, @RequestParam("id") int id ) {
		try {
			ResponseService<EmailBean> responseService = emailServiceObj.validateEmail(email, name, id);
			if(responseService.getResponseCount()==200) {
				 return new ResponseEntity<>(responseService, HttpStatus.OK );
				 
			} else {
				return new ResponseEntity<>(responseService, HttpStatus.BAD_REQUEST );
			}
		}catch(Exception e) {
			System.err.println("EmailValidationController validateEmail error: " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
		}
	}
	
	@PostMapping("/delete")
	public ResponseEntity deleteEmail(@RequestParam("email") String email ) {
		try {
			ResponseService<EmailBean> responseService = emailServiceObj.deleteEmail(email);
			if(responseService.getResponseCount()==200) {
				 return new ResponseEntity<>(responseService, HttpStatus.OK );
				 
			} else {
				return new ResponseEntity<>(responseService, HttpStatus.BAD_REQUEST );
			}
		}catch(Exception e) {
			System.err.println("EmailValidationController validateEmail error: " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
		}
	}
	
	@PostMapping("/edit")
	public ResponseEntity editEmail(@RequestParam("email") String email ) {
		try {
			ResponseService<EmailBean> responseService = emailServiceObj.deleteEmail(email);
			if(responseService.getResponseCount()==200) {
				 return new ResponseEntity<>(responseService, HttpStatus.OK );
				 
			} else {
				return new ResponseEntity<>(responseService, HttpStatus.BAD_REQUEST );
			}
		}catch(Exception e) {
			System.err.println("EmailValidationController validateEmail error: " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
		}
	}

}
