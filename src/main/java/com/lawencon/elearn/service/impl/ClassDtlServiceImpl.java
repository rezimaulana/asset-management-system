package com.lawencon.elearn.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearn.constant.ResponseConst;
import com.lawencon.elearn.dao.ClassDtlDao;
import com.lawencon.elearn.dao.ClassHdrDao;
import com.lawencon.elearn.dao.UserDao;
import com.lawencon.elearn.dto.classdtl.ClassDtlDataDto;
import com.lawencon.elearn.dto.classdtl.ClassDtlDataResDto;
import com.lawencon.elearn.dto.classdtl.ClassDtlInsertReqDto;
import com.lawencon.elearn.dto.classdtl.ClassDtlInsertResDto;
import com.lawencon.elearn.dto.classdtl.ClassDtlListResDto;
import com.lawencon.elearn.dto.classdtl.ClassDtlResDto;
import com.lawencon.elearn.model.ClassDtl;
import com.lawencon.elearn.model.ClassHdr;
import com.lawencon.elearn.model.User;
import com.lawencon.elearn.service.ClassDtlService;
import com.lawencon.elearn.service.PrincipalService;

@Service
public class ClassDtlServiceImpl implements ClassDtlService{
	@Autowired
	private PrincipalService principalService;
	@Autowired
	private ClassDtlDao classDtlDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private ClassHdrDao classHdrDao;

	@Override
	public ClassDtlListResDto getAllIdStudent(final Long id) {
		final List<ClassDtl> query = classDtlDao.getAllIdStudent(id);
		final List<ClassDtlDataDto> rows = new ArrayList<>();
		for (int i = 0; i<query.size(); i++) {
			final ClassDtl result = query.get(i);
			final ClassDtlDataDto row = new ClassDtlDataDto();
			row.setId(result.getId());
			row.setClassesId(result.getClassHdr().getId());
			row.setClassesCode(result.getClassHdr().getCode());
			row.setClassesSubject(result.getClassHdr().getSubject());
			row.setClassesDescription(result.getClassHdr().getDescription());
			row.setInstructorId(result.getClassHdr().getInstructor().getId());
			row.setEmail(result.getClassHdr().getInstructor().getEmail());
			row.setFullname(result.getClassHdr().getInstructor().getFullname());
			row.setVer(result.getVer());
			row.setIsActive(result.getIsActive());
			if (result.getClassHdr().getPhoto()!=null) {
				row.setFileId(result.getClassHdr().getPhoto().getId());				
			}
			rows.add(row);
		}
		final ClassDtlListResDto data = new ClassDtlListResDto();
		data.setData(rows);
		return data;
	}
	
	@Transactional(rollbackOn = Exception.class)
	@Override
	public ClassDtlInsertResDto insert(final ClassDtlInsertReqDto data) {
		final ClassDtl row = new ClassDtl();
		final Optional<ClassHdr> classHdr = classHdrDao.getById(data.getClassesId());
		row.setClassHdr(classHdr.get());
		final Optional<User> user = userDao.getById(principalService.getPrincipal().getId());
		row.setStudent(user.get());
		row.setCreatedBy(principalService.getPrincipal().getId());
		final ClassDtl result = classDtlDao.insert(row);
		final ClassDtlDataResDto dto = new ClassDtlDataResDto();
		dto.setId(result.getId());
		final ClassDtlInsertResDto res = new ClassDtlInsertResDto();
		res.setData(dto);
		res.setMessage(ResponseConst.CREATED.getResponse());
		return res;
	}

	@Override
	public ClassDtlResDto getByIdStudentIdClass(final Long id) {
		final Optional<ClassDtl> query = classDtlDao.getByIdStudentIdClass(id);
		final ClassDtl result = query.get();
		final ClassDtlDataDto row = new ClassDtlDataDto();
		row.setId(result.getId());
		row.setClassesId(result.getClassHdr().getId());
		row.setClassesCode(result.getClassHdr().getCode());
		row.setClassesSubject(result.getClassHdr().getSubject());
		row.setClassesDescription(result.getClassHdr().getDescription());
		row.setInstructorId(result.getClassHdr().getInstructor().getId());
		row.setEmail(result.getClassHdr().getInstructor().getEmail());
		row.setFullname(result.getClassHdr().getInstructor().getFullname());
		row.setVer(result.getVer());
		row.setIsActive(result.getIsActive());
		if (result.getClassHdr().getPhoto()!=null) {
			row.setFileId(result.getClassHdr().getPhoto().getId());				
		}
		final ClassDtlResDto data = new ClassDtlResDto();
		data.setData(row);
		return data;
	}

	@Override
	public ClassDtlResDto getById(final Long id) {
		final Optional<ClassDtl> query = classDtlDao.getByIdStudentIdClass(id);
		final ClassDtl result = query.get();
		final ClassDtlDataDto row = new ClassDtlDataDto();
		row.setId(result.getId());
		row.setClassesId(result.getClassHdr().getId());
		row.setClassesCode(result.getClassHdr().getCode());
		row.setClassesSubject(result.getClassHdr().getSubject());
		row.setClassesDescription(result.getClassHdr().getDescription());
		row.setInstructorId(result.getClassHdr().getInstructor().getId());
		row.setEmail(result.getClassHdr().getInstructor().getEmail());
		row.setFullname(result.getClassHdr().getInstructor().getFullname());
		row.setVer(result.getVer());
		row.setIsActive(result.getIsActive());
		if (result.getClassHdr().getPhoto()!=null) {
			row.setFileId(result.getClassHdr().getPhoto().getId());				
		}
		final ClassDtlResDto data = new ClassDtlResDto();
		data.setData(row);
		return data;
	}
}
