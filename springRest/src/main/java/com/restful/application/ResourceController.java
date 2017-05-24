package com.restful.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.restful.business.DataFetcher;
import com.restful.types.Person;

@Controller
public class ResourceController {

	@RequestMapping("/getPerson")
	public @ResponseBody Person getPerson(@RequestParam(value = "first", defaultValue = "") String first, @RequestParam(value = "last", defaultValue = "") String last, 
			@RequestParam(value = "email", defaultValue = "") String email) {
		Person person = new Person();
		if (!first.isEmpty() && !last.isEmpty() && !email.isEmpty()) {
			person = DataFetcher.getPerson(first, last, email);
		}
		return person;
	}
	
	@RequestMapping("/createPerson")
	public @ResponseBody boolean createPerson(@RequestParam(value = "first", defaultValue = "") String first, @RequestParam(value = "last", defaultValue = "") String last, 
			@RequestParam(value = "email", defaultValue = "") String email, @RequestParam(value = "age", defaultValue = "") String age, @RequestParam(value = "phone", defaultValue = "") String phone) {
		boolean successFlag = false;
		if (!first.isEmpty() && !last.isEmpty() && !email.isEmpty() && !age.isEmpty() && !phone.isEmpty()) {
			successFlag = DataFetcher.createPerson(first, last, email, age, phone);
		}
		return successFlag;
	}
}
