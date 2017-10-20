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
 * Positiontype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "positiontype", catalog = "oa")
public class Positiontype implements java.io.Serializable {

	// Fields

	private Integer positionTypeId;
	private String positionTypeName;
	private Set<Userinfo> userinfos = new HashSet<Userinfo>(0);

	// Constructors

	/** default constructor */
	public Positiontype() {
	}

	/** minimal constructor */
	public Positiontype(String positionTypeName) {
		this.positionTypeName = positionTypeName;
	}

	/** full constructor */
	public Positiontype(String positionTypeName, Set<Userinfo> userinfos) {
		this.positionTypeName = positionTypeName;
		this.userinfos = userinfos;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "PositionTypeId", unique = true, nullable = false)
	public Integer getPositionTypeId() {
		return this.positionTypeId;
	}

	public void setPositionTypeId(Integer positionTypeId) {
		this.positionTypeId = positionTypeId;
	}

	@Column(name = "PositionTypeName", nullable = false)
	public String getPositionTypeName() {
		return this.positionTypeName;
	}

	public void setPositionTypeName(String positionTypeName) {
		this.positionTypeName = positionTypeName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "positiontype")
	public Set<Userinfo> getUserinfos() {
		return this.userinfos;
	}

	public void setUserinfos(Set<Userinfo> userinfos) {
		this.userinfos = userinfos;
	}

}