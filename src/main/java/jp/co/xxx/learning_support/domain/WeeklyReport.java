package jp.co.xxx.learning_support.domain;

import java.util.Date;

public class WeeklyReport {

	private Integer id;
	private Date startDate;
	private String instructorName;
	private String content;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getInstructorName() {
		return instructorName;
	}
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "WeeklyReport [id=" + id + ", startDate=" + startDate + ", instructorName=" + instructorName
				+ ", content=" + content + "]";
	}
	
}
