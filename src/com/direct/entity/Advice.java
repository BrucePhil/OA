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
 * Advice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "advice", catalog = "oa")
public class Advice implements java.io.Serializable {

	// Fields

	private Integer adviceId;
	private Userinfo userinfo;
	private String adviceTitle;
	private Timestamp crateTime;
	private String content;

	// Constructors

	/** default constructor */
	public Advice() {
	}

	/** minimal constructor */
	public Advice(Userinfo userinfo, String adviceTitle, Timestamp crateTime) {
		this.userinfo = userinfo;
		this.adviceTitle = adviceTitle;
		this.crateTime = crateTime;
	}

	/** full constructor */
	public Advice(Userinfo userinfo, String adviceTitle, Timestamp crateTime,
			String content) {
		this.userinfo = userinfo;
		this.adviceTitle = adviceTitle;
		this.crateTime = crateTime;
		this.content = content;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "adviceId", unique = true, nullable = false)
	public Integer getAdviceId() {
		return this.adviceId;
	}

	public void setAdviceId(Integer adviceId) {
		this.adviceId = adviceId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId", nullable = false)
	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	@Column(name = "adviceTitle", nullable = false)
	public String getAdviceTitle() {
		return this.adviceTitle;
	}

	public void setAdviceTitle(String adviceTitle) {
		this.adviceTitle = adviceTitle;
	}

	@Column(name = "CrateTime", nullable = false, length = 19)
	public Timestamp getCrateTime() {
		return this.crateTime;
	}

	public void setCrateTime(Timestamp crateTime) {
		this.crateTime = crateTime;
	}

	@Column(name = "Content")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}