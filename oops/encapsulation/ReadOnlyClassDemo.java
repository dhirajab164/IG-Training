package com.dhiraj.oops.encapsulation;

class DbConfig {
	private final String diverName = "com.mysql.cj.jdbc.Driver";
	private final String connectionUrl = "jdbc:mysql://localhost:3306/db_name";
	private final String username = "username";
	private final String password = "admin";

	public String getDiverName() {
		return diverName;
	}

	public String getConnectionUrl() {
		return connectionUrl;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "DbConfig [diverName=" + diverName + ", connectionUrl=" + connectionUrl + ", username=" + username
				+ ", password=" + password + "]";
	}

}

public class ReadOnlyClassDemo {

	public static void main(String[] args) {

		DbConfig config = new DbConfig();
		System.out.println(config.getConnectionUrl());
		System.out.println(config.getDiverName());

	}

}
