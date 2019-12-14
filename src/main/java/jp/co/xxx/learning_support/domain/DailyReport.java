package jp.co.xxx.learning_support.domain;

import java.time.LocalDate;

public class DailyReport {

	/** 日報ID */
	private Integer id;
	/** 日付 */
	private LocalDate date;
	/** 研修ID */
	private Integer trainingId;
	/** 受講生ID */
	private Integer studentId;
	/** 内容 */
	private String content;
	/** 理解度 */
	private Integer intelligibility;
	/** 理解度詳細 */
	private String detailIntelligibility;
	/** 講師 */
	private Integer aboutInstructor;
	/** 質問 */
	private String question;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
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