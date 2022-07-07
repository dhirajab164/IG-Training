package com.dhiraj.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;

import com.dhiraj.app.entity.enums.Active;
import com.dhiraj.app.entity.enums.TransactionStatus;
import com.dhiraj.app.util.Util;

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

	public Transaction() {
		super();
	}

	public Transaction(Book book, User issuedTo, User issuedBy, Active active, TransactionStatus status, String remark,
			LocalDate issuedOn, LocalDate toBeReturnedOn, User createdBy, User updatedBy) {
		super();
		this.book = book;
		this.issuedTo = issuedTo;
		this.issuedBy = issuedBy;
		this.active = active;
		this.status = status;
		this.remark = remark;
		this.issuedOn = issuedOn;
		this.toBeReturnedOn = toBeReturnedOn;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getIssuedTo() {
		return issuedTo;
	}

	public void setIssuedTo(User issuedTo) {
		this.issuedTo = issuedTo;
	}

	public User getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(User issuedBy) {
		this.issuedBy = issuedBy;
	}

	public Active getActive() {
		return active;
	}

	public void setActive(Active active) {
		this.active = active;
	}

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public LocalDate getIssuedOn() {
		return issuedOn;
	}

	public void setIssuedOn(LocalDate issuedOn) {
		this.issuedOn = issuedOn;
	}

	/*
	 * public LocalDate getToBeReturnedOn() { int maxDays = util.getMaxDays();
	 * return getIssuedOn().plusDays(maxDays); }
	 */

	public LocalDate getToBeReturnedOn() {
		return toBeReturnedOn;
	}

	public void setToBeReturnedOn(LocalDate toBeReturnedOn) {
		this.toBeReturnedOn = toBeReturnedOn;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDate getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", book=" + book + ", issuedTo=" + issuedTo + ", issuedBy=" + issuedBy
				+ ", active=" + active + ", status=" + status + ", remark=" + remark + ", issuedOn=" + issuedOn
				+ ", toBeReturnedOn=" + toBeReturnedOn + ", createdBy=" + createdBy + ", createdOn=" + createdOn
				+ ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + "]";
	}

}
