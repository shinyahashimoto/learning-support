package jp.co.xxx.learning_support.domain;

import java.time.LocalDate;
import java.util.List;

public class WeeklyReport {

	/** 週報ID */
	private Integer id;
	/** 週の初めの日 */
	private LocalDate startDate;
	/** 講師名 */
	private String instructorName;
	/** 内容 */
	private String content;
	/** 受講生所感リスト */
	private List<StudentImpression> studentImpressionList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
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

	public List<StudentImpression> getStudentImpressionList() {
		return studentImpressionList;
	}

	public void setStudentImpressionList(List<StudentImpression> studentImpressionList) {
		this.studentImpressionList = studentImpressionList;
	}

	@Override
	public String toString() {
		return "WeeklyReport [id=" + id + ", startDate=" + startDate + ", instructorName=" + instructorName
				+ ", content=" + content + ", studentImpressionList=" + studentImpressionList + "]";
	}

}