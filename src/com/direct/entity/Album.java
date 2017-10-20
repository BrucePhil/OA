package com.direct.entity;

import java.sql.Timestamp;
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
 * Album entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "album", catalog = "oa")
public class Album implements java.io.Serializable {

	// Fields

	private Integer albumId;
	private Userinfo userinfo;
	private String albumName;
	private Timestamp createTime;
	private String albumRemack;
	private Set<Albumimg> albumimgs = new HashSet<Albumimg>(0);

	// Constructors

	/** default constructor */
	public Album() {
	}

	/** minimal constructor */
	public Album(Userinfo userinfo, String albumName) {
		this.userinfo = userinfo;
		this.albumName = albumName;
	}

	/** full constructor */
	public Album(Userinfo userinfo, String albumName, Timestamp createTime,
			String albumRemack, Set<Albumimg> albumimgs) {
		this.userinfo = userinfo;
		this.albumName = albumName;
		this.createTime = createTime;
		this.albumRemack = albumRemack;
		this.albumimgs = albumimgs;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "AlbumId", unique = true, nullable = false)
	public Integer getAlbumId() {
		return this.albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId", nullable = false)
	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	@Column(name = "AlbumName", nullable = false)
	public String getAlbumName() {
		return this.albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	@Column(name = "CreateTime", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "AlbumRemack")
	public String getAlbumRemack() {
		return this.albumRemack;
	}

	public void setAlbumRemack(String albumRemack) {
		this.albumRemack = albumRemack;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "album")
	public Set<Albumimg> getAlbumimgs() {
		return this.albumimgs;
	}

	public void setAlbumimgs(Set<Albumimg> albumimgs) {
		this.albumimgs = albumimgs;
	}

}