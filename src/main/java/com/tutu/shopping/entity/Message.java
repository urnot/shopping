package com.tutu.shopping.entity;

import java.util.Date;

public class Message {
	private String content;
	private String name;
	private Date publishTime;
	private String remoteUrl;
	private int attent;
	private String country;
	private String city;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public String getRemoteUrl() {
		return remoteUrl;
	}

	public int getAttent() {
		return attent;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public void setRemoteUrl(String remoteUrl) {
		this.remoteUrl = remoteUrl;
	}

	public void setAttent(int attent) {
		this.attent = attent;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
