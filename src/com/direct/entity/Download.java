package com.direct.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Download entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "download", catalog = "oa")
public class Download implements java.io.Serializable {

	// Fields

	private Integer downloadId;
	private File file;
	private Userinfo userinfo;
	private Timestamp downloadTime;

	// Constructors

	/** default constructor */
	public Download() {
	}

	/** full constructor */
	public Download(File file, Userinfo userinfo, Timestamp downloadTime) {
		this.file = file;
		this.userinfo = userinfo;
		this.downloadTime = downloadTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "downloadId", unique = true, nullable = false)
	public Integer getDownloadId() {
		return this.downloadId;
	}

	public void setDownloadId(Integer downloadId) {
		this.downloadId = downloadId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fileId", nullable = false)
	public File getFile() {
		return this.file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId", nullable = false)
	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	@Column(name = "downloadTime", nullable = false, length = 19)
	public Timestamp getDownloadTime() {
		return this.downloadTime;
	}

	public void setDownloadTime(Timestamp downloadTime) {
		this.downloadTime = downloadTime;
	}

}