package com.lawencon.elearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="attendance")
public class Attendance extends BaseModel{
	@Column(name = "approval")
	private Boolean approval;
	@ManyToOne
	@JoinColumn(name = "class_dtl_id", nullable=false)
	private ClassDtl classDtl;
	@ManyToOne
	@JoinColumn(name = "learning_schedule_id")
	private LearningSchedule learningSchedule;
	@ManyToOne
	@JoinColumn(name = "quiz_schedule_id")
	private QuizSchedule quizSchedule;
	@ManyToOne
	@JoinColumn(name = "exam_schedule_id")
	private ExamSchedule examSchedule;
	public Boolean getApproval() {
		return approval;
	}
	public void setApproval(Boolean approval) {
		this.approval = approval;
	}
	public ClassDtl getClassDtl() {
		return classDtl;
	}
	public void setClassDtl(ClassDtl classDtl) {
		this.classDtl = classDtl;
	}
	public LearningSchedule getLearningSchedule() {
		return learningSchedule;
	}
	public void setLearningSchedule(LearningSchedule learningSchedule) {
		this.learningSchedule = learningSchedule;
	}
	public QuizSchedule getQuizSchedule() {
		return quizSchedule;
	}
	public void setQuizSchedule(QuizSchedule quizSchedule) {
		this.quizSchedule = quizSchedule;
	}
	public ExamSchedule getExamSchedule() {
		return examSchedule;
	}
	public void setExamSchedule(ExamSchedule examSchedule) {
		this.examSchedule = examSchedule;
	}
}
