package com.lawencon.elearn.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearn.constant.ResponseConst;
import com.lawencon.elearn.dao.ClassDtlDao;
import com.lawencon.elearn.dao.FileDao;
import com.lawencon.elearn.dao.QuizCollectionDao;
import com.lawencon.elearn.dao.QuizScheduleDao;
import com.lawencon.elearn.dto.quizcollection.QuizCollectionDataDto;
import com.lawencon.elearn.dto.quizcollection.QuizCollectionInsertDataResDto;
import com.lawencon.elearn.dto.quizcollection.QuizCollectionInsertReqDto;
import com.lawencon.elearn.dto.quizcollection.QuizCollectionInsertResDto;
import com.lawencon.elearn.dto.quizcollection.QuizCollectionListResDto;
import com.lawencon.elearn.dto.quizcollection.QuizCollectionUpdateDataResDto;
import com.lawencon.elearn.dto.quizcollection.QuizCollectionUpdateReqDto;
import com.lawencon.elearn.dto.quizcollection.QuizCollectionUpdateResDto;
import com.lawencon.elearn.model.ClassDtl;
import com.lawencon.elearn.model.File;
import com.lawencon.elearn.model.QuizCollection;
import com.lawencon.elearn.model.QuizSchedule;
import com.lawencon.elearn.service.PrincipalService;
import com.lawencon.elearn.service.QuizCollectionService;

@Service
public class QuizCollectionServiceImpl implements QuizCollectionService{
	@Autowired
	private PrincipalService principalService;
	@Autowired
	private QuizCollectionDao quizCollectionDao;
	@Autowired
	private QuizScheduleDao quizScheduleDao;
	@Autowired
	private ClassDtlDao classDtlDao;
	@Autowired
	private FileDao fileDao;
	
	@Transactional(rollbackOn = Exception.class)
	@Override
	public QuizCollectionInsertResDto insert(final QuizCollectionInsertReqDto data) {
		final QuizCollection row = new QuizCollection();
		final Optional<ClassDtl> classDtl = classDtlDao.getById(data.getClassDtlId());
		row.setClassDtl(classDtl.get());
		final Optional<QuizSchedule> quizSchedule= quizScheduleDao.getById(data.getQuizScheduleId());
		row.setQuizSchedule(quizSchedule.get());
		row.setClassDtl(classDtl.get());
		File file = new File();
		file.setCode(data.getFileCode());
		file.setExt(data.getFileExt());
		file.setCreatedBy(principalService.getPrincipal().getId());
		file = fileDao.insert(file);
		row.setFile(file);
		row.setCreatedBy(principalService.getPrincipal().getId());
		final QuizCollection result = quizCollectionDao.insert(row);
		final QuizCollectionInsertDataResDto dto = new QuizCollectionInsertDataResDto();
		dto.setId(result.getId());
		final QuizCollectionInsertResDto res = new QuizCollectionInsertResDto();
		res.setData(dto);
		res.setMessage(ResponseConst.CREATED.getResponse());
		return res;
	}

	@Transactional(rollbackOn = Exception.class)
	@Override
	public QuizCollectionUpdateResDto update(final QuizCollectionUpdateReqDto data) {
		final Optional<QuizCollection> optional = quizCollectionDao.getById(data.getId());
		QuizCollection row = null;
		final QuizCollectionUpdateResDto res = new QuizCollectionUpdateResDto();
		if(optional.isPresent()) {
			row = optional.get();
			row.setScore(data.getScore());
			row.setUpdatedBy(principalService.getPrincipal().getId());
			row.setVer(data.getVer());
			row.setIsActive(data.getIsActive());
			row = quizCollectionDao.update(row);
			final QuizCollectionUpdateDataResDto dto = new QuizCollectionUpdateDataResDto();
			dto.setVer(row.getVer());
			res.setData(dto);
			res.setMessage(ResponseConst.UPDATED.getResponse());
		}
		return res;
	}

	@Override
	public QuizCollectionListResDto getAllClsDtlIdScheduleId(final long classDtlId, final long scheduleId) {
		final List<QuizCollection> query = quizCollectionDao.getAllClsDtlIdScheduleId(classDtlId, scheduleId);
		final List<QuizCollectionDataDto> rows = new ArrayList<>();
		for (int i = 0; i<query.size(); i++) {
			final QuizCollection result = query.get(i);
			final QuizCollectionDataDto row = new QuizCollectionDataDto();
			row.setId(result.getId());
			row.setScore(result.getScore());
			row.setStudentEmail(result.getClassDtl().getStudent().getEmail());
			row.setStudentName(result.getClassDtl().getStudent().getFullname());
			row.setFileId(result.getFile().getId());
			row.setVer(result.getVer());
			row.setIsActive(result.getIsActive());
			rows.add(row);
		}
		final QuizCollectionListResDto data = new QuizCollectionListResDto();
		data.setData(rows);
		return data;
	}
}
