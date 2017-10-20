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
 * File entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "file", catalog = "oa")
public class File implements java.io.Serializable {

	// Fields

	private Integer fileId;
	private String fileName;
	private String filePath;
	private Integer number;
	private Set<Fileupload> fileuploads = new HashSet<Fileupload>(0);
	private Set<Download> downloads = new HashSet<Download>(0);

	// Constructors

	/** default constructor */
	public File() {
	}

	/** minimal constructor */
	public File(String fileName) {
		this.fileName = fileName;
	}

	/** full constructor */
	public File(String fileName, String filePath, Integer number,
			Set<Fileupload> fileuploads, Set<Download> downloads) {
		this.fileName = fileName;
		this.filePath = filePath;
		this.number = number;
		this.fileuploads = fileuploads;
		this.downloads = downloads;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "fileId", unique = true, nullable = false)
	public Integer getFileId() {
		return this.fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	@Column(name = "fileName", nullable = false)
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "filePath")
	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Column(name = "Number")
	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "file")
	public Set<Fileupload> getFileuploads() {
		return this.fileuploads;
	}

	public void setFileuploads(Set<Fileupload> fileuploads) {
		this.fileuploads = fileuploads;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "file")
	public Set<Download> getDownloads() {
		return this.downloads;
	}

	public void setDownloads(Set<Download> downloads) {
		this.downloads = downloads;
	}

}