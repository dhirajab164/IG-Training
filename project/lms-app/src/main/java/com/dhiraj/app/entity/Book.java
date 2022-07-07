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

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String title;

	private String author;

	private String publication;

	private int pages;

	private double price;

	private int copies;

	private Active active = Active.TRUE;

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

	public Book() {
		super();
	}
	
	

	public Book(long id, String title, String author, String publication, int pages, double price, int copies,
			Active active, User createdBy, LocalDate createdOn, User updatedBy, LocalDate updatedOn) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publication = publication;
		this.pages = pages;
		this.price = price;
		this.copies = copies;
		this.active = active;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}



	public Book(String title, String author, String publication, int pages, double price, int copies, Active active,
			User createdBy, LocalDate createdOn, User updatedBy, LocalDate updatedOn) {
		super();
		this.title = title;
		this.author = author;
		this.publication = publication;
		this.pages = pages;
		this.price = price;
		this.copies = copies;
		this.active = active;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	public Active getActive() {
		return active;
	}

	public void setActive(Active active) {
		this.active = active;
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
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publication=" + publication
				+ ", pages=" + pages + ", price=" + price + ", copies=" + copies + ", active=" + active + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn
				+ "]";
	}

}
