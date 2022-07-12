package com.dhiraj.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.dhiraj.app.entity.enums.Active;
import com.dhiraj.app.entity.enums.TransactionStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	private Book book;

	@ManyToOne
	@JoinColumn(name = "issued_to")
	private User issuedTo;

	@ManyToOne
	@JoinColumn(name = "issued_by")
	private User issuedBy;

	private Active active = Active.TRUE;

	private TransactionStatus status = TransactionStatus.PENDING;

	private String remark;

	@Column(name = "issued_on")
	private LocalDate issuedOn;

	@Column(name = "to_be_returned_on")
	private LocalDate toBeReturnedOn;

	@ManyToOne
	@JoinColumn(name = "created_by")
	private User createdBy;

	@CreationTimestamp
	@Column(name = "created_on")
	private LocalDate createdOn;

	@ManyToOne
	@JoinColumn(name = "updated_by")
	private User updatedBy;

	@UpdateTimestamp
	@Column(name = "updated_on")
	private LocalDate updatedOn;

	public Transaction(Book book, User issuedTo, User issuedBy, LocalDate issuedOn, LocalDate toBeReturnedOn,
			User createdBy, User updatedBy) {
		super();
		this.book = book;
		this.issuedTo = issuedTo;
		this.issuedBy = issuedBy;
		this.issuedOn = issuedOn;
		this.toBeReturnedOn = toBeReturnedOn;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

}
