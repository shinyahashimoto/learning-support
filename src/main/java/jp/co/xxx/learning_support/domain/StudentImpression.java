package jp.co.xxx.learning_support.domain;

public class StudentImpression {

	private Integer id;
	private Integer weeklyReportId;
	private String studentName;
	private String content;
	@Override
	public String toString() {
		return "StudentImpression [id=" + id + ", weeklyReportId=" + weeklyReportId + ", studentName=" + studentName
				+ ", content=" + content + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getWeeklyReportId() {
		return weeklyReportId;
	}
	public void setWeeklyReportId(Integer weeklyReportId) {
		this.weeklyReportId = weeklyReportId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
