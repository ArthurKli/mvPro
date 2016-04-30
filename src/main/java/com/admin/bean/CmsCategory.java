package com.admin.bean;


import java.util.Date;

public class CmsCategory extends BaseEntity<CmsCategory> {
	private static final long serialVersionUID = 1L;


	private Long categoryId;

	private String categoryName;

	private String categoryDescription;

	private String categoryLevelcode;
	
	private String CategoryHref;

	private String categoryImage;

	private String categoryStatus;

	private String categoryDelete;

	private String categoryEnable;

	private Date createTime;
	
	private Long createUser;

	private Date modifyTime;

	private Long modifyUser;

	private Long categoryPriority;

	private String categoryExtend;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public String getCategoryLevelcode() {
		return categoryLevelcode;
	}

	public void setCategoryLevelcode(String categoryLevelcode) {
		this.categoryLevelcode = categoryLevelcode;
	}

	public String getCategoryHref() {
		return CategoryHref;
	}

	public void setCategoryHref(String categoryHref) {
		CategoryHref = categoryHref;
	}

	public String getCategoryImage() {
		return categoryImage;
	}

	public void setCategoryImage(String categoryImage) {
		this.categoryImage = categoryImage;
	}

	public String getCategoryStatus() {
		return categoryStatus;
	}

	public void setCategoryStatus(String categoryStatus) {
		this.categoryStatus = categoryStatus;
	}

	public String getCategoryDelete() {
		return categoryDelete;
	}

	public void setCategoryDelete(String categoryDelete) {
		this.categoryDelete = categoryDelete;
	}

	public String getCategoryEnable() {
		return categoryEnable;
	}

	public void setCategoryEnable(String categoryEnable) {
		this.categoryEnable = categoryEnable;
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

	public Long getCategoryPriority() {
		return categoryPriority;
	}

	public void setCategoryPriority(Long categoryPriority) {
		this.categoryPriority = categoryPriority;
	}

	public String getCategoryExtend() {
		return categoryExtend;
	}

	public void setCategoryExtend(String categoryExtend) {
		this.categoryExtend = categoryExtend;
	}

	
}

