package com.direct.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Book entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "book", catalog = "oa")
public class Book implements java.io.Serializable {

	// Fields

	private Integer bookId;
	private String bookName;
	private String author;
	private String publisher;
	private Timestamp pubDate;
	private Integer numbers;
	private Set<Bookdesciption> bookdesciptions = new HashSet<Bookdesciption>(0);
	private Set<Borrow> borrows = new HashSet<Borrow>(0);

	// Constructors

	/** default constructor */
	public Book() {
	}

	/** minimal constructor */
	public Book(String bookName, String author) {
		this.bookName = bookName;
		this.author = author;
	}

	/** full constructor */
	public Book(String bookName, String author, String publisher,
			Timestamp pubDate, Integer numbers,
			Set<Bookdesciption> bookdesciptions, Set<Borrow> borrows) {
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.pubDate = pubDate;
		this.numbers = numbers;
		this.bookdesciptions = bookdesciptions;
		this.borrows = borrows;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "bookId", unique = true, nullable = false)
	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	@Column(name = "bookName", nullable = false)
	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Column(name = "author", nullable = false)
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "publisher")
	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Column(name = "pub_date", length = 19)
	public Timestamp getPubDate() {
		return this.pubDate;
	}

	public void setPubDate(Timestamp pubDate) {
		this.pubDate = pubDate;
	}

	@Column(name = "numbers")
	public Integer getNumbers() {
		return this.numbers;
	}

	public void setNumbers(Integer numbers) {
		this.numbers = numbers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "book")
	public Set<Bookdesciption> getBookdesciptions() {
		return this.bookdesciptions;
	}

	public void setBookdesciptions(Set<Bookdesciption> bookdesciptions) {
		this.bookdesciptions = bookdesciptions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "book")
	public Set<Borrow> getBorrows() {
		return this.borrows;
	}

	public void setBorrows(Set<Borrow> borrows) {
		this.borrows = borrows;
	}

}