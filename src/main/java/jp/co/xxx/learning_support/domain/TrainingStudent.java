package jp.co.xxx.learning_support.domain;

public class TrainingStudent {

	/** 研修ID */
	private Integer trainingId;
	/** 受講生ID */
	private Integer studentId;

	@Override
	public String toString() {
		return "TrainingStudent [trainingId=" + trainingId + ", studentId=" + studentId + "]";
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

}
