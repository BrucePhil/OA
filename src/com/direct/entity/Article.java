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
 * Article entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "article", catalog = "oa")
public class Article implements java.io.Serializable {

	// Fields

	private Integer articleId;
	private Articletype articletype;
	private Userinfo userinfo;
	private String articleTitle;
	private Timestamp articleCreatTime;
	private Integer pageView;
	private String content;

	// Constructors

	/** default constructor */
	public Article() {
	}

	/** minimal constructor */
	public Article(Userinfo userinfo, String articleTitle,
			Timestamp articleCreatTime) {
		this.userinfo = userinfo;
		this.articleTitle = articleTitle;
		this.articleCreatTime = articleCreatTime;
	}

	/** full constructor */
	public Article(Articletype articletype, Userinfo userinfo,
			String articleTitle, Timestamp articleCreatTime, Integer pageView,
			String content) {
		this.articletype = articletype;
		this.userinfo = userinfo;
		this.articleTitle = articleTitle;
		this.articleCreatTime = articleCreatTime;
		this.pageView = pageView;
		this.content = content;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ArticleId", unique = true, nullable = false)
	public Integer getArticleId() {
		return this.articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ArticleTypeId")
	public Articletype getArticletype() {
		return this.articletype;
	}

	public void setArticletype(Articletype articletype) {
		this.articletype = articletype;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId", nullable = false)
	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	@Column(name = "ArticleTitle", nullable = false)
	public String getArticleTitle() {
		return this.articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	@Column(name = "ArticleCreatTime", nullable = false, length = 19)
	public Timestamp getArticleCreatTime() {
		return this.articleCreatTime;
	}

	public void setArticleCreatTime(Timestamp articleCreatTime) {
		this.articleCreatTime = articleCreatTime;
	}

	@Column(name = "pageView")
	public Integer getPageView() {
		return this.pageView;
	}

	public void setPageView(Integer pageView) {
		this.pageView = pageView;
	}

	@Column(name = "Content")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}