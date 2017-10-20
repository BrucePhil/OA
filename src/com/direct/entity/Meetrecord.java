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
 * Meetrecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "meetrecord", catalog = "oa")
public class Meetrecord implements java.io.Serializable {

	// Fields

	private Integer meetId;
	private Department department;
	private Userinfo userinfo;
	private String meetName;
	private Timestamp meetBeginTime;
	private Timestamp meetEndTime;

	// Constructors

	/** default constructor */
	public Meetrecord() {
	}

	/** full constructor */
	public Meetrecord(Department department, Userinfo userinfo,
			String meetName, Timestamp meetBeginTime, Timestamp meetEndTime) {
		this.department = department;
		this.userinfo = userinfo;
		this.meetName = meetName;
		this.meetBeginTime = meetBeginTime;
		this.meetEndTime = meetEndTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "meetId", unique = true, nullable = false)
	public Integer getMeetId() {
		return this.meetId;
	}

	public void setMeetId(Integer meetId) {
		this.meetId = meetId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "depId", nullable = false)
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	@Column(name = "meetName", nullable = false)
	public String getMeetName() {
		return this.meetName;
	}

	public void setMeetName(String meetName) {
		this.meetName = meetName;
	}

	@Column(name = "meetBeginTime", nullable = false, length = 19)
	public Timestamp getMeetBeginTime() {
		return this.meetBeginTime;
	}

	public void setMeetBeginTime(Timestamp meetBeginTime) {
		this.meetBeginTime = meetBeginTime;
	}

	@Column(name = "meetEndTime", nullable = false, length = 19)
	public Timestamp getMeetEndTime() {
		return this.meetEndTime;
	}

	public void setMeetEndTime(Timestamp meetEndTime) {
		this.meetEndTime = meetEndTime;
	}

}