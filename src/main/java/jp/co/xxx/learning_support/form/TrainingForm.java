package jp.co.xxx.learning_support.form;

import java.time.LocalDate;
import java.util.List;

public class TrainingForm {

	private String startDate;
	private String endDate;
	private String name;
	private Integer instructorId;
	private Integer subInstructorId1;
	private Integer subInstructorId2;
	private List<Integer> studentIdList;
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(Integer instructorId) {
		this.instructorId = instructorId;
	}
	public Integer getSubInstructorId1() {
		return subInstructorId1;
	}
	public void setSubInstructorId1(Integer subInstructorId1) {
		this.subInstructorId1 = subInstructorId1;
	}
	public Integer getSubInstructorId2() {
		return subInstructorId2;
	}
	public void setSubInstructorId2(Integer subInstructorId2) {
		this.subInstructorId2 = subInstructorId2;
	}
	public List<Integer> getStudentIdList() {
		return studentIdList;
	}
	public void setStudentIdList(List<Integer> studentIdList) {
		this.studentIdList = studentIdList;
	}
	@Override
	public String toString() {
		return "TrainingForm [startDate=" + startDate + ", endDate=" + endDate + ", name=" + name + ", instructorId="
				+ instructorId + ", subInstructorId1=" + subInstructorId1 + ", subInstructorId2=" + subInstructorId2
				+ ", studentIdList=" + studentIdList + "]";
	}
	
	
}
