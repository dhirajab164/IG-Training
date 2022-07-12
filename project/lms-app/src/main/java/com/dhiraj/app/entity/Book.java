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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

	public Book(String title, String author, String publication, int pages, double price, int copies, User createdBy,
			User updatedBy) {
		super();
		this.title = title;
		this.author = author;
		this.publication = publication;
		this.pages = pages;
		this.price = price;
		this.copies = copies;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

}
