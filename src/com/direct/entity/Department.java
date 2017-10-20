package com.direct.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "department", catalog = "oa")
public class Department implements java.io.Serializable {

	// Fields

	private Integer depId;
	private Userinfo userinfo;
	private String depName;
	private String depRemak;
	private Set<Userinfo> userinfos = new HashSet<Userinfo>(0);
	private Set<Meetrecord> meetrecords = new HashSet<Meetrecord>(0);
	private Set<Askleave> askleaves = new HashSet<Askleave>(0);

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** minimal constructor */
	public Department(String depName) {
		this.depName = depName;
	}

	/** full constructor */
	public Department(Userinfo userinfo, String depName, String depRemak,
			Set<Userinfo> userinfos, Set<Meetrecord> meetrecords,
			Set<Askleave> askleaves) {
		this.userinfo = userinfo;
		this.depName = depName;
		this.depRemak = depRemak;
		this.userinfos = userinfos;
		this.meetrecords = meetrecords;
		this.askleaves = askleaves;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "depId", unique = true, nullable = false)
	public Integer getDepId() {
		return this.depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "perId")
	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	@Column(name = "depName", nullable = false)
	public String getDepName() {
		return this.depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	@Column(name = "depRemak")
	public String getDepRemak() {
		return this.depRemak;
	}

	public void setDepRemak(String depRemak) {
		this.depRemak = depRemak;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Userinfo> getUserinfos() {
		return this.userinfos;
	}

	public void setUserinfos(Set<Userinfo> userinfos) {
		this.userinfos = userinfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Meetrecord> getMeetrecords() {
		return this.meetrecords;
	}

	public void setMeetrecords(Set<Meetrecord> meetrecords) {
		this.meetrecords = meetrecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Askleave> getAskleaves() {
		return this.askleaves;
	}

	public void setAskleaves(Set<Askleave> askleaves) {
		this.askleaves = askleaves;
	}

}