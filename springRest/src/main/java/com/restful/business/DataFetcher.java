package com.restful.business;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.restful.types.Person;

public class DataFetcher {

	public static Person getPerson(String first, String last, String email) {
		List<Person> personList = new ArrayList<Person>();
		Connection connection = getRemoteConnection();
		Statement statement = null;
		ResultSet resultSet = null;		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT idtype, idgrouptype, namegrouptype, nametype from HappierHour.dbo.HHDBTypes");
			System.out.println("reseultSet: " + resultSet.toString());
			while(resultSet.next()){
				Person person = new Person();
				isMockPerson(first, last, email, person);
				person.setFirst(resultSet.getString("namegrouptype"));
				person.setLast(resultSet.getString("nametype"));
				personList.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}	
		return personList.get(0);
	}

	public static boolean createPerson(String first, String last, String email, String age, String phone) {
		Person person = new Person();
		person.setAge(age);
		person.setEmail(email);
		person.setFirst(first);
		person.setLast(last);
		person.setPhone(phone);
		// Send to database...
		return true;
	}

	private static void isMockPerson(String first, String last, String email, Person person) {
		if ("Nick".equalsIgnoreCase(first) && "Fury".equalsIgnoreCase(last) && "email@gmail.com".equalsIgnoreCase(email)) {
			person.setAge("50");
			person.setEmail("email@gmail.com");
			person.setPhone("123-123-1234");
		}
	}

	private static Connection getRemoteConnection() {
		if (System.getProperty("RDS_HOSTNAME") != null) {
			System.out.println("System.getProperty(RDS_HOSTNAME) : " + System.getProperty("RDS_HOSTNAME"));
			try {
				Class.forName("org.postgresql.Driver");
				String dbName = System.getProperty("RDS_DB_NAME");
				String userName = System.getProperty("RDS_USERNAME");
				String password = System.getProperty("RDS_PASSWORD");
				String hostname = System.getProperty("RDS_HOSTNAME");
				String port = System.getProperty("RDS_PORT");
				String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName
						+ "&password=" + password;
				System.out.println("JDBCURL  : " + jdbcUrl);
				Connection con = DriverManager.getConnection(jdbcUrl);
				return con;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println(e);
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return null;
	}
}
