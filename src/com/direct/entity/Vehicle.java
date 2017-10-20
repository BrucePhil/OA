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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Vehicle entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "vehicle", catalog = "oa")
public class Vehicle implements java.io.Serializable {

	// Fields

	private Integer vehicleId;
	private String vehicleName;
	private Date buyTime;
	private Set<Usecar> usecars = new HashSet<Usecar>(0);

	// Constructors

	/** default constructor */
	public Vehicle() {
	}

	/** minimal constructor */
	public Vehicle(String vehicleName, Date buyTime) {
		this.vehicleName = vehicleName;
		this.buyTime = buyTime;
	}

	/** full constructor */
	public Vehicle(String vehicleName, Date buyTime, Set<Usecar> usecars) {
		this.vehicleName = vehicleName;
		this.buyTime = buyTime;
		this.usecars = usecars;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "VehicleId", unique = true, nullable = false)
	public Integer getVehicleId() {
		return this.vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	@Column(name = "VehicleName", nullable = false)
	public String getVehicleName() {
		return this.vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BuyTime", nullable = false, length = 10)
	public Date getBuyTime() {
		return this.buyTime;
	}

	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "vehicle")
	public Set<Usecar> getUsecars() {
		return this.usecars;
	}

	public void setUsecars(Set<Usecar> usecars) {
		this.usecars = usecars;
	}

}