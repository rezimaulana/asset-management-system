package com.lawencon.elearn.service;

import com.lawencon.elearn.dto.attendance.AttendanceInsertReqDto;
import com.lawencon.elearn.dto.attendance.AttendanceInsertResDto;
import com.lawencon.elearn.dto.attendance.AttendanceListResDto;
import com.lawencon.elearn.dto.attendance.AttendanceResDto;
import com.lawencon.elearn.dto.attendance.AttendanceUpdateReqDto;
import com.lawencon.elearn.dto.attendance.AttendanceUpdateResDto;

public interface AttendanceService {
	AttendanceListResDto getAll();
	AttendanceResDto getById(Long id);
	AttendanceInsertResDto insert(AttendanceInsertReqDto data);
	AttendanceUpdateResDto update(AttendanceUpdateReqDto data);
	AttendanceListResDto getAttendLearn(Long scheduleId);
	AttendanceListResDto getAttendQuiz(Long scheduleId);
	AttendanceListResDto getAttendExam(Long scheduleId);
//	AttendanceUpdateResDto approvLearn(AttendanceUpdateResDto data);
//	AttendanceInsertResDto attend(AttendanceInsertResDto data);
}
