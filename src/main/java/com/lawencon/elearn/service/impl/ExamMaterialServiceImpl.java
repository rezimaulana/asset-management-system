package com.lawencon.elearn.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearn.constant.ResponseConst;
import com.lawencon.elearn.dao.ClassHdrDao;
import com.lawencon.elearn.dao.ExamAttachDao;
import com.lawencon.elearn.dao.ExamMaterialDao;
import com.lawencon.elearn.dao.FileDao;
import com.lawencon.elearn.dto.exammaterial.ExamMaterialDataDto;
import com.lawencon.elearn.dto.exammaterial.ExamMaterialInsertDataResDto;
import com.lawencon.elearn.dto.exammaterial.ExamMaterialInsertReqDto;
import com.lawencon.elearn.dto.exammaterial.ExamMaterialInsertResDto;
import com.lawencon.elearn.dto.exammaterial.ExamMaterialListResDto;
import com.lawencon.elearn.dto.exammaterial.ExamMaterialResDto;
import com.lawencon.elearn.model.ClassHdr;
import com.lawencon.elearn.model.ExamAttach;
import com.lawencon.elearn.model.ExamMaterial;
import com.lawencon.elearn.model.File;
import com.lawencon.elearn.service.ExamMaterialService;
import com.lawencon.elearn.service.GenerateCodeService;
import com.lawencon.elearn.service.PrincipalService;

@Service
public class ExamMaterialServiceImpl implements ExamMaterialService {
	@Autowired
	private GenerateCodeService generateCodeService;
	@Autowired
	private PrincipalService principalService;
	@Autowired 
	private ExamAttachDao examAttachDao;
	@Autowired
	private ClassHdrDao classHdrDao;
	@Autowired
	private ExamMaterialDao examMaterialDao;
	@Autowired
	private FileDao fileDao;

	@Override
	public ExamMaterialListResDto getAllIdClass(final Long classId) {
		final List<ExamAttach> query = examAttachDao.getAllIdClass(classId);
		final List<ExamMaterialDataDto> rows = new ArrayList<>();
		for (int i = 0; i<query.size(); i++) {
			final ExamAttach result = query.get(i);
			final ExamMaterialDataDto row = new ExamMaterialDataDto();
			row.setId(result.getId());
			row.setExamCode(result.getExamMaterial().getCode());
			row.setExamSubject(result.getExamMaterial().getSubject());
			row.setExamDescription(result.getExamMaterial().getDescription());
			row.setClassId(result.getExamMaterial().getClassHdr().getId());
			row.setClassCode(result.getExamMaterial().getClassHdr().getCode());
			row.setClassSubject(result.getExamMaterial().getClassHdr().getSubject());
			row.setFileId(result.getFile().getId());
			row.setFileCode(result.getFile().getCode());
			row.setFileExt(result.getFile().getExt());
			row.setCreatedAt(result.getCreatedAt());
			row.setVer(result.getVer());
			row.setIsActive(result.getIsActive());
			rows.add(row);
		}
		final ExamMaterialListResDto data = new ExamMaterialListResDto();
		data.setData(rows);
		return data;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public ExamMaterialInsertResDto insert(ExamMaterialInsertReqDto data) {
		final ExamAttach row = new ExamAttach();
		
		final ExamMaterial material = new ExamMaterial();
		final String plainText = generateCodeService.generateDigit(10);
		material.setCode(plainText);
		material.setSubject(data.getExamSubject());
		material.setDescription(data.getExamDescription());
		final Optional<ClassHdr> classes = classHdrDao.getById(data.getClassId());
		material.setClassHdr(classes.get());
		material.setCreatedBy(principalService.getPrincipal().getId());
		final ExamMaterial insertExam = examMaterialDao.insert(material);
		
		final File file = new File();
		file.setCode(data.getFileCode());
		file.setExt(data.getFileExt());
		file.setCreatedBy(principalService.getPrincipal().getId());
		final File insertFile = fileDao.insert(file);
		
		row.setExamMaterial(insertExam);
		row.setFile(insertFile);
		row.setCreatedBy(principalService.getPrincipal().getId());
		final ExamAttach result = examAttachDao.insert(row);
		
		final ExamMaterialInsertDataResDto dto = new ExamMaterialInsertDataResDto();
		dto.setId(result.getId());
		final ExamMaterialInsertResDto res = new ExamMaterialInsertResDto();
		res.setData(dto);
		res.setMessage(ResponseConst.CREATED.getResponse());
		return res;
	}

	@Override
	public ExamMaterialResDto getById(final Long id) {
		final Optional<ExamMaterial> query = examMaterialDao.getById(id);
		final ExamMaterial result = query.get();
		final ExamMaterialDataDto row = new ExamMaterialDataDto();
		row.setId(result.getId());
		row.setExamCode(result.getCode());
		row.setExamSubject(result.getSubject());
		row.setExamDescription(result.getDescription());
		row.setClassId(result.getClassHdr().getId());
		row.setClassCode(result.getClassHdr().getCode());
		row.setClassSubject(result.getClassHdr().getSubject());
		
		final List<ExamAttach> file = examAttachDao.getAllIdMaterial(result.getId());
		List<Long> fileId = new ArrayList<>();
		for (int j=0; j<file.size(); j++) {
			fileId.add(file.get(j).getId());
			row.setFileList(fileId);
		}
		
		row.setCreatedAt(result.getCreatedAt());
		row.setVer(result.getVer());
		row.setIsActive(result.getIsActive());
		final ExamMaterialResDto data = new ExamMaterialResDto();
		data.setData(row);
		return data;
	}
}
