package com.tutu.shopping.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AccessLog {
	@Id
	@GeneratedValue
	private int id;
	private Date accesstime;
	private String ip;
	private String requrl;
	private String detail;
	public int getId() {
		return id;
	}
	public Date getAccesstime() {
		return accesstime;
	}
	public String getIp() {
		return ip;
	}
	public String getRequrl() {
		return requrl;
	}
	public String getDetail() {
		return detail;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAccesstime(Date accesstime) {
		this.accesstime = accesstime;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public void setRequrl(String requrl) {
		this.requrl = requrl;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	

}
