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
import com.lawencon.elearn.dao.UserDao;
import com.lawencon.elearn.dto.classhdr.ClassHdrDataDto;
import com.lawencon.elearn.dto.classhdr.ClassHdrInsertDataResDto;
import com.lawencon.elearn.dto.classhdr.ClassHdrInsertReqDto;
import com.lawencon.elearn.dto.classhdr.ClassHdrInsertResDto;
import com.lawencon.elearn.dto.classhdr.ClassHdrListResDto;
import com.lawencon.elearn.dto.classhdr.ClassHdrResDto;
import com.lawencon.elearn.model.ClassHdr;
import com.lawencon.elearn.model.File;
import com.lawencon.elearn.model.User;
import com.lawencon.elearn.service.ClassHdrService;
import com.lawencon.elearn.service.GenerateCodeService;
import com.lawencon.elearn.service.PrincipalService;

@Service
public class ClassHdrServiceImpl implements ClassHdrService{
	@Autowired
	private GenerateCodeService generateCodeService;
	@Autowired
	private PrincipalService principalService;
	@Autowired
	private ClassHdrDao classHdrDao;
	@Autowired
	private FileDao fileDao;
	@Autowired
	private UserDao userDao;

	@Override
	public ClassHdrResDto getById(final Long id) {
		final Optional<ClassHdr> query = classHdrDao.getById(id);
		final ClassHdr result = query.get();
		final ClassHdrDataDto row = new ClassHdrDataDto();
		row.setId(result.getId());
		row.setCode(result.getCode());
		row.setSubject(result.getSubject());
		row.setDescription(result.getDescription());
		if(result.getPhoto() != null) {
			row.setFileId(result.getPhoto().getId());
			row.setFileCode(result.getPhoto().getCode());
			row.setFileExt(result.getPhoto().getExt());
		}
		row.setEmail(result.getInstructor().getEmail());
		row.setFullname(result.getInstructor().getFullname());
		row.setVer(result.getVer());
		row.setIsActive(result.getIsActive());
		final ClassHdrResDto data = new ClassHdrResDto();
		data.setData(row);
		return data;
	}

	@Override
	public ClassHdrListResDto getAll() {
		final List<ClassHdr> query = classHdrDao.getAll();
		final List<ClassHdrDataDto> rows = new ArrayList<>();
		for (int i = 0; i<query.size(); i++) {
			final ClassHdr result = query.get(i);
			final ClassHdrDataDto row = new ClassHdrDataDto();
			row.setId(result.getId());
			row.setCode(result.getCode());
			row.setSubject(result.getSubject());
			row.setDescription(result.getDescription());
			if(result.getPhoto() != null) {
				row.setFileId(result.getPhoto().getId());
				row.setFileCode(result.getPhoto().getCode());
				row.setFileExt(result.getPhoto().getExt());
			}
			row.setEmail(result.getInstructor().getEmail());
			row.setFullname(result.getInstructor().getFullname());
			row.setVer(result.getVer());
			row.setIsActive(result.getIsActive());
			rows.add(row);
		}
		final ClassHdrListResDto data = new ClassHdrListResDto();
		data.setData(rows);
		return data;
	}
	
	@Transactional(rollbackOn = Exception.class)
	@Override
	public ClassHdrInsertResDto insert(final ClassHdrInsertReqDto data) {
		final String plainText = generateCodeService.generateDigit(10);
		final ClassHdr row = new ClassHdr();
		row.setCode(plainText);
		row.setSubject(data.getSubject());
		row.setDescription(data.getDescription());
		final Optional<User> query = userDao.getById(data.getInstructorId());
		row.setInstructor(query.get());
		File photo = new File();
		photo.setCode(data.getFileCode());
		photo.setExt(data.getFileExt());
		photo.setCreatedBy(principalService.getPrincipal().getId());
		photo = fileDao.insert(photo);
		row.setPhoto(photo);
		row.setCreatedBy(principalService.getPrincipal().getId());
		final ClassHdr result = classHdrDao.insert(row);
		final ClassHdrInsertDataResDto dto = new ClassHdrInsertDataResDto();
		dto.setId(result.getId());
		final ClassHdrInsertResDto res = new ClassHdrInsertResDto();
		res.setData(dto);
		res.setMessage(ResponseConst.CREATED.getResponse());
		return res;
	}

	@Override
	public ClassHdrListResDto getAllIdInstr(final Long id) {
		final List<ClassHdr> query = classHdrDao.getAllIdInstr(id);
		final List<ClassHdrDataDto> rows = new ArrayList<>();
		for (int i = 0; i<query.size(); i++) {
			final ClassHdr result = query.get(i);
			final ClassHdrDataDto row = new ClassHdrDataDto();
			row.setId(result.getId());
			row.setCode(result.getCode());
			row.setSubject(result.getSubject());
			row.setDescription(result.getDescription());
			if(result.getPhoto() != null) {
				row.setFileId(result.getPhoto().getId());
				row.setFileCode(result.getPhoto().getCode());
				row.setFileExt(result.getPhoto().getExt());
			}
			row.setEmail(result.getInstructor().getEmail());
			row.setFullname(result.getInstructor().getFullname());
			row.setVer(result.getVer());
			row.setIsActive(result.getIsActive());
			rows.add(row);
		}
		final ClassHdrListResDto data = new ClassHdrListResDto();
		data.setData(rows);
		return data;
	}
	
	@Override
	public ClassHdrResDto getByIdInstrIdClass(final Long idInstr, final Long idClass) {
		final Optional<ClassHdr> query = classHdrDao.getByIdInstrIdClass(idInstr, idClass);
		final ClassHdr result = query.get();
		final ClassHdrDataDto row = new ClassHdrDataDto();
		row.setId(result.getId());
		row.setCode(result.getCode());
		row.setSubject(result.getSubject());
		row.setDescription(result.getDescription());
		if(result.getPhoto() != null) {
			row.setFileId(result.getPhoto().getId());
			row.setFileCode(result.getPhoto().getCode());
			row.setFileExt(result.getPhoto().getExt());
		}
		row.setEmail(result.getInstructor().getEmail());
		row.setFullname(result.getInstructor().getFullname());
		row.setVer(result.getVer());
		row.setIsActive(result.getIsActive());
		final ClassHdrResDto data = new ClassHdrResDto();
		data.setData(row);
		return data;
	}

}
