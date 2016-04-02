package com.kli.tag;


import java.util.Date;

import javax.servlet.jsp.tagext.TagSupport;

import com.kli.tools.DateTimeUtil;

public class DateTag extends TagSupport {  

    private static final long serialVersionUID = -5743295339374288539L;  
  
    private Date date;// 时间戳(输入)  
  
    private String parseDate;// 日期时间(输出)  
    
    private String pattern;
  
  
    /** 
     * 时间戳转换成日期时间 
     *  
     * @return 
     */  
    public int doStartTag() {  
        try {  
        	parseDate = DateTimeUtil.formatDate(date, pattern);
            pageContext.getOut().println(parseDate);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return EVAL_PAGE;  
    }
    
  //标签结束时调用的处理方法  
    public int doEndTag() {  
        //继续执行后续的JSP页面内容  
        return EVAL_PAGE;  
    }  


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getParseDate() {
		return parseDate;
	}


	public void setParseDate(String parseDate) {
		this.parseDate = parseDate;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	 
}
