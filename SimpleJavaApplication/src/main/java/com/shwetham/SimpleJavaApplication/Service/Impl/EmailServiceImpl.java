package com.shwetham.SimpleJavaApplication.Service.Impl;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.shwetham.SimpleJavaApplication.Beans.EmailBean;
import com.shwetham.SimpleJavaApplication.Service.EmailService;
import com.shwetham.SimpleJavaApplication.utility.ResponseService;

@Component
public class EmailServiceImpl implements EmailService {

	/*
	 * Function name: validateEmail; Purpose: Checks whether the input email address
	 * is valid or not; Returns: boolean
	 */
	ArrayList<EmailBean> LstEmails = new ArrayList<>();
	int num = 1;

	@Override
	public ResponseService<EmailBean> validateEmail(String email, String name, int id) {
		try {
			String reg_expression = "[a-zA-Z0-9]+[^0-9a-zA-Z@]*[a-zA-Z0-9]*[@][a-z]+[/.][a-z]{2,3}";
			if (email.matches(reg_expression)) {
				if (LstEmails.stream().noneMatch(a -> a.getEmail().equals(email))) {
					if (id == 0) {
						LstEmails.add(new EmailBean(email, name, num++));
					} else {
						for (int i = 0; i < LstEmails.size(); i++) {
							if (LstEmails.get(i).getEid() == id) {
								LstEmails.get(i).setEmail(email);
								LstEmails.get(i).setName(name);
							}
						}
					}
					return new ResponseService<>(LstEmails, "valid mail", 200);
				} else {
					return new ResponseService<>(LstEmails, "mail is already present", 200);
				}

			} else {

				return new ResponseService<>(LstEmails, "invalid mail", 200);
			}
		} catch (Exception e) {
			System.err.println("EmailServiceImpl ValidateEmail error: " + e.getMessage());
			return new ResponseService<>(null, "invalid mail", 501);
		}

	}

	@Override
	public ResponseService<EmailBean> deleteEmail(String email) {
		try {
			System.out.println("inside deleteEmail service");
			if (LstEmails.stream().anyMatch(a -> a.getEmail().equals(email))) {
				EmailBean findAny = LstEmails.stream().filter(d -> d.getEmail().equals(email)).findAny().get();
				LstEmails.remove(findAny);
				return new ResponseService<>(LstEmails, "email deleted", 200);
			} else {
				return new ResponseService<>(LstEmails, "mail is not present", 200);
			}

		} catch (Exception e) {
			System.err.println("EmailServiceImpl ValidateEmail error: " + e.getMessage());
			return new ResponseService<>(null, "invalid mail", 501);
		}

	}

	@Override
	public ResponseService<EmailBean> editEmail(String email, String name) {
		try {
			if (LstEmails.stream().anyMatch(a -> a.getEmail().equals(email))) {
				EmailBean findAny = LstEmails.stream().filter(d -> d.getEmail().equals(email)).findAny().get();
				LstEmails.remove(findAny);
				return new ResponseService<>(LstEmails, "email deleted", 200);
			} else {
				return new ResponseService<>(LstEmails, "mail is not present", 200);
			}

		} catch (Exception e) {
			System.err.println("EmailServiceImpl ValidateEmail error: " + e.getMessage());
			return new ResponseService<>(null, "invalid mail", 501);
		}
	}

}
