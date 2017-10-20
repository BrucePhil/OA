package com.direct.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Personalinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "personalinfo", catalog = "oa")
public class Personalinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private Userinfo userinfo;
	private String perName;
	private String perSex;
	private Date perBir;
	private String perPook;
	private String landPhone;
	private String mobPhone;
	private String eamil;
	private String communication;
	private String hobby;
	private String specialey;
	private String resume;

	// Constructors

	/** default constructor */
	public Personalinfo() {
	}

	/** minimal constructor */
	public Personalinfo(Userinfo userinfo, String perName, String perSex,
			Date perBir, String perPook, String mobPhone, String eamil) {
		this.userinfo = userinfo;
		this.perName = perName;
		this.perSex = perSex;
		this.perBir = perBir;
		this.perPook = perPook;
		this.mobPhone = mobPhone;
		this.eamil = eamil;
	}

	/** full constructor */
	public Personalinfo(Userinfo userinfo, String perName, String perSex,
			Date perBir, String perPook, String landPhone, String mobPhone,
			String eamil, String communication, String hobby, String specialey,
			String resume) {
		this.userinfo = userinfo;
		this.perName = perName;
		this.perSex = perSex;
		this.perBir = perBir;
		this.perPook = perPook;
		this.landPhone = landPhone;
		this.mobPhone = mobPhone;
		this.eamil = eamil;
		this.communication = communication;
		this.hobby = hobby;
		this.specialey = specialey;
		this.resume = resume;
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
	@JoinColumn(name = "UserId", nullable = false)
	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	@Column(name = "PerName", nullable = false)
	public String getPerName() {
		return this.perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}

	@Column(name = "PerSex", nullable = false)
	public String getPerSex() {
		return this.perSex;
	}

	public void setPerSex(String perSex) {
		this.perSex = perSex;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PerBir", nullable = false, length = 10)
	public Date getPerBir() {
		return this.perBir;
	}

	public void setPerBir(Date perBir) {
		this.perBir = perBir;
	}

	@Column(name = "PerPook", nullable = false)
	public String getPerPook() {
		return this.perPook;
	}

	public void setPerPook(String perPook) {
		this.perPook = perPook;
	}

	@Column(name = "LandPhone")
	public String getLandPhone() {
		return this.landPhone;
	}

	public void setLandPhone(String landPhone) {
		this.landPhone = landPhone;
	}

	@Column(name = "MobPhone", nullable = false)
	public String getMobPhone() {
		return this.mobPhone;
	}

	public void setMobPhone(String mobPhone) {
		this.mobPhone = mobPhone;
	}

	@Column(name = "Eamil", nullable = false)
	public String getEamil() {
		return this.eamil;
	}

	public void setEamil(String eamil) {
		this.eamil = eamil;
	}

	@Column(name = "communication")
	public String getCommunication() {
		return this.communication;
	}

	public void setCommunication(String communication) {
		this.communication = communication;
	}

	@Column(name = "hobby")
	public String getHobby() {
		return this.hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Column(name = "specialey")
	public String getSpecialey() {
		return this.specialey;
	}

	public void setSpecialey(String specialey) {
		this.specialey = specialey;
	}

	@Column(name = "resume")
	public String getResume() {
		return this.resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

}