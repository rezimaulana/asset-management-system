package com.lawencon.elearn.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearn.constant.ResponseConst;
import com.lawencon.elearn.dao.ClassDtlDao;
import com.lawencon.elearn.dao.ExamCollectionDao;
import com.lawencon.elearn.dao.ExamScheduleDao;
import com.lawencon.elearn.dao.FileDao;
import com.lawencon.elearn.dto.examcollection.ExamCollectionDataDto;
import com.lawencon.elearn.dto.examcollection.ExamCollectionInsertDataResDto;
import com.lawencon.elearn.dto.examcollection.ExamCollectionInsertReqDto;
import com.lawencon.elearn.dto.examcollection.ExamCollectionInsertResDto;
import com.lawencon.elearn.dto.examcollection.ExamCollectionListResDto;
import com.lawencon.elearn.dto.examcollection.ExamCollectionUpdateDataResDto;
import com.lawencon.elearn.dto.examcollection.ExamCollectionUpdateReqDto;
import com.lawencon.elearn.dto.examcollection.ExamCollectionUpdateResDto;
import com.lawencon.elearn.model.ClassDtl;
import com.lawencon.elearn.model.ExamCollection;
import com.lawencon.elearn.model.ExamSchedule;
import com.lawencon.elearn.model.File;
import com.lawencon.elearn.service.ExamCollectionService;
import com.lawencon.elearn.service.PrincipalService;

@Service
public class ExamCollectionServiceImpl implements ExamCollectionService{
	@Autowired
	private PrincipalService principalService;
	@Autowired
	private ExamCollectionDao examCollectionDao;
	@Autowired
	private ExamScheduleDao examScheduleDao;
	@Autowired
	private ClassDtlDao classDtlDao;
	@Autowired
	private FileDao fileDao;
	
	@Transactional(rollbackOn = Exception.class)
	@Override
	public ExamCollectionInsertResDto insert(final ExamCollectionInsertReqDto data) {
		final ExamCollection row = new ExamCollection();
		final Optional<ClassDtl> classDtl = classDtlDao.getById(data.getClassDtlId());
		row.setClassDtl(classDtl.get());
		final Optional<ExamSchedule> examSchedule= examScheduleDao.getById(data.getExamScheduleId());
		row.setExamSchedule(examSchedule.get());
		row.setClassDtl(classDtl.get());
		File file = new File();
		file.setCode(data.getFileCode());
		file.setExt(data.getFileExt());
		file.setCreatedBy(principalService.getPrincipal().getId());
		file = fileDao.insert(file);
		row.setFile(file);
		row.setCreatedBy(principalService.getPrincipal().getId());
		final ExamCollection result = examCollectionDao.insert(row);
		final ExamCollectionInsertDataResDto dto = new ExamCollectionInsertDataResDto();
		dto.setId(result.getId());
		final ExamCollectionInsertResDto res = new ExamCollectionInsertResDto();
		res.setData(dto);
		res.setMessage(ResponseConst.CREATED.getResponse());
		return res;
	}
	
	@Transactional(rollbackOn = Exception.class)
	@Override
	public ExamCollectionUpdateResDto update(final ExamCollectionUpdateReqDto data) {
		final Optional<ExamCollection> optional = examCollectionDao.getById(data.getId());
		ExamCollection row = null;
		final ExamCollectionUpdateResDto res = new ExamCollectionUpdateResDto();
		if(optional.isPresent()) {
			row = optional.get();
			row.setScore(data.getScore());
			row.setUpdatedBy(principalService.getPrincipal().getId());
			row.setVer(data.getVer());
			row.setIsActive(data.getIsActive());
			row = examCollectionDao.update(row);
			final ExamCollectionUpdateDataResDto dto = new ExamCollectionUpdateDataResDto();
			dto.setVer(row.getVer());
			res.setData(dto);
			res.setMessage(ResponseConst.UPDATED.getResponse());
		}
		return res;
	}

	@Override
	public ExamCollectionListResDto getAllClsDtlIdScheduleId(final long classDtlId, final long scheduleId) {
		final List<ExamCollection> query = examCollectionDao.getAllClsDtlIdScheduleId(classDtlId, scheduleId);
		final List<ExamCollectionDataDto> rows = new ArrayList<>();
		for (int i = 0; i<query.size(); i++) {
			final ExamCollection result = query.get(i);
			final ExamCollectionDataDto row = new ExamCollectionDataDto();
			row.setId(result.getId());
			row.setScore(result.getScore());
			row.setStudentEmail(result.getClassDtl().getStudent().getEmail());
			row.setStudentName(result.getClassDtl().getStudent().getFullname());
			row.setFileId(result.getFile().getId());
			row.setVer(result.getVer());
			row.setIsActive(result.getIsActive());
			rows.add(row);
		}
		final ExamCollectionListResDto data = new ExamCollectionListResDto();
		data.setData(rows);
		return data;
	}
}
