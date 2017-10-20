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
 * Newtype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "newtype", catalog = "oa")
public class Newtype implements java.io.Serializable {

	// Fields

	private Integer newTypeId;
	private String newTypeName;
	private Set<News> newses = new HashSet<News>(0);

	// Constructors

	/** default constructor */
	public Newtype() {
	}

	/** minimal constructor */
	public Newtype(String newTypeName) {
		this.newTypeName = newTypeName;
	}

	/** full constructor */
	public Newtype(String newTypeName, Set<News> newses) {
		this.newTypeName = newTypeName;
		this.newses = newses;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "newTypeId", unique = true, nullable = false)
	public Integer getNewTypeId() {
		return this.newTypeId;
	}

	public void setNewTypeId(Integer newTypeId) {
		this.newTypeId = newTypeId;
	}

	@Column(name = "newTypeName", nullable = false)
	public String getNewTypeName() {
		return this.newTypeName;
	}

	public void setNewTypeName(String newTypeName) {
		this.newTypeName = newTypeName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "newtype")
	public Set<News> getNewses() {
		return this.newses;
	}

	public void setNewses(Set<News> newses) {
		this.newses = newses;
	}

}