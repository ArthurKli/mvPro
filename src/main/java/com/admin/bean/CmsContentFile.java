package com.admin.bean;

import java.util.Date;

public class CmsContentFile extends BaseEntity<CmsContentFile> {


	/**
	 * 
	 */
	private static final long serialVersionUID = -769974849519356499L;

	private Long fileId;
	
	private String businessType;

	private Long businessId;

	private String fileType;

	private String fileName;

	private String fileDescription;

	private String filePath;

	private int filePriority;

	private String fileStatus;

	private String fileEnable;

	private String fileDelete;

	private Date createTime;

	private Long createUser;

	private Date modifyTime;

	private Long modifyUser;

	private String fileExtend;

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDescription() {
		return fileDescription;
	}

	public void setFileDescription(String fileDescription) {
		this.fileDescription = fileDescription;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}



	public String getFileStatus() {
		return fileStatus;
	}

	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}

	public String getFileEnable() {
		return fileEnable;
	}

	public void setFileEnable(String fileEnable) {
		this.fileEnable = fileEnable;
	}

	public String getFileDelete() {
		return fileDelete;
	}

	public void setFileDelete(String fileDelete) {
		this.fileDelete = fileDelete;
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

	public String getFileExtend() {
		return fileExtend;
	}

	public void setFileExtend(String fileExtend) {
		this.fileExtend = fileExtend;
	}

	public int getFilePriority() {
		return filePriority;
	}

	public void setFilePriority(int filePriority) {
		this.filePriority = filePriority;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	
	
}

