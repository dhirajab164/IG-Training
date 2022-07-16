package com.dhiraj.app.entity.enums;

import java.util.stream.Stream;

public enum BookIssueStatus {
	PENDING(0), APPROVED(1), REJECTED(2);

	private int status;

	private BookIssueStatus(int status) {
		this.status = status;
	}

	public int getBookIssueStatus() {
		return status;
	}

	public static BookIssueStatus of(int status) {
		return Stream.of(BookIssueStatus.values()).filter(v -> v.getBookIssueStatus() == status).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
