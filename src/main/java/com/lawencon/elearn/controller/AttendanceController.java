package com.lawencon.elearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.elearn.dto.attendance.AttendanceInsertReqDto;
import com.lawencon.elearn.dto.attendance.AttendanceInsertResDto;
import com.lawencon.elearn.dto.attendance.AttendanceListResDto;
import com.lawencon.elearn.dto.attendance.AttendanceResDto;
import com.lawencon.elearn.dto.attendance.AttendanceUpdateReqDto;
import com.lawencon.elearn.dto.attendance.AttendanceUpdateResDto;
import com.lawencon.elearn.service.AttendanceService;

@RestController
@RequestMapping("attendance")
public class AttendanceController {
	@Autowired
	private AttendanceService attendanceService;
	
	@GetMapping
	public ResponseEntity<AttendanceListResDto> getAll() {
		final AttendanceListResDto result = attendanceService.getAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<AttendanceResDto> getById(@PathVariable("id") Long id){
		final AttendanceResDto result = attendanceService.getById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<AttendanceInsertResDto> insert(@RequestBody AttendanceInsertReqDto data){
		final AttendanceInsertResDto result = attendanceService.insert(data);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<AttendanceUpdateResDto> update(@RequestBody AttendanceUpdateReqDto data){
		final AttendanceUpdateResDto result = attendanceService.update(data);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("exam_schedule/{scheduleId}")
	public ResponseEntity<AttendanceListResDto> getAttendExam(@PathVariable("scheduleId") Long scheduleId) {
		final AttendanceListResDto result = attendanceService.getAttendExam(scheduleId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("quiz_schedule/{scheduleId}")
	public ResponseEntity<AttendanceListResDto> getAttendQuiz(@PathVariable("scheduleId") Long scheduleId) {
		final AttendanceListResDto result = attendanceService.getAttendQuiz(scheduleId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("learning_schedule/{scheduleId}")
	public ResponseEntity<AttendanceListResDto> getAttendLearning(@PathVariable("scheduleId") Long scheduleId) {
		final AttendanceListResDto result = attendanceService.getAttendLearn(scheduleId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
