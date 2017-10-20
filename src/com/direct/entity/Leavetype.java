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
 * Leavetype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "leavetype", catalog = "oa")
public class Leavetype implements java.io.Serializable {

	// Fields

	private Integer leaId;
	private String leaTypeName;
	private Set<Askleave> askleaves = new HashSet<Askleave>(0);

	// Constructors

	/** default constructor */
	public Leavetype() {
	}

	/** minimal constructor */
	public Leavetype(String leaTypeName) {
		this.leaTypeName = leaTypeName;
	}

	/** full constructor */
	public Leavetype(String leaTypeName, Set<Askleave> askleaves) {
		this.leaTypeName = leaTypeName;
		this.askleaves = askleaves;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "leaId", unique = true, nullable = false)
	public Integer getLeaId() {
		return this.leaId;
	}

	public void setLeaId(Integer leaId) {
		this.leaId = leaId;
	}

	@Column(name = "leaTypeName", nullable = false)
	public String getLeaTypeName() {
		return this.leaTypeName;
	}

	public void setLeaTypeName(String leaTypeName) {
		this.leaTypeName = leaTypeName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "leavetype")
	public Set<Askleave> getAskleaves() {
		return this.askleaves;
	}

	public void setAskleaves(Set<Askleave> askleaves) {
		this.askleaves = askleaves;
	}

}