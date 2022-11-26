package com.lawencon.elearn.dto.attendance;

import java.time.LocalDateTime;

public class AttendanceDataDto {
	private Long id;
	private Boolean approval;
	private Long classDtlId;
	private Long studentId;
	private String studentEmail;
	private String studentFullname;
	private Long classHdrId;
	private String classHdrCode;
	private String classHdrSubject;
	private String classHdrDescription;
	private Long instructorId;
	private String instructorEmail;
	private String instructorFullname;
	private Long learningScheduleId;
	private LocalDateTime learningStartTime;
	private LocalDateTime learningEndTime;
	private Long learningMaterialId;
	private String learningCode;
	private String learningSubject;
	private String learningDescription;
	private Long quizScheduleId;
	private LocalDateTime quizStartTime;
	private LocalDateTime quizEndTime;
	private Long quizMaterialId;
	private String quizCode;
	private String quizSubject;
	private String quizDescription;
	private Long examScheduleId;
	private LocalDateTime examStartTime;
	private LocalDateTime examEndTime;
	private Long examMaterialId;
	private String examCode;
	private String examSubject;
	private String examDescription;
	private Integer ver;
	private Boolean isActive;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getApproval() {
		return approval;
	}
	public void setApproval(Boolean approval) {
		this.approval = approval;
	}
	public Long getClassDtlId() {
		return classDtlId;
	}
	public void setClassDtlId(Long classDtlId) {
		this.classDtlId = classDtlId;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getStudentFullname() {
		return studentFullname;
	}
	public void setStudentFullname(String studentFullname) {
		this.studentFullname = studentFullname;
	}
	public Long getClassHdrId() {
		return classHdrId;
	}
	public void setClassHdrId(Long classHdrId) {
		this.classHdrId = classHdrId;
	}
	public String getClassHdrCode() {
		return classHdrCode;
	}
	public void setClassHdrCode(String classHdrCode) {
		this.classHdrCode = classHdrCode;
	}
	public String getClassHdrSubject() {
		return classHdrSubject;
	}
	public void setClassHdrSubject(String classHdrSubject) {
		this.classHdrSubject = classHdrSubject;
	}
	public String getClassHdrDescription() {
		return classHdrDescription;
	}
	public void setClassHdrDescription(String classHdrDescription) {
		this.classHdrDescription = classHdrDescription;
	}
	public Long getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(Long instructorId) {
		this.instructorId = instructorId;
	}
	public String getInstructorEmail() {
		return instructorEmail;
	}
	public void setInstructorEmail(String instructorEmail) {
		this.instructorEmail = instructorEmail;
	}
	public String getInstructorFullname() {
		return instructorFullname;
	}
	public void setInstructorFullname(String instructorFullname) {
		this.instructorFullname = instructorFullname;
	}
	public Long getLearningScheduleId() {
		return learningScheduleId;
	}
	public void setLearningScheduleId(Long learningScheduleId) {
		this.learningScheduleId = learningScheduleId;
	}
	public LocalDateTime getLearningStartTime() {
		return learningStartTime;
	}
	public void setLearningStartTime(LocalDateTime learningStartTime) {
		this.learningStartTime = learningStartTime;
	}
	public LocalDateTime getLearningEndTime() {
		return learningEndTime;
	}
	public void setLearningEndTime(LocalDateTime learningEndTime) {
		this.learningEndTime = learningEndTime;
	}
	public Long getLearningMaterialId() {
		return learningMaterialId;
	}
	public void setLearningMaterialId(Long learningMaterialId) {
		this.learningMaterialId = learningMaterialId;
	}
	public String getLearningCode() {
		return learningCode;
	}
	public void setLearningCode(String learningCode) {
		this.learningCode = learningCode;
	}
	public String getLearningSubject() {
		return learningSubject;
	}
	public void setLearningSubject(String learningSubject) {
		this.learningSubject = learningSubject;
	}
	public String getLearningDescription() {
		return learningDescription;
	}
	public void setLearningDescription(String learningDescription) {
		this.learningDescription = learningDescription;
	}
	public Long getQuizScheduleId() {
		return quizScheduleId;
	}
	public void setQuizScheduleId(Long quizScheduleId) {
		this.quizScheduleId = quizScheduleId;
	}
	public LocalDateTime getQuizStartTime() {
		return quizStartTime;
	}
	public void setQuizStartTime(LocalDateTime quizStartTime) {
		this.quizStartTime = quizStartTime;
	}
	public LocalDateTime getQuizEndTime() {
		return quizEndTime;
	}
	public void setQuizEndTime(LocalDateTime quizEndTime) {
		this.quizEndTime = quizEndTime;
	}
	public Long getQuizMaterialId() {
		return quizMaterialId;
	}
	public void setQuizMaterialId(Long quizMaterialId) {
		this.quizMaterialId = quizMaterialId;
	}
	public String getQuizCode() {
		return quizCode;
	}
	public void setQuizCode(String quizCode) {
		this.quizCode = quizCode;
	}
	public String getQuizSubject() {
		return quizSubject;
	}
	public void setQuizSubject(String quizSubject) {
		this.quizSubject = quizSubject;
	}
	public String getQuizDescription() {
		return quizDescription;
	}
	public void setQuizDescription(String quizDescription) {
		this.quizDescription = quizDescription;
	}
	public Long getExamScheduleId() {
		return examScheduleId;
	}
	public void setExamScheduleId(Long examScheduleId) {
		this.examScheduleId = examScheduleId;
	}
	public LocalDateTime getExamStartTime() {
		return examStartTime;
	}
	public void setExamStartTime(LocalDateTime examStartTime) {
		this.examStartTime = examStartTime;
	}
	public LocalDateTime getExamEndTime() {
		return examEndTime;
	}
	public void setExamEndTime(LocalDateTime examEndTime) {
		this.examEndTime = examEndTime;
	}
	public Long getExamMaterialId() {
		return examMaterialId;
	}
	public void setExamMaterialId(Long examMaterialId) {
		this.examMaterialId = examMaterialId;
	}
	public String getExamCode() {
		return examCode;
	}
	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}
	public String getExamSubject() {
		return examSubject;
	}
	public void setExamSubject(String examSubject) {
		this.examSubject = examSubject;
	}
	public String getExamDescription() {
		return examDescription;
	}
	public void setExamDescription(String examDescription) {
		this.examDescription = examDescription;
	}
	public Integer getVer() {
		return ver;
	}
	public void setVer(Integer ver) {
		this.ver = ver;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
