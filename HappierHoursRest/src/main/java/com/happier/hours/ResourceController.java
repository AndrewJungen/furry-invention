package com.happier.hours;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.restful.business.DataFetcher;
import com.restful.types.Business;
import com.restful.types.Person;

@Controller
public class ResourceController {

	@RequestMapping("/getPerson")
	public @ResponseBody Person getPerson(@RequestParam(value = "email", defaultValue = "") String email, 
			@RequestParam(value = "password", defaultValue = "") String password){
		Person person = new Person();
		if (!email.isEmpty() && !password.isEmpty()) {
			person = DataFetcher.getPerson(email, password);
		}
		person.setEmail("Andrew");
		person.setPassword("Jungen");
		return person;
	}
	
	@RequestMapping("/getBusinesses")
	public @ResponseBody List<Business> getBusinesses(@RequestParam(value = "currentlocation", defaultValue = "") String currentLocation){
		List<Business> businessList = new ArrayList<Business>();
		if(!currentLocation.isEmpty()){
			businessList = DataFetcher.getBusinesses(currentLocation);
		}
		return businessList;
	}
	
	@RequestMapping("/getBunsinessInfo")
	public @ResponseBody Business getBusinessInfo(@RequestParam(value = "businessId", defaultValue = "") String businessId){
		Business business = new Business();
		if(!businessId.isEmpty()){
			business = DataFetcher.getBusiness(businessId);
		}
		return business;
	}
}
