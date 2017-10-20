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
 * Askleave entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "askleave", catalog = "oa")
public class Askleave implements java.io.Serializable {

	// Fields

	private Integer alid;
	private Leavetype leavetype;
	private Department department;
	private Userinfo userinfo;
	private Timestamp alBeginTime;
	private Timestamp alEndTime;
	private String content;

	// Constructors

	/** default constructor */
	public Askleave() {
	}

	/** full constructor */
	public Askleave(Leavetype leavetype, Department department,
			Userinfo userinfo, Timestamp alBeginTime, Timestamp alEndTime,
			String content) {
		this.leavetype = leavetype;
		this.department = department;
		this.userinfo = userinfo;
		this.alBeginTime = alBeginTime;
		this.alEndTime = alEndTime;
		this.content = content;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ALId", unique = true, nullable = false)
	public Integer getAlid() {
		return this.alid;
	}

	public void setAlid(Integer alid) {
		this.alid = alid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "leaId", nullable = false)
	public Leavetype getLeavetype() {
		return this.leavetype;
	}

	public void setLeavetype(Leavetype leavetype) {
		this.leavetype = leavetype;
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
	@JoinColumn(name = "UserId", nullable = false)
	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	@Column(name = "AlBeginTime", nullable = false, length = 19)
	public Timestamp getAlBeginTime() {
		return this.alBeginTime;
	}

	public void setAlBeginTime(Timestamp alBeginTime) {
		this.alBeginTime = alBeginTime;
	}

	@Column(name = "AlEndTime", nullable = false, length = 19)
	public Timestamp getAlEndTime() {
		return this.alEndTime;
	}

	public void setAlEndTime(Timestamp alEndTime) {
		this.alEndTime = alEndTime;
	}

	@Column(name = "Content", nullable = false)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}