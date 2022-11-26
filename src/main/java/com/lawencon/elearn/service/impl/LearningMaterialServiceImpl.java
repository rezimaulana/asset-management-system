package com.lawencon.elearn.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearn.constant.ResponseConst;
import com.lawencon.elearn.dao.ClassHdrDao;
import com.lawencon.elearn.dao.FileDao;
import com.lawencon.elearn.dao.LearningAttachDao;
import com.lawencon.elearn.dao.LearningMaterialDao;
import com.lawencon.elearn.dto.learningmaterial.LearningMaterialDataDto;
import com.lawencon.elearn.dto.learningmaterial.LearningMaterialInsertDataResDto;
import com.lawencon.elearn.dto.learningmaterial.LearningMaterialInsertReqDto;
import com.lawencon.elearn.dto.learningmaterial.LearningMaterialInsertResDto;
import com.lawencon.elearn.dto.learningmaterial.LearningMaterialListResDto;
import com.lawencon.elearn.dto.learningmaterial.LearningMaterialResDto;
import com.lawencon.elearn.model.ClassHdr;
import com.lawencon.elearn.model.File;
import com.lawencon.elearn.model.LearningAttach;
import com.lawencon.elearn.model.LearningMaterial;
import com.lawencon.elearn.service.GenerateCodeService;
import com.lawencon.elearn.service.LearningMaterialService;
import com.lawencon.elearn.service.PrincipalService;

@Service
public class LearningMaterialServiceImpl implements LearningMaterialService{
	@Autowired
	private GenerateCodeService generateCodeService;
	@Autowired
	private PrincipalService principalService;
	@Autowired 
	private LearningAttachDao learningAttachDao;
	@Autowired
	private ClassHdrDao classHdrDao;
	@Autowired
	private LearningMaterialDao learningMaterialDao;
	@Autowired
	private FileDao fileDao;

	@Override
	public LearningMaterialListResDto getAllIdClass(final Long classId) {
		final List<LearningAttach> query = learningAttachDao.getAllIdClass(classId);
		final List<LearningMaterialDataDto> rows = new ArrayList<>();
		for (int i = 0; i<query.size(); i++) {
			final LearningAttach result = query.get(i);
			final LearningMaterialDataDto row = new LearningMaterialDataDto();
			row.setId(result.getId());
			row.setLearningCode(result.getLearningMaterial().getCode());
			row.setLearningSubject(result.getLearningMaterial().getSubject());
			row.setLearningDescription(result.getLearningMaterial().getDescription());
			row.setClassId(result.getLearningMaterial().getClassHdr().getId());
			row.setClassCode(result.getLearningMaterial().getClassHdr().getCode());
			row.setClassSubject(result.getLearningMaterial().getClassHdr().getSubject());
			row.setFileId(result.getFile().getId());
			row.setFileCode(result.getFile().getCode());
			row.setFileExt(result.getFile().getExt());
			row.setCreatedAt(result.getCreatedAt());
			row.setVer(result.getVer());
			row.setIsActive(result.getIsActive());
			rows.add(row);
		}
		final LearningMaterialListResDto data = new LearningMaterialListResDto();
		data.setData(rows);
		return data;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public LearningMaterialInsertResDto insert(final LearningMaterialInsertReqDto data) {
		final LearningAttach row = new LearningAttach();
		
		final LearningMaterial material = new LearningMaterial();
		final String plainText = generateCodeService.generateDigit(10);
		material.setCode(plainText);
		material.setSubject(data.getLearningSubject());
		material.setDescription(data.getLearningDescription());
		final Optional<ClassHdr> classes = classHdrDao.getById(data.getClassId());
		material.setClassHdr(classes.get());
		material.setCreatedBy(principalService.getPrincipal().getId());
		final LearningMaterial insertLearning = learningMaterialDao.insert(material);
		
		final File file = new File();
		file.setCode(data.getFileCode());
		file.setExt(data.getFileExt());
		file.setCreatedBy(principalService.getPrincipal().getId());
		final File insertFile = fileDao.insert(file);
		
		row.setLearningMaterial(insertLearning);
		row.setFile(insertFile);
		row.setCreatedBy(principalService.getPrincipal().getId());
		final LearningAttach result = learningAttachDao.insert(row);
		
		final LearningMaterialInsertDataResDto dto = new LearningMaterialInsertDataResDto();
		dto.setId(result.getId());
		final LearningMaterialInsertResDto res = new LearningMaterialInsertResDto();
		res.setData(dto);
		res.setMessage(ResponseConst.CREATED.getResponse());
		return res;
	}

	@Override
	public LearningMaterialResDto getById(final Long id) {
		final Optional<LearningMaterial> query = learningMaterialDao.getById(id);
		final LearningMaterial result = query.get();
		final LearningMaterialDataDto row = new LearningMaterialDataDto();
		row.setId(result.getId());
		row.setLearningCode(result.getCode());
		row.setLearningSubject(result.getSubject());
		row.setLearningDescription(result.getDescription());
		row.setClassId(result.getClassHdr().getId());
		row.setClassCode(result.getClassHdr().getCode());
		row.setClassSubject(result.getClassHdr().getSubject());
		
		final List<LearningAttach> file = learningAttachDao.getAllIdMaterial(result.getId());
		List<Long> fileId = new ArrayList<>();
		for (int j=0; j<file.size(); j++) {
			fileId.add(file.get(j).getId());
			row.setFileList(fileId);
		}
		
		row.setCreatedAt(result.getCreatedAt());
		row.setVer(result.getVer());
		row.setIsActive(result.getIsActive());
		final LearningMaterialResDto data = new LearningMaterialResDto();
		data.setData(row);
		return data;
	}
}
