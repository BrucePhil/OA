package com.direct.entity;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "userinfo", catalog = "oa")
public class Userinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private Positiontype positiontype;
	private Postgrade postgrade;
	private Job job;
	private Department department;
	private String userName;
	private String userPwd;
	private Date userTime;
	private Set<News> newses = new HashSet<News>(0);
	private Set<Article> articles = new HashSet<Article>(0);
	private Set<Department> departments = new HashSet<Department>(0);
	private Set<Album> albums = new HashSet<Album>(0);
	private Set<Advice> advices = new HashSet<Advice>(0);
	private Set<Usecar> usecars = new HashSet<Usecar>(0);
	private Set<Fileupload> fileuploads = new HashSet<Fileupload>(0);
	private Set<Personalinfo> personalinfos = new HashSet<Personalinfo>(0);
	private Set<Meetreserve> meetreserves = new HashSet<Meetreserve>(0);
	private Set<Role> roles = new HashSet<Role>(0);
	private Set<Askleave> askleaves = new HashSet<Askleave>(0);
	private Set<Meetrecord> meetrecords = new HashSet<Meetrecord>(0);
	private Set<Download> downloads = new HashSet<Download>(0);
	private Set<Reportwork> reportworks = new HashSet<Reportwork>(0);
	private Set<Borrow> borrows = new HashSet<Borrow>(0);

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** minimal constructor */
	public Userinfo(Positiontype positiontype, Postgrade postgrade, Job job,
			Department department, String userName, String userPwd,
			Date userTime) {
		this.positiontype = positiontype;
		this.postgrade = postgrade;
		this.job = job;
		this.department = department;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userTime = userTime;
	}

	/** full constructor */
	public Userinfo(Positiontype positiontype, Postgrade postgrade, Job job,
			Department department, String userName, String userPwd,
			Date userTime, Set<News> newses, Set<Article> articles,
			Set<Department> departments, Set<Album> albums,
			Set<Advice> advices, Set<Usecar> usecars,
			Set<Fileupload> fileuploads, Set<Personalinfo> personalinfos,
			Set<Meetreserve> meetreserves, Set<Role> roles,
			Set<Askleave> askleaves, Set<Meetrecord> meetrecords,
			Set<Download> downloads, Set<Reportwork> reportworks,
			Set<Borrow> borrows) {
		this.positiontype = positiontype;
		this.postgrade = postgrade;
		this.job = job;
		this.department = department;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userTime = userTime;
		this.newses = newses;
		this.articles = articles;
		this.departments = departments;
		this.albums = albums;
		this.advices = advices;
		this.usecars = usecars;
		this.fileuploads = fileuploads;
		this.personalinfos = personalinfos;
		this.meetreserves = meetreserves;
		this.roles = roles;
		this.askleaves = askleaves;
		this.meetrecords = meetrecords;
		this.downloads = downloads;
		this.reportworks = reportworks;
		this.borrows = borrows;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PositionTypeId", nullable = false)
	public Positiontype getPositiontype() {
		return this.positiontype;
	}

	public void setPositiontype(Positiontype positiontype) {
		this.positiontype = positiontype;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PGId", nullable = false)
	public Postgrade getPostgrade() {
		return this.postgrade;
	}

	public void setPostgrade(Postgrade postgrade) {
		this.postgrade = postgrade;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JobId", nullable = false)
	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "depId", nullable = false)
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Column(name = "UserName", nullable = false)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "UserPwd", nullable = false)
	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UserTime", nullable = false, length = 10)
	public Date getUserTime() {
		return this.userTime;
	}

	public void setUserTime(Date userTime) {
		this.userTime = userTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userinfo")
	public Set<News> getNewses() {
		return this.newses;
	}

	public void setNewses(Set<News> newses) {
		this.newses = newses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userinfo")
	public Set<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userinfo")
	public Set<Department> getDepartments() {
		return this.departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userinfo")
	public Set<Album> getAlbums() {
		return this.albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userinfo")
	public Set<Advice> getAdvices() {
		return this.advices;
	}

	public void setAdvices(Set<Advice> advices) {
		this.advices = advices;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userinfo")
	public Set<Usecar> getUsecars() {
		return this.usecars;
	}

	public void setUsecars(Set<Usecar> usecars) {
		this.usecars = usecars;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userinfo")
	public Set<Fileupload> getFileuploads() {
		return this.fileuploads;
	}

	public void setFileuploads(Set<Fileupload> fileuploads) {
		this.fileuploads = fileuploads;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userinfo")
	public Set<Personalinfo> getPersonalinfos() {
		return this.personalinfos;
	}

	public void setPersonalinfos(Set<Personalinfo> personalinfos) {
		this.personalinfos = personalinfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userinfo")
	public Set<Meetreserve> getMeetreserves() {
		return this.meetreserves;
	}

	public void setMeetreserves(Set<Meetreserve> meetreserves) {
		this.meetreserves = meetreserves;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userinfo")
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userinfo")
	public Set<Askleave> getAskleaves() {
		return this.askleaves;
	}

	public void setAskleaves(Set<Askleave> askleaves) {
		this.askleaves = askleaves;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userinfo")
	public Set<Meetrecord> getMeetrecords() {
		return this.meetrecords;
	}

	public void setMeetrecords(Set<Meetrecord> meetrecords) {
		this.meetrecords = meetrecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userinfo")
	public Set<Download> getDownloads() {
		return this.downloads;
	}

	public void setDownloads(Set<Download> downloads) {
		this.downloads = downloads;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userinfo")
	public Set<Reportwork> getReportworks() {
		return this.reportworks;
	}

	public void setReportworks(Set<Reportwork> reportworks) {
		this.reportworks = reportworks;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userinfo")
	public Set<Borrow> getBorrows() {
		return this.borrows;
	}

	public void setBorrows(Set<Borrow> borrows) {
		this.borrows = borrows;
	}

}