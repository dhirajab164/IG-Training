package com.dhiraj.app.entity.enums;

import java.util.stream.Stream;

public enum TransactionStatus {
	PENDING(0), APPROVED(1), REJECTED(2);

	private int status;

	private TransactionStatus(int status) {
		this.status = status;
	}

	public int getTransactionStatus() {
		return status;
	}

	public static TransactionStatus of(int status) {
		return Stream.of(TransactionStatus.values()).filter(v -> v.getTransactionStatus() == status).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
