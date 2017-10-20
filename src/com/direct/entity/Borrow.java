package com.direct.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Borrow entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "borrow", catalog = "oa")
public class Borrow implements java.io.Serializable {

	// Fields

	private Integer brId;
	private Userinfo userinfo;
	private Book book;
	private Timestamp begindate;
	private Timestamp enddate;
	private String remak;

	// Constructors

	/** default constructor */
	public Borrow() {
	}

	/** minimal constructor */
	public Borrow(Userinfo userinfo, Book book, Timestamp begindate) {
		this.userinfo = userinfo;
		this.book = book;
		this.begindate = begindate;
	}

	/** full constructor */
	public Borrow(Userinfo userinfo, Book book, Timestamp begindate,
			Timestamp enddate, String remak) {
		this.userinfo = userinfo;
		this.book = book;
		this.begindate = begindate;
		this.enddate = enddate;
		this.remak = remak;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "BrId", unique = true, nullable = false)
	public Integer getBrId() {
		return this.brId;
	}

	public void setBrId(Integer brId) {
		this.brId = brId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId", nullable = false)
	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookId", nullable = false)
	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Column(name = "begindate", nullable = false, length = 19)
	public Timestamp getBegindate() {
		return this.begindate;
	}

	public void setBegindate(Timestamp begindate) {
		this.begindate = begindate;
	}

	@Column(name = "enddate", length = 19)
	public Timestamp getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
	}

	@Column(name = "remak")
	public String getRemak() {
		return this.remak;
	}

	public void setRemak(String remak) {
		this.remak = remak;
	}

}