package com.dhiraj.app.entity.enums;

import java.util.stream.Stream;

public enum Gender {
	M(0), F(1);

	private int gender;

	private Gender(int gender) {
		this.gender = gender;
	}

	private int getGender() {
		return gender;
	}

	public static Gender of(int val) {
		return Stream.of(Gender.values()).filter(v -> v.getGender() == val).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
