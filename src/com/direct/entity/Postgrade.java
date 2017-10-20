package com.direct.entity;

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
 * Postgrade entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "postgrade", catalog = "oa")
public class Postgrade implements java.io.Serializable {

	// Fields

	private Integer pgid;
	private String pgname;
	private Set<Userinfo> userinfos = new HashSet<Userinfo>(0);

	// Constructors

	/** default constructor */
	public Postgrade() {
	}

	/** minimal constructor */
	public Postgrade(String pgname) {
		this.pgname = pgname;
	}

	/** full constructor */
	public Postgrade(String pgname, Set<Userinfo> userinfos) {
		this.pgname = pgname;
		this.userinfos = userinfos;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "PGId", unique = true, nullable = false)
	public Integer getPgid() {
		return this.pgid;
	}

	public void setPgid(Integer pgid) {
		this.pgid = pgid;
	}

	@Column(name = "PGName", nullable = false)
	public String getPgname() {
		return this.pgname;
	}

	public void setPgname(String pgname) {
		this.pgname = pgname;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "postgrade")
	public Set<Userinfo> getUserinfos() {
		return this.userinfos;
	}

	public void setUserinfos(Set<Userinfo> userinfos) {
		this.userinfos = userinfos;
	}

}