package com.direct.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Albumimg entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "albumimg", catalog = "oa")
public class Albumimg implements java.io.Serializable {

	// Fields

	private Integer albumImgId;
	private Album album;
	private String img;

	// Constructors

	/** default constructor */
	public Albumimg() {
	}

	/** full constructor */
	public Albumimg(Album album, String img) {
		this.album = album;
		this.img = img;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "AlbumImgId", unique = true, nullable = false)
	public Integer getAlbumImgId() {
		return this.albumImgId;
	}

	public void setAlbumImgId(Integer albumImgId) {
		this.albumImgId = albumImgId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AlbumId", nullable = false)
	public Album getAlbum() {
		return this.album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	@Column(name = "Img", nullable = false)
	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}