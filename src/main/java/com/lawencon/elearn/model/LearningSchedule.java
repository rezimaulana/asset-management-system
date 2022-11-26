package com.lawencon.elearn.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="learning_schedule")
public class LearningSchedule extends BaseModel {
	@Column(name = "start_time", nullable=false)
	private LocalDateTime startTime;
	@Column(name = "end_time", nullable=false)
	private LocalDateTime endTime;
	@ManyToOne
	@JoinColumn(name = "learning_id", nullable=false)
	private LearningMaterial learningMaterial;
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public LearningMaterial getLearningMaterial() {
		return learningMaterial;
	}
	public void setLearningMaterial(LearningMaterial learningMaterial) {
		this.learningMaterial = learningMaterial;
	}
}
