package com.lawencon.elearn.dto.attendance;

public class AttendanceInsertReqDto {
	private Long classDtlId;
	private Long learningScheduleId;
	private Long quizScheduleId;
	private Long examScheduleId;
	public Long getClassDtlId() {
		return classDtlId;
	}
	public void setClassDtlId(Long classDtlId) {
		this.classDtlId = classDtlId;
	}
	public Long getLearningScheduleId() {
		return learningScheduleId;
	}
	public void setLearningScheduleId(Long learningScheduleId) {
		this.learningScheduleId = learningScheduleId;
	}
	public Long getQuizScheduleId() {
		return quizScheduleId;
	}
	public void setQuizScheduleId(Long quizScheduleId) {
		this.quizScheduleId = quizScheduleId;
	}
	public Long getExamScheduleId() {
		return examScheduleId;
	}
	public void setExamScheduleId(Long examScheduleId) {
		this.examScheduleId = examScheduleId;
	}
}
