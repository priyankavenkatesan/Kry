package com.kry.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Model object
 * 
 * @author PVENKAT1
 *
 */
@Entity
@Table(name = "Kry")
public class Kry {

	@Id
	@Column(name = "service_name")
	private String serviceName;

	@Column(name = "url")
	private String url;

	@Column(name = "active_ind")
	private String active;

	@Column(name = "created_time")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	@Column(name = "updated_time")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedTime;

	public Kry() {
	}

	public Kry(String serviceName, String url, String active) {

		this.serviceName = serviceName;
		this.url = url;
		this.active = active;

	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
}
