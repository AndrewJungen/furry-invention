package com.restful.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.restful.types.Business;
import com.restful.types.Person;

public class DataFetcher {
	
	public static Person getPerson(String email, String password) {
		Person person = new Person();
		//Comment to run locally. Uncomment when deployed to AWS.
		Connection connection = getRemoteConnection();
		//Uncomment to run locally.
		//Connection connection = getRemoteConnectionLocal();
		Statement statement = null;
		ResultSet resultSet = null;		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT email FROM HappierHour.TABLENAME WHERE email = '"+ email +"' AND password = '" + password + "'");
			while(resultSet.next()){
				String emailFromData = resultSet.getString("email");
				if(email.equalsIgnoreCase(emailFromData)){
					person.setEmail(resultSet.getString(emailFromData));
				}	
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return person;
	}

	public static List<Business> getBusinesses(String currentLocation) {
		List<Business> businessList = new ArrayList<Business>();
		//Comment to run locally. Uncomment when deployed to AWS.
		Connection connection = getRemoteConnection();
		//Uncomment to run locally.
		//Connection connection = getRemoteConnectionLocal();
		Statement statement = null;
		ResultSet resultSet = null;
		String dayOfWeek = FetcherUtil.getDayOfWeek();
		String timeOfDay = FetcherUtil.getTimeOfDay();
		
		//Call Google Places Web API for businesses within 15 miles.
		//String of business names. Example Johnny's, Bo James, No Comma at the end for SQL IN statement.
		String listOfBusinessesFromGoogle = "";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT businessName, business Id, currentBusinessSpecial FROM HappierHour.TABLENAME WHERE timeOfDay = '" + timeOfDay + "' AND dayOfWeek = '" +
			dayOfWeek + "' AND businessName IN '" + listOfBusinessesFromGoogle + "'");
			while(resultSet.next()){
				Business business = new Business();
				business.setBusinessName(resultSet.getString("businessName"));
				business.setBusinessId(resultSet.getString("businessId"));
				business.setCurrentSpecial(resultSet.getString("currentBusinessSpecial"));
				businessList.add(business);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return businessList;
	}

	public static Business getBusiness(String businessId) {
		Business business = new Business();
		//Comment to run locally. Uncomment when deployed to AWS.
		Connection connection = getRemoteConnection();
		//Uncomment to run locally.
		//Connection connection = getRemoteConnectionLocal();
		Statement statement = null;
		ResultSet resultSet = null;		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT businessName, sundaySpecial, mondaySpecial, tuesdaySpecial, wednesdaySpecial, thursdaySpecial, fridaySpecial, saturdaySpecial "
					+ "FROM HappierHour.TABLENAME WHERE businessId = '" + businessId + "'");
			while(resultSet.next()){
				business.setBusinessName(resultSet.getString("businessName"));
				business.setSundaySpecial(resultSet.getString("sundaySpecial"));
				business.setMondaySpecial(resultSet.getString("mondaySpecial"));
				business.setTuesdaySpecial(resultSet.getString("tuesdaySpecial"));
				business.setWednesdaySpecial(resultSet.getString("wednesdaySpecial"));
				business.setThursdaySpecial(resultSet.getString("thursdaySpecial"));
				business.setFridaySpecial(resultSet.getString("fridaySpecial"));
				business.setSaturdaySpecial(resultSet.getString("saturdaySpecial"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		if(business.getBusinessName() !=null && !business.getBusinessName().isEmpty()){
			//Call Google Web Places API to get business contract Info
			business.setAddress("");
			business.setPhone("");
			business.setHours("");
		}
		return business;
	}

	private static Connection getRemoteConnection() {
		if (System.getProperty("RDS_HOSTNAME") != null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String dbName = System.getProperty("RDS_DB_NAME");
				String userName = System.getProperty("RDS_USERNAME");
				String password = System.getProperty("RDS_PASSWORD");
				String hostname = System.getProperty("RDS_HOSTNAME");
				String port = System.getProperty("RDS_PORT");
				String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName
						+ "&password=" + password;				
				Connection con = DriverManager.getConnection(jdbcUrl);
				return con;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}
		return null;
	}
	
	private static Connection getRemoteConnectionLocal() {
			try {
				Class.forName("com.mysql.jdbc.Driver");				
								
				Connection con = DriverManager.getConnection(jdbcUrl);
				return con;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
			}
		return null;
	}

}
