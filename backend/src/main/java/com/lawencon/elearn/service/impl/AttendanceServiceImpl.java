package com.lawencon.elearn.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearn.constant.ResponseConst;
import com.lawencon.elearn.dao.AttendanceDao;
import com.lawencon.elearn.dao.ClassDtlDao;
import com.lawencon.elearn.dao.ExamScheduleDao;
import com.lawencon.elearn.dao.LearningScheduleDao;
import com.lawencon.elearn.dao.QuizScheduleDao;
import com.lawencon.elearn.dto.attendance.AttendanceDataDto;
import com.lawencon.elearn.dto.attendance.AttendanceInsertDataResDto;
import com.lawencon.elearn.dto.attendance.AttendanceInsertReqDto;
import com.lawencon.elearn.dto.attendance.AttendanceInsertResDto;
import com.lawencon.elearn.dto.attendance.AttendanceListResDto;
import com.lawencon.elearn.dto.attendance.AttendanceResDto;
import com.lawencon.elearn.dto.attendance.AttendanceUpdateDataResDto;
import com.lawencon.elearn.dto.attendance.AttendanceUpdateReqDto;
import com.lawencon.elearn.dto.attendance.AttendanceUpdateResDto;
import com.lawencon.elearn.model.Attendance;
import com.lawencon.elearn.model.ClassDtl;
import com.lawencon.elearn.model.ExamSchedule;
import com.lawencon.elearn.model.LearningSchedule;
import com.lawencon.elearn.model.QuizSchedule;
import com.lawencon.elearn.service.AttendanceService;
import com.lawencon.elearn.service.PrincipalService;

@Service
public class AttendanceServiceImpl implements AttendanceService{
	@Autowired
	private PrincipalService principalService;
	@Autowired
	private AttendanceDao attendanceDao;
	@Autowired
	private ClassDtlDao classDtlDao;
	@Autowired
	private LearningScheduleDao learningScheduleDao;
	@Autowired
	private QuizScheduleDao quizScheduleDao;
	@Autowired
	private ExamScheduleDao examScheduleDao;
	
	@Override
	public AttendanceListResDto getAll() {
		final List<Attendance> query = attendanceDao.getAll();
		final List<AttendanceDataDto> rows = new ArrayList<>();
		for (int i = 0; i<query.size(); i++) {
			final Attendance result = query.get(i);
			final AttendanceDataDto row = new AttendanceDataDto();
			row.setId(result.getId());
			row.setApproval(result.getApproval());
			row.setClassDtlId(result.getClassDtl().getId());
			row.setStudentId(result.getClassDtl().getStudent().getId());
			row.setStudentEmail(result.getClassDtl().getStudent().getEmail());
			row.setStudentFullname(result.getClassDtl().getStudent().getFullname());
			row.setClassHdrId(result.getClassDtl().getClassHdr().getId());
			row.setClassHdrCode(result.getClassDtl().getClassHdr().getCode());
			row.setClassHdrSubject(result.getClassDtl().getClassHdr().getSubject());
			row.setClassHdrDescription(result.getClassDtl().getClassHdr().getDescription());
			row.setInstructorId(result.getClassDtl().getClassHdr().getInstructor().getId());
			row.setInstructorEmail(result.getClassDtl().getClassHdr().getInstructor().getEmail());
			row.setInstructorFullname(result.getClassDtl().getClassHdr().getInstructor().getFullname());
			if(result.getLearningSchedule()!=null) {
				row.setLearningScheduleId(result.getLearningSchedule().getId());
				row.setLearningStartTime(result.getLearningSchedule().getStartTime());
				row.setLearningEndTime(result.getLearningSchedule().getEndTime());
				row.setLearningMaterialId(result.getLearningSchedule().getLearningMaterial().getId());
				row.setLearningCode(result.getLearningSchedule().getLearningMaterial().getCode());
				row.setLearningSubject(result.getLearningSchedule().getLearningMaterial().getSubject());
				row.setLearningDescription(result.getLearningSchedule().getLearningMaterial().getDescription());
			}
			if(result.getQuizSchedule()!=null) {
				row.setQuizScheduleId(result.getQuizSchedule().getId());
				row.setQuizStartTime(result.getQuizSchedule().getStartTime());
				row.setQuizEndTime(result.getQuizSchedule().getEndTime());
				row.setQuizMaterialId(result.getQuizSchedule().getQuizMaterial().getId());
				row.setQuizCode(result.getQuizSchedule().getQuizMaterial().getCode());
				row.setQuizSubject(result.getQuizSchedule().getQuizMaterial().getSubject());
				row.setQuizDescription(result.getQuizSchedule().getQuizMaterial().getDescription());
			}
			if(result.getExamSchedule()!=null) {
				row.setExamScheduleId(result.getExamSchedule().getId());
				row.setExamStartTime(result.getExamSchedule().getStartTime());
				row.setExamEndTime(result.getExamSchedule().getEndTime());
				row.setExamMaterialId(result.getExamSchedule().getExamMaterial().getId());
				row.setExamCode(result.getExamSchedule().getExamMaterial().getCode());
				row.setExamSubject(result.getExamSchedule().getExamMaterial().getSubject());
				row.setExamDescription(result.getExamSchedule().getExamMaterial().getDescription());
			}
			row.setVer(result.getVer());
			row.setIsActive(result.getIsActive());
			rows.add(row);
		}
		final AttendanceListResDto data = new AttendanceListResDto();
		data.setData(rows);
		return data;
	}
	
	@Override
	public AttendanceResDto getById(final Long id) {
		final Optional<Attendance> query = attendanceDao.getById(id);
		final AttendanceDataDto row = new AttendanceDataDto();
		final AttendanceResDto data = new AttendanceResDto();
		if (query.isPresent()) {
			final Attendance result = query.get();
//			final AttendanceDataDto row = new AttendanceDataDto();
			row.setId(result.getId());
			row.setApproval(result.getApproval());
			row.setClassDtlId(result.getClassDtl().getId());
			row.setStudentId(result.getClassDtl().getStudent().getId());
			row.setStudentEmail(result.getClassDtl().getStudent().getEmail());
			row.setStudentFullname(result.getClassDtl().getStudent().getFullname());
			row.setClassHdrId(result.getClassDtl().getClassHdr().getId());
			row.setClassHdrCode(result.getClassDtl().getClassHdr().getCode());
			row.setClassHdrSubject(result.getClassDtl().getClassHdr().getSubject());
			row.setClassHdrDescription(result.getClassDtl().getClassHdr().getDescription());
			row.setInstructorId(result.getClassDtl().getClassHdr().getInstructor().getId());
			row.setInstructorEmail(result.getClassDtl().getClassHdr().getInstructor().getEmail());
			row.setInstructorFullname(result.getClassDtl().getClassHdr().getInstructor().getFullname());
			if(result.getLearningSchedule()!=null) {
				row.setLearningScheduleId(result.getLearningSchedule().getId());
				row.setLearningStartTime(result.getLearningSchedule().getStartTime());
				row.setLearningEndTime(result.getLearningSchedule().getEndTime());
				row.setLearningMaterialId(result.getLearningSchedule().getLearningMaterial().getId());
				row.setLearningCode(result.getLearningSchedule().getLearningMaterial().getCode());
				row.setLearningSubject(result.getLearningSchedule().getLearningMaterial().getSubject());
				row.setLearningDescription(result.getLearningSchedule().getLearningMaterial().getDescription());
			}
			if(result.getQuizSchedule()!=null) {
				row.setQuizScheduleId(result.getQuizSchedule().getId());
				row.setQuizStartTime(result.getQuizSchedule().getStartTime());
				row.setQuizEndTime(result.getQuizSchedule().getEndTime());
				row.setQuizMaterialId(result.getQuizSchedule().getQuizMaterial().getId());
				row.setQuizCode(result.getQuizSchedule().getQuizMaterial().getCode());
				row.setQuizSubject(result.getQuizSchedule().getQuizMaterial().getSubject());
				row.setQuizDescription(result.getQuizSchedule().getQuizMaterial().getDescription());
			}
			if(result.getExamSchedule()!=null) {
				row.setExamScheduleId(result.getExamSchedule().getId());
				row.setExamStartTime(result.getExamSchedule().getStartTime());
				row.setExamEndTime(result.getExamSchedule().getEndTime());
				row.setExamMaterialId(result.getExamSchedule().getExamMaterial().getId());
				row.setExamCode(result.getExamSchedule().getExamMaterial().getCode());
				row.setExamSubject(result.getExamSchedule().getExamMaterial().getSubject());
				row.setExamDescription(result.getExamSchedule().getExamMaterial().getDescription());
			}
			row.setVer(result.getVer());
			row.setIsActive(result.getIsActive());
		}
//		final AttendanceResDto data = new AttendanceResDto();
		data.setData(row);
		return data;
	}
	
	@Transactional(rollbackOn = Exception.class)
	@Override
	public AttendanceInsertResDto insert(final AttendanceInsertReqDto data) {
		final Attendance row = new Attendance();
		final Optional<ClassDtl> classDtl = classDtlDao.getById(data.getClassDtlId());
		row.setClassDtl(classDtl.get());
		Optional<LearningSchedule> learningSchedule = null;
		if (data.getLearningScheduleId()!=null) {
			learningSchedule = learningScheduleDao.getById(data.getLearningScheduleId());
			row.setLearningSchedule(learningSchedule.get());
		}
		Optional<QuizSchedule> quizSchedule = null;
		if (data.getQuizScheduleId()!=null) {
			quizSchedule = quizScheduleDao.getById(data.getQuizScheduleId());
			row.setQuizSchedule(quizSchedule.get());
		}
		Optional<ExamSchedule> examSchedule = null;
		if (data.getExamScheduleId()!=null) {
			examSchedule = examScheduleDao.getById(data.getExamScheduleId());
			row.setExamSchedule(examSchedule.get());
		}
		row.setCreatedBy(principalService.getPrincipal().getId());
		final Attendance result = attendanceDao.insert(row);
		final AttendanceInsertDataResDto dto = new AttendanceInsertDataResDto();
		dto.setId(result.getId());
		final AttendanceInsertResDto res = new AttendanceInsertResDto();
		res.setData(dto);
		res.setMessage(ResponseConst.CREATED.getResponse());
		return res;
	}
	
	@Transactional(rollbackOn = Exception.class)
	@Override
	public AttendanceUpdateResDto update(final AttendanceUpdateReqDto data) {
		final Optional<Attendance> optional = attendanceDao.getById(data.getId());
		Attendance row = null;
		final AttendanceUpdateResDto res = new AttendanceUpdateResDto();
		if(optional.isPresent()) {
			row = optional.get();
			row.setApproval(data.getApproval());
			row.setUpdatedBy(principalService.getPrincipal().getId());
			row.setVer(data.getVer());
			row = attendanceDao.update(row);
			final AttendanceUpdateDataResDto dto = new AttendanceUpdateDataResDto();
			dto.setVer(row.getVer());
			res.setData(dto);
			res.setMessage(ResponseConst.UPDATED.getResponse());
		}
		return res;
	}

	@Override
	public AttendanceListResDto getAttendLearn(final Long scheduleId) {
		final List<Attendance> query = attendanceDao.getAttendLearn(scheduleId);
		final List<AttendanceDataDto> rows = new ArrayList<>();
		for (int i = 0; i<query.size(); i++) {
			final Attendance result = query.get(i);
			final AttendanceDataDto row = new AttendanceDataDto();
			row.setId(result.getId());
			row.setApproval(result.getApproval());
			row.setClassDtlId(result.getClassDtl().getId());
			row.setStudentId(result.getClassDtl().getStudent().getId());
			row.setStudentEmail(result.getClassDtl().getStudent().getEmail());
			row.setStudentFullname(result.getClassDtl().getStudent().getFullname());
			row.setClassHdrId(result.getClassDtl().getClassHdr().getId());
			row.setClassHdrCode(result.getClassDtl().getClassHdr().getCode());
			row.setClassHdrSubject(result.getClassDtl().getClassHdr().getSubject());
			row.setClassHdrDescription(result.getClassDtl().getClassHdr().getDescription());
			row.setInstructorId(result.getClassDtl().getClassHdr().getInstructor().getId());
			row.setInstructorEmail(result.getClassDtl().getClassHdr().getInstructor().getEmail());
			row.setInstructorFullname(result.getClassDtl().getClassHdr().getInstructor().getFullname());
			row.setLearningScheduleId(result.getLearningSchedule().getId());
			row.setLearningStartTime(result.getLearningSchedule().getStartTime());
			row.setLearningEndTime(result.getLearningSchedule().getEndTime());
			row.setLearningMaterialId(result.getLearningSchedule().getLearningMaterial().getId());
			row.setLearningCode(result.getLearningSchedule().getLearningMaterial().getCode());
			row.setLearningSubject(result.getLearningSchedule().getLearningMaterial().getSubject());
			row.setLearningDescription(result.getLearningSchedule().getLearningMaterial().getDescription());
			row.setVer(result.getVer());
			row.setIsActive(result.getIsActive());
			rows.add(row);
		}
		final AttendanceListResDto data = new AttendanceListResDto();
		data.setData(rows);
		return data;
	}

	@Override
	public AttendanceListResDto getAttendQuiz(final Long scheduleId) {
		final List<Attendance> query = attendanceDao.getAttendQuiz(scheduleId);
		final List<AttendanceDataDto> rows = new ArrayList<>();
		for (int i = 0; i<query.size(); i++) {
			final Attendance result = query.get(i);
			final AttendanceDataDto row = new AttendanceDataDto();
			row.setId(result.getId());
			row.setApproval(result.getApproval());
			row.setClassDtlId(result.getClassDtl().getId());
			row.setStudentId(result.getClassDtl().getStudent().getId());
			row.setStudentEmail(result.getClassDtl().getStudent().getEmail());
			row.setStudentFullname(result.getClassDtl().getStudent().getFullname());
			row.setClassHdrId(result.getClassDtl().getClassHdr().getId());
			row.setClassHdrCode(result.getClassDtl().getClassHdr().getCode());
			row.setClassHdrSubject(result.getClassDtl().getClassHdr().getSubject());
			row.setClassHdrDescription(result.getClassDtl().getClassHdr().getDescription());
			row.setInstructorId(result.getClassDtl().getClassHdr().getInstructor().getId());
			row.setInstructorEmail(result.getClassDtl().getClassHdr().getInstructor().getEmail());
			row.setInstructorFullname(result.getClassDtl().getClassHdr().getInstructor().getFullname());
			row.setQuizScheduleId(result.getQuizSchedule().getId());
			row.setQuizStartTime(result.getQuizSchedule().getStartTime());
			row.setQuizEndTime(result.getQuizSchedule().getEndTime());
			row.setQuizMaterialId(result.getQuizSchedule().getQuizMaterial().getId());
			row.setQuizCode(result.getQuizSchedule().getQuizMaterial().getCode());
			row.setQuizSubject(result.getQuizSchedule().getQuizMaterial().getSubject());
			row.setQuizDescription(result.getQuizSchedule().getQuizMaterial().getDescription());
			row.setVer(result.getVer());
			row.setIsActive(result.getIsActive());
			rows.add(row);
		}
		final AttendanceListResDto data = new AttendanceListResDto();
		data.setData(rows);
		return data;
	}

	@Override
	public AttendanceListResDto getAttendExam(final Long scheduleId) {
		final List<Attendance> query = attendanceDao.getAttendExam(scheduleId);
		final List<AttendanceDataDto> rows = new ArrayList<>();
		for (int i = 0; i<query.size(); i++) {
			final Attendance result = query.get(i);
			final AttendanceDataDto row = new AttendanceDataDto();
			row.setId(result.getId());
			row.setApproval(result.getApproval());
			row.setClassDtlId(result.getClassDtl().getId());
			row.setStudentId(result.getClassDtl().getStudent().getId());
			row.setStudentEmail(result.getClassDtl().getStudent().getEmail());
			row.setStudentFullname(result.getClassDtl().getStudent().getFullname());
			row.setClassHdrId(result.getClassDtl().getClassHdr().getId());
			row.setClassHdrCode(result.getClassDtl().getClassHdr().getCode());
			row.setClassHdrSubject(result.getClassDtl().getClassHdr().getSubject());
			row.setClassHdrDescription(result.getClassDtl().getClassHdr().getDescription());
			row.setInstructorId(result.getClassDtl().getClassHdr().getInstructor().getId());
			row.setInstructorEmail(result.getClassDtl().getClassHdr().getInstructor().getEmail());
			row.setInstructorFullname(result.getClassDtl().getClassHdr().getInstructor().getFullname());
			row.setExamScheduleId(result.getExamSchedule().getId());
			row.setExamStartTime(result.getExamSchedule().getStartTime());
			row.setExamEndTime(result.getExamSchedule().getEndTime());
			row.setExamMaterialId(result.getExamSchedule().getExamMaterial().getId());
			row.setExamCode(result.getExamSchedule().getExamMaterial().getCode());
			row.setExamSubject(result.getExamSchedule().getExamMaterial().getSubject());
			row.setExamDescription(result.getExamSchedule().getExamMaterial().getDescription());
			row.setVer(result.getVer());
			row.setIsActive(result.getIsActive());
			rows.add(row);
		}
		final AttendanceListResDto data = new AttendanceListResDto();
		data.setData(rows);
		return data;
	}
	
	
}
