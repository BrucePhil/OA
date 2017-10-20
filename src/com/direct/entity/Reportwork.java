package com.direct.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Reportwork entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "reportwork", catalog = "oa")
public class Reportwork implements java.io.Serializable {

	// Fields

	private Integer reId;
	private Reportype reportype;
	private Userinfo userinfo;
	private Date reTime;
	private String reContent;

	// Constructors

	/** default constructor */
	public Reportwork() {
	}

	/** full constructor */
	public Reportwork(Reportype reportype, Userinfo userinfo, Date reTime,
			String reContent) {
		this.reportype = reportype;
		this.userinfo = userinfo;
		this.reTime = reTime;
		this.reContent = reContent;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "reId", unique = true, nullable = false)
	public Integer getReId() {
		return this.reId;
	}

	public void setReId(Integer reId) {
		this.reId = reId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "retypeId", nullable = false)
	public Reportype getReportype() {
		return this.reportype;
	}

	public void setReportype(Reportype reportype) {
		this.reportype = reportype;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId", nullable = false)
	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "reTime", nullable = false, length = 10)
	public Date getReTime() {
		return this.reTime;
	}

	public void setReTime(Date reTime) {
		this.reTime = reTime;
	}

	@Column(name = "reContent", nullable = false)
	public String getReContent() {
		return this.reContent;
	}

	public void setReContent(String reContent) {
		this.reContent = reContent;
	}

}