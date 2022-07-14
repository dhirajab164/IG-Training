package com.dhiraj.app.entity.enums;

import java.util.stream.Stream;

public enum UserType {
	Customer(0), Librarian(1);

	private int userType;

	private UserType(int userType) {
		this.userType = userType;
	}

	public int getUserType() {
		return userType;
	}

	public static UserType of(int val) {
		return Stream.of(UserType.values()).filter(v -> v.getUserType() == val).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
