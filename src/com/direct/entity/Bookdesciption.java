package com.direct.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Bookdesciption entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bookdesciption", catalog = "oa")
public class Bookdesciption implements java.io.Serializable {

	// Fields

	private Integer id;
	private Book book;
	private String img;
	private String desciption;

	// Constructors

	/** default constructor */
	public Bookdesciption() {
	}

	/** minimal constructor */
	public Bookdesciption(Book book) {
		this.book = book;
	}

	/** full constructor */
	public Bookdesciption(Book book, String img, String desciption) {
		this.book = book;
		this.img = img;
		this.desciption = desciption;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookId", nullable = false)
	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Column(name = "Img")
	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Column(name = "desciption")
	public String getDesciption() {
		return this.desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

}