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
 * Articletype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "articletype", catalog = "oa")
public class Articletype implements java.io.Serializable {

	// Fields

	private Integer articleTypeId;
	private String articleTypeName;
	private Set<Article> articles = new HashSet<Article>(0);

	// Constructors

	/** default constructor */
	public Articletype() {
	}

	/** minimal constructor */
	public Articletype(String articleTypeName) {
		this.articleTypeName = articleTypeName;
	}

	/** full constructor */
	public Articletype(String articleTypeName, Set<Article> articles) {
		this.articleTypeName = articleTypeName;
		this.articles = articles;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ArticleTypeId", unique = true, nullable = false)
	public Integer getArticleTypeId() {
		return this.articleTypeId;
	}

	public void setArticleTypeId(Integer articleTypeId) {
		this.articleTypeId = articleTypeId;
	}

	@Column(name = "ArticleTypeName", nullable = false)
	public String getArticleTypeName() {
		return this.articleTypeName;
	}

	public void setArticleTypeName(String articleTypeName) {
		this.articleTypeName = articleTypeName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "articletype")
	public Set<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

}