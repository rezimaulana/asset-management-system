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
import com.lawencon.elearn.dao.QuizMaterialDao;
import com.lawencon.elearn.dao.QuizScheduleDao;
import com.lawencon.elearn.dto.quizschedule.QuizScheduleDataDto;
import com.lawencon.elearn.dto.quizschedule.QuizScheduleInsertDataResDto;
import com.lawencon.elearn.dto.quizschedule.QuizScheduleInsertReqDto;
import com.lawencon.elearn.dto.quizschedule.QuizScheduleInsertResDto;
import com.lawencon.elearn.dto.quizschedule.QuizScheduleListResDto;
import com.lawencon.elearn.dto.quizschedule.QuizScheduleResDto;
import com.lawencon.elearn.model.ClassDtl;
import com.lawencon.elearn.model.QuizMaterial;
import com.lawencon.elearn.model.QuizSchedule;
import com.lawencon.elearn.service.PrincipalService;
import com.lawencon.elearn.service.QuizScheduleService;

@Service
public class QuizScheduleServiceImpl implements QuizScheduleService{
	@Autowired
	private PrincipalService principalService;
	@Autowired
	private QuizScheduleDao quizScheduleDao;
	@Autowired
	private QuizMaterialDao quizMaterialDao;
	@Autowired
	private ClassDtlDao classDtlDao;

	@Override
	public QuizScheduleListResDto getAllIdMaterial(final Long idMaterial) {
		final List<QuizSchedule> query = quizScheduleDao.getAllIdMaterial(idMaterial);
		final List<QuizScheduleDataDto> rows = new ArrayList<>();
		for (int i = 0; i<query.size(); i++) {
			final QuizSchedule result = query.get(i);
			final QuizScheduleDataDto row = new QuizScheduleDataDto();
			row.setId(result.getId());
			row.setStartTime(result.getStartTime());
			row.setEndTime(result.getEndTime());
			row.setQuizId(result.getQuizMaterial().getId());
			row.setQuizCode(result.getQuizMaterial().getCode());
			row.setQuizSubject(result.getQuizMaterial().getSubject());
			row.setQuizDescription(result.getQuizMaterial().getDescription());
			row.setVer(result.getVer());
			row.setIsActive(result.getIsActive());
			rows.add(row);
		}
		final QuizScheduleListResDto data = new QuizScheduleListResDto();
		data.setData(rows);
		return data;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public QuizScheduleInsertResDto insert(final QuizScheduleInsertReqDto data) {
		final QuizSchedule row = new QuizSchedule();
		
		row.setStartTime(Timestamp.valueOf(data.getStartTime()).toLocalDateTime());
		row.setEndTime(Timestamp.valueOf(data.getEndTime()).toLocalDateTime());
		final Optional<QuizMaterial> quiz = quizMaterialDao.getById(data.getQuizId());
		row.setQuizMaterial(quiz.get());
		row.setCreatedBy(principalService.getPrincipal().getId());
		
		final QuizSchedule result = quizScheduleDao.insert(row);
		
		final QuizScheduleInsertDataResDto dto = new QuizScheduleInsertDataResDto();
		dto.setId(result.getId());
		final QuizScheduleInsertResDto res = new QuizScheduleInsertResDto();
		res.setData(dto);
		res.setMessage(ResponseConst.CREATED.getResponse());
		return res;
	}

	@Override
	public QuizScheduleListResDto getAllIdClassDtl(final Long classDtlId) {
		final Optional<ClassDtl> getHeader = classDtlDao.getById(classDtlId);
		final ClassDtl header = getHeader.get();
		final long classHdrId = header.getClassHdr().getId();
		final List<QuizSchedule> query = quizScheduleDao.getAllIdClassHdr(classHdrId);
		final List<QuizScheduleDataDto> rows = new ArrayList<>();
		for (int i = 0; i<query.size(); i++) {
			final QuizSchedule result = query.get(i);
			final QuizScheduleDataDto row = new QuizScheduleDataDto();
			row.setId(result.getId());
			row.setStartTime(result.getStartTime());
			row.setEndTime(result.getEndTime());
			row.setQuizId(result.getQuizMaterial().getId());
			row.setQuizCode(result.getQuizMaterial().getCode());
			row.setQuizSubject(result.getQuizMaterial().getSubject());
			row.setQuizDescription(result.getQuizMaterial().getDescription());
			row.setVer(result.getVer());
			row.setIsActive(result.getIsActive());
			rows.add(row);
		}
		final QuizScheduleListResDto data = new QuizScheduleListResDto();
		data.setData(rows);
		return data;
	}

	@Override
	public QuizScheduleResDto getById(final Long id) {
		final Optional<QuizSchedule> query = quizScheduleDao.getById(id);
		final QuizSchedule result = query.get();
		final QuizScheduleDataDto row = new QuizScheduleDataDto();
		row.setId(result.getId());
		row.setStartTime(result.getStartTime());
		row.setEndTime(result.getEndTime());
		row.setQuizId(result.getQuizMaterial().getId());
		row.setQuizCode(result.getQuizMaterial().getCode());
		row.setQuizSubject(result.getQuizMaterial().getSubject());
		row.setQuizDescription(result.getQuizMaterial().getDescription());
		row.setVer(result.getVer());
		row.setIsActive(result.getIsActive());
		final QuizScheduleResDto data = new QuizScheduleResDto();
		data.setData(row);
		return data;
	}
}
