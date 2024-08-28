package com.dollop.lms.Validation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dollop.lms.utils.DbConnection;
import com.mysql.cj.protocol.Resultset;

public class Validation {

	static Scanner sc = new Scanner(System.in);
	static Connection con = null;
	static ResultSet rs = null;
	static Statement st = null;
	static Statement  stmt = null;

	public Validation() {

		try {
			this.con = DbConnection.getConnection();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public boolean password(String password) {
		String input = password;
		Pattern pattern = Pattern.compile("((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20})");
		Matcher matcher = pattern.matcher(input);
		System.out.println(matcher.matches());

		return matcher.matches();
	}

	public int quantity() {
		System.out.println("Enter book Quantity");
		String regex = "[1-9]+";
		String data = sc.nextLine();
		if (data.matches(regex)) {
			int a = 0;
			a = Integer.parseInt(data);
			return a;
		}
		System.out.println("invalid quantity");
		return quantity();
	}

	public int price() {
		System.out.println("Enter book price");
		String regex = "[0-9]+";
		String data = sc.nextLine();
		if (data.matches(regex)) {
			int a = 0;
			a = Integer.parseInt(data);
			return a;
		}
		System.out.println("invalid price");
		return price();
	}

	public static String isEmail() {

		System.out.println("enter email ");
		String email = sc.next();
		Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			return email;
		}
		System.out.println("invalid email,please enter again");
		return isEmail();
	}

	public static String isContact() {
		System.out.println("enter contact number");
		String input = sc.next();
		Pattern pattern = Pattern.compile("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}");
		Matcher matcher = pattern.matcher(input);
		if (matcher.matches()) {
			return input;
		}
		System.out.println("invalid contact,please enter again");
		return isContact();
	}

	public static String isPassword() {
		System.out.println("enter password");
		System.out.println("password will  be  required uppercase,lowercase,digits and Special symbol");
		String pass = sc.nextLine();
		Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()]).{8,20}$");
		Matcher matcher = pattern.matcher(pass);
		if (matcher.matches()) {
			return pass;
		}

		System.out.println("wrong password,please enter right password ");
		return isPassword();
	}

	public static String isName() {
		System.out.println("  enter name");
		System.out.println("only characters allow,digits are not allowed");
		String name = sc.nextLine();
		if (DuplicateName(name)) {
			Pattern pattern = Pattern.compile("^[a-zA-Z]+[\\-'\\s]?[a-zA-Z ]+$");
			Matcher matcher = pattern.matcher(name);
			if (matcher.matches()) {
				return name;
			}

			System.out.println("invalid name,please correct name");

			return isName();
		} else {
			System.out.println(" duplicate name ::" + name);
			return isName();

		}
	}

	public static String userNameValidation() {
		System.out.println("enter user name");
		String name = sc.nextLine();
		Pattern pattern = Pattern.compile("[A-Z][a-z]{5,10}");
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches()) {
			return name;
		}

		System.out.println("invalid  username,please enter user name");
		return userNameValidation();
	}

	public static boolean DuplicateName(String name) {
		String sql = "select *from librarian";
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString(2).equals(name)) {
					return false;
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return true;
	}

	public static boolean checkName(String name) {
		String sql = "select *from Issuedbook";
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {

				if (rs.getString("studentName").equals(name)) {
					return true;
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

	public static String isAddress() {
		System.out.println("enter address");

		String address = sc.nextLine();
		Pattern pattern = Pattern.compile("^[#.a-zA-Z,-]+$");
		Matcher matcher = pattern.matcher(address);
		if (matcher.matches()) {
			return address;
		}
		System.out.println("invalid address,please enter correct valid address");
		return isAddress();
	}

	public static boolean DuplicateBooks(String name) {
		String sql = "SELECT *FROM BOOKS";

		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString(2).equals(name)) {
					return false;
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return true;
	}
	
	public Boolean isAdminMatch(String Name,String password) {
		ResultSet rs = null;
		try 
		{
			   stmt = con.createStatement();
			   rs = stmt.executeQuery("Select * from Admin");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			  while (rs.next()) {

				String sd = rs.getString("USERNAME");
				String ps = rs.getString("PASSWORD");
				if (sd.equals(Name)&&ps.equals(password)) {
					System.out.println("isAdminMatched......");
					return true;
				}
			}
			return false;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;

		
	}

}
