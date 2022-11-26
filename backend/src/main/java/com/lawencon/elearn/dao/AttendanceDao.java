package com.lawencon.elearn.dao;

import java.util.List;

import com.lawencon.elearn.model.Attendance;

public interface AttendanceDao extends BaseDao<Attendance>{
	List<Attendance> getAttendLearn(Long scheduleId);
	List<Attendance> getAttendQuiz(Long scheduleId);
	List<Attendance> getAttendExam(Long scheduleId);
}
