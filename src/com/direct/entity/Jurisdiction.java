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
 * Jurisdiction entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jurisdiction", catalog = "oa")
public class Jurisdiction implements java.io.Serializable {

	// Fields

	private Integer jurId;
	private Role role;
	private String jurName;

	// Constructors

	/** default constructor */
	public Jurisdiction() {
	}

	/** minimal constructor */
	public Jurisdiction(String jurName) {
		this.jurName = jurName;
	}

	/** full constructor */
	public Jurisdiction(Role role, String jurName) {
		this.role = role;
		this.jurName = jurName;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "JurId", unique = true, nullable = false)
	public Integer getJurId() {
		return this.jurId;
	}

	public void setJurId(Integer jurId) {
		this.jurId = jurId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleId")
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "JurName", nullable = false)
	public String getJurName() {
		return this.jurName;
	}

	public void setJurName(String jurName) {
		this.jurName = jurName;
	}

}