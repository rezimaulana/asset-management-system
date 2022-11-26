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
import com.lawencon.elearn.dao.LearningMaterialDao;
import com.lawencon.elearn.dao.LearningScheduleDao;
import com.lawencon.elearn.dto.learningschedule.LearningScheduleDataDto;
import com.lawencon.elearn.dto.learningschedule.LearningScheduleInsertDataResDto;
import com.lawencon.elearn.dto.learningschedule.LearningScheduleInsertReqDto;
import com.lawencon.elearn.dto.learningschedule.LearningScheduleInsertResDto;
import com.lawencon.elearn.dto.learningschedule.LearningScheduleListResDto;
import com.lawencon.elearn.dto.learningschedule.LearningScheduleResDto;
import com.lawencon.elearn.model.ClassDtl;
import com.lawencon.elearn.model.LearningMaterial;
import com.lawencon.elearn.model.LearningSchedule;
import com.lawencon.elearn.service.LearningScheduleService;
import com.lawencon.elearn.service.PrincipalService;

@Service
public class LearningScheduleServiceImpl implements LearningScheduleService{
	@Autowired
	private PrincipalService principalService;
	@Autowired
	private LearningScheduleDao learningScheduleDao;
	@Autowired
	private LearningMaterialDao learningMaterialDao;
	@Autowired
	private ClassDtlDao classDtlDao;
	
	@Override
	public LearningScheduleListResDto getAllIdMaterial(final Long idMaterial) {
		final List<LearningSchedule> query = learningScheduleDao.getAllIdMaterial(idMaterial);
		final List<LearningScheduleDataDto> rows = new ArrayList<>();
		for (int i = 0; i<query.size(); i++) {
			final LearningSchedule result = query.get(i);
			final LearningScheduleDataDto row = new LearningScheduleDataDto();
			row.setId(result.getId());
			row.setStartTime(result.getStartTime());
			row.setEndTime(result.getEndTime());
			row.setLearningId(result.getLearningMaterial().getId());
			row.setLearningCode(result.getLearningMaterial().getCode());
			row.setLearningSubject(result.getLearningMaterial().getSubject());
			row.setLearningDescription(result.getLearningMaterial().getDescription());
			row.setVer(result.getVer());
			row.setIsActive(result.getIsActive());
			rows.add(row);
		}
		final LearningScheduleListResDto data = new LearningScheduleListResDto();
		data.setData(rows);
		return data;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public LearningScheduleInsertResDto insert(final LearningScheduleInsertReqDto data) {
		final LearningSchedule row = new LearningSchedule();
		
		row.setStartTime(Timestamp.valueOf(data.getStartTime()).toLocalDateTime());
		row.setEndTime(Timestamp.valueOf(data.getEndTime()).toLocalDateTime());
		final Optional<LearningMaterial> learning = learningMaterialDao.getById(data.getLearningId());
		row.setLearningMaterial(learning.get());
		row.setCreatedBy(principalService.getPrincipal().getId());
		
		final LearningSchedule result = learningScheduleDao.insert(row);
		
		final LearningScheduleInsertDataResDto dto = new LearningScheduleInsertDataResDto();
		dto.setId(result.getId());
		final LearningScheduleInsertResDto res = new LearningScheduleInsertResDto();
		res.setData(dto);
		res.setMessage(ResponseConst.CREATED.getResponse());
		return res;
	}

	@Override
	public LearningScheduleListResDto getAllIdClassDtl(final Long classDtlId) {
		final Optional<ClassDtl> getHeader = classDtlDao.getById(classDtlId);
		final ClassDtl header = getHeader.get();
		final long classHdrId = header.getClassHdr().getId();
		final List<LearningSchedule> query = learningScheduleDao.getAllIdClassHdr(classHdrId);
		final List<LearningScheduleDataDto> rows = new ArrayList<>();
		for (int i = 0; i<query.size(); i++) {
			final LearningSchedule result = query.get(i);
			final LearningScheduleDataDto row = new LearningScheduleDataDto();
			row.setId(result.getId());
			row.setStartTime(result.getStartTime());
			row.setEndTime(result.getEndTime());
			row.setLearningId(result.getLearningMaterial().getId());
			row.setLearningCode(result.getLearningMaterial().getCode());
			row.setLearningSubject(result.getLearningMaterial().getSubject());
			row.setLearningDescription(result.getLearningMaterial().getDescription());
			row.setVer(result.getVer());
			row.setIsActive(result.getIsActive());
			rows.add(row);
		}
		final LearningScheduleListResDto data = new LearningScheduleListResDto();
		data.setData(rows);
		return data;
	}

	@Override
	public LearningScheduleResDto getById(final Long id) {
		final Optional<LearningSchedule> query = learningScheduleDao.getById(id);
		final LearningSchedule result = query.get();
		final LearningScheduleDataDto row = new LearningScheduleDataDto();
		row.setId(result.getId());
		row.setStartTime(result.getStartTime());
		row.setEndTime(result.getEndTime());
		row.setLearningId(result.getLearningMaterial().getId());
		row.setLearningCode(result.getLearningMaterial().getCode());
		row.setLearningSubject(result.getLearningMaterial().getSubject());
		row.setLearningDescription(result.getLearningMaterial().getDescription());
		row.setVer(result.getVer());
		row.setIsActive(result.getIsActive());
		final LearningScheduleResDto data = new LearningScheduleResDto();
		data.setData(row);
		return data;
	}
}
