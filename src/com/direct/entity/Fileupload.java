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
 * Fileupload entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "fileupload", catalog = "oa")
public class Fileupload implements java.io.Serializable {

	// Fields

	private Integer uploadId;
	private File file;
	private Userinfo userinfo;
	private Timestamp uploadTime;

	// Constructors

	/** default constructor */
	public Fileupload() {
	}

	/** full constructor */
	public Fileupload(File file, Userinfo userinfo, Timestamp uploadTime) {
		this.file = file;
		this.userinfo = userinfo;
		this.uploadTime = uploadTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "UploadId", unique = true, nullable = false)
	public Integer getUploadId() {
		return this.uploadId;
	}

	public void setUploadId(Integer uploadId) {
		this.uploadId = uploadId;
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

	@Column(name = "UploadTime", nullable = false, length = 19)
	public Timestamp getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}

}