package com.admin.bean;

import java.util.Date;


public class CmsContent extends BaseEntity<CmsContent> {
	private static final long serialVersionUID = 1L;

	private Long contentId;

	private Long categoryId;

	private String contentTitle;

	private String contentSubTitle;

	private String contentDescription;

	private String contentImage;

	private String contentType;
	
	private String contentSource;

	private String contentPath;

	private String contentContent;

	private String contentStatus;

	private Long contentPriority;

	private String contentExtend;

	private Date createTime;

	private Long createUser;

	private Date modifyTime;

	private Long modifyUser;

	public Long getContentId() {
		return contentId;
	}

	public void setContentId(Long contentId) {
		this.contentId = contentId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	public String getContentSubTitle() {
		return contentSubTitle;
	}

	public void setContentSubTitle(String contentSubTitle) {
		this.contentSubTitle = contentSubTitle;
	}

	public String getContentDescription() {
		return contentDescription;
	}

	public void setContentDescription(String contentDescription) {
		this.contentDescription = contentDescription;
	}

	public String getContentImage() {
		return contentImage;
	}

	public void setContentImage(String contentImage) {
		this.contentImage = contentImage;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentPath() {
		return contentPath;
	}

	public void setContentPath(String contentPath) {
		this.contentPath = contentPath;
	}

	public String getContentContent() {
		return contentContent;
	}

	public void setContentContent(String contentContent) {
		this.contentContent = contentContent;
	}

	public String getContentStatus() {
		return contentStatus;
	}

	public void setContentStatus(String contentStatus) {
		this.contentStatus = contentStatus;
	}

	public Long getContentPriority() {
		return contentPriority;
	}

	public void setContentPriority(Long contentPriority) {
		this.contentPriority = contentPriority;
	}

	public String getContentExtend() {
		return contentExtend;
	}

	public void setContentExtend(String contentExtend) {
		this.contentExtend = contentExtend;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Long getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(Long modifyUser) {
		this.modifyUser = modifyUser;
	}

	public String getContentSource() {
		return contentSource;
	}

	public void setContentSource(String contentSource) {
		this.contentSource = contentSource;
	}

	
}