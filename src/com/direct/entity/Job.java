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
 * Job entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "job", catalog = "oa")
public class Job implements java.io.Serializable {

	// Fields

	private Integer jobId;
	private String jobName;
	private Set<Role> roles = new HashSet<Role>(0);
	private Set<Userinfo> userinfos = new HashSet<Userinfo>(0);

	// Constructors

	/** default constructor */
	public Job() {
	}

	/** minimal constructor */
	public Job(String jobName) {
		this.jobName = jobName;
	}

	/** full constructor */
	public Job(String jobName, Set<Role> roles, Set<Userinfo> userinfos) {
		this.jobName = jobName;
		this.roles = roles;
		this.userinfos = userinfos;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "jobId", unique = true, nullable = false)
	public Integer getJobId() {
		return this.jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	@Column(name = "jobName", nullable = false)
	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "job")
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "job")
	public Set<Userinfo> getUserinfos() {
		return this.userinfos;
	}

	public void setUserinfos(Set<Userinfo> userinfos) {
		this.userinfos = userinfos;
	}

}