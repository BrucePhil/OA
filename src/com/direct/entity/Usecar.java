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
 * Usecar entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "usecar", catalog = "oa")
public class Usecar implements java.io.Serializable {

	// Fields

	private Integer useCarId;
	private Vehicle vehicle;
	private Userinfo userinfo;
	private String mobPhone;
	private String content;
	private Timestamp beginTime;
	private Timestamp endTime;

	// Constructors

	/** default constructor */
	public Usecar() {
	}

	/** minimal constructor */
	public Usecar(Vehicle vehicle, Userinfo userinfo, String mobPhone,
			String content, Timestamp beginTime) {
		this.vehicle = vehicle;
		this.userinfo = userinfo;
		this.mobPhone = mobPhone;
		this.content = content;
		this.beginTime = beginTime;
	}

	/** full constructor */
	public Usecar(Vehicle vehicle, Userinfo userinfo, String mobPhone,
			String content, Timestamp beginTime, Timestamp endTime) {
		this.vehicle = vehicle;
		this.userinfo = userinfo;
		this.mobPhone = mobPhone;
		this.content = content;
		this.beginTime = beginTime;
		this.endTime = endTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "UseCarId", unique = true, nullable = false)
	public Integer getUseCarId() {
		return this.useCarId;
	}

	public void setUseCarId(Integer useCarId) {
		this.useCarId = useCarId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VehicleId", nullable = false)
	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId", nullable = false)
	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	@Column(name = "MobPhone", nullable = false)
	public String getMobPhone() {
		return this.mobPhone;
	}

	public void setMobPhone(String mobPhone) {
		this.mobPhone = mobPhone;
	}

	@Column(name = "Content", nullable = false)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "BeginTime", nullable = false, length = 19)
	public Timestamp getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	@Column(name = "EndTime", length = 19)
	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

}