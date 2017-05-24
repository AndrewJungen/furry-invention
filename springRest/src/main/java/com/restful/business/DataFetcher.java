package com.restful.business;

import com.restful.types.Person;

public class DataFetcher {

	public static Person getPerson(String first, String last, String email) {
		Person person = new Person();
		//Call database...
		isMockPerson(first, last, email, person);		
		return person;
	}
	
	public static boolean createPerson(String first, String last, String email, String age, String phone) {
		Person person = new Person();
		person.setAge(age);
		person.setEmail(email);
		person.setFirst(first);
		person.setLast(last);
		person.setPhone(phone);
		//Send to database...
		return true;
	}

	private static void isMockPerson(String first, String last, String email, Person person) {
		if("Nick".equalsIgnoreCase(first) && "Fury".equalsIgnoreCase(last) && "email@gmail.com".equalsIgnoreCase(email)){
			person.setAge("50");
			person.setEmail("email@gmail.com");
			person.setFirst("Nick");
			person.setLast("Fury");
			person.setPhone("123-123-1234");
		}
	}	
}
