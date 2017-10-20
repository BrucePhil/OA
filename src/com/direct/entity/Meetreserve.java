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
 * Meetreserve entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "meetreserve", catalog = "oa")
public class Meetreserve implements java.io.Serializable {

	// Fields

	private Integer meetResId;
	private Userinfo userinfo;
	private String meetTitle;
	private Timestamp meetBeginTime;
	private Timestamp meetEndTime;
	private String mobPhone;
	private Integer floor;
	private String room;

	// Constructors

	/** default constructor */
	public Meetreserve() {
	}

	/** minimal constructor */
	public Meetreserve(Userinfo userinfo, String meetTitle,
			Timestamp meetBeginTime, Timestamp meetEndTime, String mobPhone) {
		this.userinfo = userinfo;
		this.meetTitle = meetTitle;
		this.meetBeginTime = meetBeginTime;
		this.meetEndTime = meetEndTime;
		this.mobPhone = mobPhone;
	}

	/** full constructor */
	public Meetreserve(Userinfo userinfo, String meetTitle,
			Timestamp meetBeginTime, Timestamp meetEndTime, String mobPhone,
			Integer floor, String room) {
		this.userinfo = userinfo;
		this.meetTitle = meetTitle;
		this.meetBeginTime = meetBeginTime;
		this.meetEndTime = meetEndTime;
		this.mobPhone = mobPhone;
		this.floor = floor;
		this.room = room;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "MeetResId", unique = true, nullable = false)
	public Integer getMeetResId() {
		return this.meetResId;
	}

	public void setMeetResId(Integer meetResId) {
		this.meetResId = meetResId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId", nullable = false)
	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	@Column(name = "MeetTitle", nullable = false)
	public String getMeetTitle() {
		return this.meetTitle;
	}

	public void setMeetTitle(String meetTitle) {
		this.meetTitle = meetTitle;
	}

	@Column(name = "MeetBeginTime", nullable = false, length = 19)
	public Timestamp getMeetBeginTime() {
		return this.meetBeginTime;
	}

	public void setMeetBeginTime(Timestamp meetBeginTime) {
		this.meetBeginTime = meetBeginTime;
	}

	@Column(name = "MeetEndTime", nullable = false, length = 19)
	public Timestamp getMeetEndTime() {
		return this.meetEndTime;
	}

	public void setMeetEndTime(Timestamp meetEndTime) {
		this.meetEndTime = meetEndTime;
	}

	@Column(name = "MobPhone", nullable = false)
	public String getMobPhone() {
		return this.mobPhone;
	}

	public void setMobPhone(String mobPhone) {
		this.mobPhone = mobPhone;
	}

	@Column(name = "floor")
	public Integer getFloor() {
		return this.floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	@Column(name = "Room")
	public String getRoom() {
		return this.room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

}