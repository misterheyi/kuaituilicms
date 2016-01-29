package com.yzq.katl.model;

import java.util.Date;

public class Famous {

	private Integer id;
	
	private String title;
	
	private String logoUrl;
	
	private String description;
	
	private Integer seoId;
	
	private Integer briefId;
	
	private Integer basicId;
	
	private Integer clickTimes;
	
	private Integer status;
	
	private Integer sort;
	
	private Integer isDeleted;
	
	private Date createTime;
	
	private Date updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSeoId() {
		return seoId;
	}

	public void setSeoId(Integer seoId) {
		this.seoId = seoId;
	}

	public Integer getBriefId() {
		return briefId;
	}

	public void setBriefId(Integer briefId) {
		this.briefId = briefId;
	}

	public Integer getBasicId() {
		return basicId;
	}

	public void setBasicId(Integer basicId) {
		this.basicId = basicId;
	}

	public Integer getClickTimes() {
		return clickTimes;
	}

	public void setClickTimes(Integer clickTimes) {
		this.clickTimes = clickTimes;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
