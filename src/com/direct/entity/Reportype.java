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
 * Reportype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "reportype", catalog = "oa")
public class Reportype implements java.io.Serializable {

	// Fields

	private Integer reTypeId;
	private String reTypeName;
	private Set<Reportwork> reportworks = new HashSet<Reportwork>(0);

	// Constructors

	/** default constructor */
	public Reportype() {
	}

	/** minimal constructor */
	public Reportype(String reTypeName) {
		this.reTypeName = reTypeName;
	}

	/** full constructor */
	public Reportype(String reTypeName, Set<Reportwork> reportworks) {
		this.reTypeName = reTypeName;
		this.reportworks = reportworks;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ReTypeId", unique = true, nullable = false)
	public Integer getReTypeId() {
		return this.reTypeId;
	}

	public void setReTypeId(Integer reTypeId) {
		this.reTypeId = reTypeId;
	}

	@Column(name = "ReTypeName", nullable = false)
	public String getReTypeName() {
		return this.reTypeName;
	}

	public void setReTypeName(String reTypeName) {
		this.reTypeName = reTypeName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "reportype")
	public Set<Reportwork> getReportworks() {
		return this.reportworks;
	}

	public void setReportworks(Set<Reportwork> reportworks) {
		this.reportworks = reportworks;
	}

}