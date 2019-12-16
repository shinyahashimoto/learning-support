package jp.co.xxx.learning_support.form;

/**
 * 日報情報を受け取るフォームクラス.
 * 
 * @author hiraokayuri
 *
 */
public class DailyReportForm {
	/** 研修ID */
	private String trainingId;
	/** 受講生ID */
	private String studentId;
	/** 内容 */
	private String content;
	/** 理解度 */
	private String intelligibility;
	/** 理解度詳細 */
	private String detailIntelligibillity;
	/** 講師 */
	private String aboutInstructor;
	/** 質問 */
	private String question;

	public Integer getIntTrainingId() {
		return Integer.parseInt(trainingId);
	}

	public Integer getIntAboutInstructo() {
		return Integer.parseInt(aboutInstructor);
	}

	public String getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(String trainingId) {
		this.trainingId = trainingId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIntelligibility() {
		return intelligibility;
	}

	public void setIntelligibility(String intelligibility) {
		this.intelligibility = intelligibility;
	}

	public String getDetailIntelligibillity() {
		return detailIntelligibillity;
	}

	public void setDetailIntelligibillity(String detailIntelligibillity) {
		this.detailIntelligibillity = detailIntelligibillity;
	}

	public String getAboutInstructor() {
		return aboutInstructor;
	}

	public void setAboutInstructor(String aboutInstructor) {
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
		return "DailyReportForm [trainingId=" + trainingId + ", studentId=" + studentId + ", content=" + content
				+ ", intelligibility=" + intelligibility + ", detailIntelligibillity=" + detailIntelligibillity
				+ ", aboutInstructor=" + aboutInstructor + ", question=" + question + "]";
	}
}
