package com.lawencon.elearn.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearn.constant.ResponseConst;
import com.lawencon.elearn.dao.ClassDtlDao;
import com.lawencon.elearn.dao.ExamMaterialDao;
import com.lawencon.elearn.dao.ExamScheduleDao;
import com.lawencon.elearn.dto.examschedule.ExamScheduleDataDto;
import com.lawencon.elearn.dto.examschedule.ExamScheduleInsertDataResDto;
import com.lawencon.elearn.dto.examschedule.ExamScheduleInsertReqDto;
import com.lawencon.elearn.dto.examschedule.ExamScheduleInsertResDto;
import com.lawencon.elearn.dto.examschedule.ExamScheduleListResDto;
import com.lawencon.elearn.dto.examschedule.ExamScheduleResDto;
import com.lawencon.elearn.model.ClassDtl;
import com.lawencon.elearn.model.ExamMaterial;
import com.lawencon.elearn.model.ExamSchedule;
import com.lawencon.elearn.service.ExamScheduleService;
import com.lawencon.elearn.service.PrincipalService;

@Service
public class ExamScheduleServiceImpl implements ExamScheduleService{
	@Autowired
	private PrincipalService principalService;
	@Autowired
	private ExamScheduleDao examScheduleDao;
	@Autowired
	private ExamMaterialDao examMaterialDao;
	@Autowired
	private ClassDtlDao classDtlDao;

	@Override
	public ExamScheduleListResDto getAllIdMaterial(final Long idMaterial) {
		final List<ExamSchedule> query = examScheduleDao.getAllIdMaterial(idMaterial);
		final List<ExamScheduleDataDto> rows = new ArrayList<>();
		for (int i = 0; i<query.size(); i++) {
			final ExamSchedule result = query.get(i);
			final ExamScheduleDataDto row = new ExamScheduleDataDto();
			row.setId(result.getId());
			row.setStartTime(result.getStartTime());
			row.setEndTime(result.getEndTime());
			row.setExamId(result.getExamMaterial().getId());
			row.setExamCode(result.getExamMaterial().getCode());
			row.setExamSubject(result.getExamMaterial().getSubject());
			row.setExamDescription(result.getExamMaterial().getDescription());
			row.setVer(result.getVer());
			row.setIsActive(result.getIsActive());
			rows.add(row);
		}
		final ExamScheduleListResDto data = new ExamScheduleListResDto();
		data.setData(rows);
		return data;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public ExamScheduleInsertResDto insert(final ExamScheduleInsertReqDto data) {
		final ExamSchedule row = new ExamSchedule();
		
		row.setStartTime(Timestamp.valueOf(data.getStartTime()).toLocalDateTime());
		row.setEndTime(Timestamp.valueOf(data.getEndTime()).toLocalDateTime());
		final Optional<ExamMaterial> exam = examMaterialDao.getById(data.getExamId());
		row.setExamMaterial(exam.get());
		row.setCreatedBy(principalService.getPrincipal().getId());
		
		final ExamSchedule result = examScheduleDao.insert(row);
		
		final ExamScheduleInsertDataResDto dto = new ExamScheduleInsertDataResDto();
		dto.setId(result.getId());
		final ExamScheduleInsertResDto res = new ExamScheduleInsertResDto();
		res.setData(dto);
		res.setMessage(ResponseConst.CREATED.getResponse());
		return res;
	}

	@Override
	public ExamScheduleListResDto getAllIdClassDtl(final Long classDtlId) {
		final Optional<ClassDtl> getHeader = classDtlDao.getById(classDtlId);
		final ClassDtl header = getHeader.get();
		final long classHdrId = header.getClassHdr().getId();
		final List<ExamSchedule> query = examScheduleDao.getAllIdClassHdr(classHdrId);
		final List<ExamScheduleDataDto> rows = new ArrayList<>();
		for (int i = 0; i<query.size(); i++) {
			final ExamSchedule result = query.get(i);
			final ExamScheduleDataDto row = new ExamScheduleDataDto();
			row.setId(result.getId());
			row.setStartTime(result.getStartTime());
			row.setEndTime(result.getEndTime());
			row.setExamId(result.getExamMaterial().getId());
			row.setExamCode(result.getExamMaterial().getCode());
			row.setExamSubject(result.getExamMaterial().getSubject());
			row.setExamDescription(result.getExamMaterial().getDescription());
			row.setVer(result.getVer());
			row.setIsActive(result.getIsActive());
			rows.add(row);
		}
		final ExamScheduleListResDto data = new ExamScheduleListResDto();
		data.setData(rows);
		return data;
	}

	@Override
	public ExamScheduleResDto getById(final Long id) {
		final Optional<ExamSchedule> query = examScheduleDao.getById(id);
		final ExamSchedule result = query.get();
		final ExamScheduleDataDto row = new ExamScheduleDataDto();
		row.setId(result.getId());
		row.setStartTime(result.getStartTime());
		row.setEndTime(result.getEndTime());
		row.setExamId(result.getExamMaterial().getId());
		row.setExamCode(result.getExamMaterial().getCode());
		row.setExamSubject(result.getExamMaterial().getSubject());
		row.setExamDescription(result.getExamMaterial().getDescription());
		row.setVer(result.getVer());
		row.setIsActive(result.getIsActive());
		final ExamScheduleResDto data = new ExamScheduleResDto();
		data.setData(row);
		return data;
	}
}
