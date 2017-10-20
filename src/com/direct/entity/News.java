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
 * News entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "news", catalog = "oa")
public class News implements java.io.Serializable {

	// Fields

	private Integer newId;
	private Userinfo userinfo;
	private Newtype newtype;
	private String newTitle;
	private Timestamp newReleaseTime;
	private Integer pageView;
	private String content;

	// Constructors

	/** default constructor */
	public News() {
	}

	/** minimal constructor */
	public News(Userinfo userinfo, Newtype newtype, String newTitle,
			Timestamp newReleaseTime) {
		this.userinfo = userinfo;
		this.newtype = newtype;
		this.newTitle = newTitle;
		this.newReleaseTime = newReleaseTime;
	}

	/** full constructor */
	public News(Userinfo userinfo, Newtype newtype, String newTitle,
			Timestamp newReleaseTime, Integer pageView, String content) {
		this.userinfo = userinfo;
		this.newtype = newtype;
		this.newTitle = newTitle;
		this.newReleaseTime = newReleaseTime;
		this.pageView = pageView;
		this.content = content;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "newId", unique = true, nullable = false)
	public Integer getNewId() {
		return this.newId;
	}

	public void setNewId(Integer newId) {
		this.newId = newId;
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
	@JoinColumn(name = "newTypeId", nullable = false)
	public Newtype getNewtype() {
		return this.newtype;
	}

	public void setNewtype(Newtype newtype) {
		this.newtype = newtype;
	}

	@Column(name = "newTitle", nullable = false)
	public String getNewTitle() {
		return this.newTitle;
	}

	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}

	@Column(name = "newReleaseTime", nullable = false, length = 19)
	public Timestamp getNewReleaseTime() {
		return this.newReleaseTime;
	}

	public void setNewReleaseTime(Timestamp newReleaseTime) {
		this.newReleaseTime = newReleaseTime;
	}

	@Column(name = "pageView")
	public Integer getPageView() {
		return this.pageView;
	}

	public void setPageView(Integer pageView) {
		this.pageView = pageView;
	}

	@Column(name = "Content")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}