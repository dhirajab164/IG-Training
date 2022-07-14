package com.dhiraj.app.entity.enums;

import java.util.stream.*;

public enum Active {
	FALSE(0), TRUE(1);

	private int active;

	private Active(int active) {
		this.active = active;
	}

	private int getActive() {
		return active;
	}

	public static Active of(int val) {
		return Stream.of(Active.values()).filter(v -> v.getActive() == val).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
