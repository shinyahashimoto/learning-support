package jp.co.xxx.learning_support.domain;

import java.util.Date;

public class DailyReport {

	private Integer id;
	private Date date;
	private Integer trainingId;
	private Integer studentId;
	private String content;
	private Integer intelligibility;
	private String detailIntelligibility;
	private Integer aboutInstructor;
	private String question;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(Integer trainingId) {
		this.trainingId = trainingId;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getIntelligibility() {
		return intelligibility;
	}
	public void setIntelligibility(Integer intelligibility) {
		this.intelligibility = intelligibility;
	}
	public String getDetailIntelligibility() {
		return detailIntelligibility;
	}
	public void setDetailIntelligibility(String detailIntelligibility) {
		this.detailIntelligibility = detailIntelligibility;
	}
	public Integer getAboutInstructor() {
		return aboutInstructor;
	}
	public void setAboutInstructor(Integer aboutInstructor) {
		this.aboutInstructor = aboutInstructor;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "DailyReport [id=" + id + ", date=" + date + ", trainingId=" + trainingId + ", studentId=" + studentId
				+ ", content=" + content + ", intelligibility=" + intelligibility + ", detailIntelligibility="
				+ detailIntelligibility + ", aboutInstructor=" + aboutInstructor + ", question=" + question + "]";
	}
	
	
}
