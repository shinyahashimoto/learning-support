package jp.co.xxx.learning_support.domain;

import java.util.Date;

public class Training {

	/** 研修ID */
	private Integer id;
	/** 開始日 */
	private Date startDate;
	/** 終了日 */
	private Date endDate;
	/** 研修名 */
	private String name;
	/** 講師ID */
	private Integer instructorId;
	/** サブ講師ID1 */
	private Integer subInstructorId1;
	/** サブ講師ID2 */
	private Integer subInstructorId2;
	/** サブ講師ID3 */
	private Integer subInstructorId3;

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

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
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

	public Integer getSubInstructorId3() {
		return subInstructorId3;
	}

	public void setSubInstructorId3(Integer subInstructorId3) {
		this.subInstructorId3 = subInstructorId3;
	}

	@Override
	public String toString() {
		return "Training [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", name=" + name
				+ ", instructorId=" + instructorId + ", subInstructorId1=" + subInstructorId1 + ", subInstructorId2="
				+ subInstructorId2 + ", subInstructorId3=" + subInstructorId3 + "]";
	}

}