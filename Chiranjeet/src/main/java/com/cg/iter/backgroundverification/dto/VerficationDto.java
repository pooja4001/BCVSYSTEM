package com.cg.iter.backgroundverification.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
@Entity
@Table(name = "verificationdetails")
public class VerficationDto
{
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="requestId")
	private int verId;
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="requestStartDate")
	private Date startDate;
	@Temporal(TemporalType.DATE)
	@Column(name="requestEndDate")
	private Date endDate;
	@Column(name="requestStatus")
	private String status;

	public int getVerId() {
		return verId;
	}

	public void setVerId(int verId) {
		this.verId = verId;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
