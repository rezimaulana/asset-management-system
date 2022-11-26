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
import com.lawencon.elearn.dao.QuizAttachDao;
import com.lawencon.elearn.dao.QuizMaterialDao;
import com.lawencon.elearn.dto.quizmaterial.QuizMaterialDataDto;
import com.lawencon.elearn.dto.quizmaterial.QuizMaterialInsertDataResDto;
import com.lawencon.elearn.dto.quizmaterial.QuizMaterialInsertReqDto;
import com.lawencon.elearn.dto.quizmaterial.QuizMaterialInsertResDto;
import com.lawencon.elearn.dto.quizmaterial.QuizMaterialListResDto;
import com.lawencon.elearn.dto.quizmaterial.QuizMaterialResDto;
import com.lawencon.elearn.model.ClassHdr;
import com.lawencon.elearn.model.File;
import com.lawencon.elearn.model.QuizAttach;
import com.lawencon.elearn.model.QuizMaterial;
import com.lawencon.elearn.service.GenerateCodeService;
import com.lawencon.elearn.service.PrincipalService;
import com.lawencon.elearn.service.QuizMaterialService;

@Service
public class QuizMaterialServiceImpl implements QuizMaterialService{
	@Autowired
	private GenerateCodeService generateCodeService;
	@Autowired
	private PrincipalService principalService;
	@Autowired 
	private QuizAttachDao quizAttachDao;
	@Autowired
	private ClassHdrDao classHdrDao;
	@Autowired
	private QuizMaterialDao quizMaterialDao;
	@Autowired
	private FileDao fileDao;

	@Override
	public QuizMaterialListResDto getAllIdClass(final Long classId) {
		final List<QuizAttach> query = quizAttachDao.getAllIdClass(classId);
		final List<QuizMaterialDataDto> rows = new ArrayList<>();
		for (int i = 0; i<query.size(); i++) {
			final QuizAttach result = query.get(i);
			final QuizMaterialDataDto row = new QuizMaterialDataDto();
			row.setId(result.getId());
			row.setQuizCode(result.getQuizMaterial().getCode());
			row.setQuizSubject(result.getQuizMaterial().getSubject());
			row.setQuizDescription(result.getQuizMaterial().getDescription());
			row.setClassId(result.getQuizMaterial().getClassHdr().getId());
			row.setClassCode(result.getQuizMaterial().getClassHdr().getCode());
			row.setClassSubject(result.getQuizMaterial().getClassHdr().getSubject());
			row.setFileId(result.getFile().getId());
			row.setFileCode(result.getFile().getCode());
			row.setFileExt(result.getFile().getExt());
			row.setCreatedAt(result.getCreatedAt());
			row.setVer(result.getVer());
			row.setIsActive(result.getIsActive());
			rows.add(row);
		}
		final QuizMaterialListResDto data = new QuizMaterialListResDto();
		data.setData(rows);
		return data;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public QuizMaterialInsertResDto insert(final QuizMaterialInsertReqDto data) {
		final QuizAttach row = new QuizAttach();
		
		final QuizMaterial material = new QuizMaterial();
		final String plainText = generateCodeService.generateDigit(10);
		material.setCode(plainText);
		material.setSubject(data.getQuizSubject());
		material.setDescription(data.getQuizDescription());
		final Optional<ClassHdr> classes = classHdrDao.getById(data.getClassId());
		material.setClassHdr(classes.get());
		material.setCreatedBy(principalService.getPrincipal().getId());
		final QuizMaterial insertQuiz = quizMaterialDao.insert(material);
		
		final File file = new File();
		file.setCode(data.getFileCode());
		file.setExt(data.getFileExt());
		file.setCreatedBy(principalService.getPrincipal().getId());
		final File insertFile = fileDao.insert(file);
		
		row.setQuizMaterial(insertQuiz);
		row.setFile(insertFile);
		row.setCreatedBy(principalService.getPrincipal().getId());
		final QuizAttach result = quizAttachDao.insert(row);
		
		final QuizMaterialInsertDataResDto dto = new QuizMaterialInsertDataResDto();
		dto.setId(result.getId());
		final QuizMaterialInsertResDto res = new QuizMaterialInsertResDto();
		res.setData(dto);
		res.setMessage(ResponseConst.CREATED.getResponse());
		return res;
	}
	
	@Override
	public QuizMaterialResDto getById(final Long id) {
		final Optional<QuizMaterial> query = quizMaterialDao.getById(id);
		final QuizMaterial result = query.get();
		final QuizMaterialDataDto row = new QuizMaterialDataDto();
		row.setId(result.getId());
		row.setQuizCode(result.getCode());
		row.setQuizSubject(result.getSubject());
		row.setQuizDescription(result.getDescription());
		row.setClassId(result.getClassHdr().getId());
		row.setClassCode(result.getClassHdr().getCode());
		row.setClassSubject(result.getClassHdr().getSubject());
		
		final List<QuizAttach> file = quizAttachDao.getAllIdMaterial(result.getId());
		List<Long> fileId = new ArrayList<>();
		for (int j=0; j<file.size(); j++) {
			fileId.add(file.get(j).getId());
			row.setFileList(fileId);
		}
		
		row.setCreatedAt(result.getCreatedAt());
		row.setVer(result.getVer());
		row.setIsActive(result.getIsActive());
		final QuizMaterialResDto data = new QuizMaterialResDto();
		data.setData(row);
		return data;
	}
}
