package com.kli.bean;/** *  * <br> * <b>功能：</b>ExamQuestionEntity<br> */public class ExamQuestion extends BaseEntity<ExamQuestion> {			private java.lang.Long id;//   ID	private java.lang.Long examPaperId;//   试卷ID	private java.lang.String questionInfo;//   问题信息	private java.lang.String questionDesc;//   问题描述	private java.lang.String stdAnswer;//   标准答案	private java.lang.Integer enable;//   是否启用	private java.lang.Integer type;//   类型	private java.lang.Integer priority;//   优先级	private java.util.Date createTime;//   创建时间	private java.util.Date updateTime;//   修改时间	public java.lang.Long getId() {	    return this.id;	}	public void setId(java.lang.Long id) {	    this.id=id;	}	public java.lang.Long getExamPaperId() {	    return this.examPaperId;	}	public void setExamPaperId(java.lang.Long examPaperId) {	    this.examPaperId=examPaperId;	}	public java.lang.String getQuestionInfo() {	    return this.questionInfo;	}	public void setQuestionInfo(java.lang.String questionInfo) {	    this.questionInfo=questionInfo;	}	public java.lang.String getQuestionDesc() {	    return this.questionDesc;	}	public void setQuestionDesc(java.lang.String questionDesc) {	    this.questionDesc=questionDesc;	}	public java.lang.String getStdAnswer() {	    return this.stdAnswer;	}	public void setStdAnswer(java.lang.String stdAnswer) {	    this.stdAnswer=stdAnswer;	}	public java.lang.Integer getEnable() {	    return this.enable;	}	public void setEnable(java.lang.Integer enable) {	    this.enable=enable;	}	public java.lang.Integer getType() {	    return this.type;	}	public void setType(java.lang.Integer type) {	    this.type=type;	}	public java.lang.Integer getPriority() {	    return this.priority;	}	public void setPriority(java.lang.Integer priority) {	    this.priority=priority;	}	public java.util.Date getCreateTime() {	    return this.createTime;	}	public void setCreateTime(java.util.Date createTime) {	    this.createTime=createTime;	}	public java.util.Date getUpdateTime() {	    return this.updateTime;	}	public void setUpdateTime(java.util.Date updateTime) {	    this.updateTime=updateTime;	}}