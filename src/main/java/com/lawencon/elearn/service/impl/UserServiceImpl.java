package com.lawencon.elearn.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lawencon.elearn.constant.ResponseConst;
import com.lawencon.elearn.constant.RoleConst;
import com.lawencon.elearn.dao.RoleDao;
import com.lawencon.elearn.dao.UserDao;
import com.lawencon.elearn.dto.user.UserDataDto;
import com.lawencon.elearn.dto.user.UserInsertDataResDto;
import com.lawencon.elearn.dto.user.UserInsertReqDto;
import com.lawencon.elearn.dto.user.UserInsertResDto;
import com.lawencon.elearn.dto.user.UserListResDto;
import com.lawencon.elearn.dto.user.UserResDto;
import com.lawencon.elearn.model.Role;
import com.lawencon.elearn.model.User;
import com.lawencon.elearn.pojo.SendEmailPojo;
import com.lawencon.elearn.service.GenerateCodeService;
import com.lawencon.elearn.service.JavaMailService;
import com.lawencon.elearn.service.PrincipalService;
import com.lawencon.elearn.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{
	@Autowired
	private GenerateCodeService generateCodeService;
	@Autowired
	private JavaMailService mailService;
	@Autowired
	private PrincipalService principalService;
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private PasswordEncoder passwordEncode;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optional = userDao.getByEmail(username);
		if(optional.isPresent()) {
			return new org.springframework.security.core
					.userdetails.User(username, optional.get().getPassword(), new ArrayList<>());
		}
		throw new UsernameNotFoundException("Wrong Email or Password");
	}
	
	@Override
	public Optional<User> getByEmail(final String email) {
		return userDao.getByEmail(email);
	}
	
	
	@Override
	public UserListResDto getAll() {
		final List<User> query = userDao.getAll();
		final List<UserDataDto> rows = new ArrayList<>();
		for (int i = 0; i<query.size(); i++) {
			final User result = query.get(i);
			final UserDataDto row = new UserDataDto();
			row.setId(result.getId());
			row.setEmail(result.getEmail());
			row.setFullname(result.getFullname());
			row.setRoleCode(result.getRole().getCode());
			row.setRoleName(result.getRole().getName());
			if(result.getPhoto() != null) {
				row.setFileCode(result.getPhoto().getCode());
				row.setFileExt(result.getPhoto().getExt());
			}
			row.setVer(result.getVer());
			rows.add(row);
		}
		final UserListResDto data = new UserListResDto();
		data.setData(rows);
		return data;
	}

	@Override
	public UserResDto getById(final Long id) {
		final Optional<User> query = userDao.getById(id);
		final User result = query.get();
		final UserDataDto row = new UserDataDto();
		row.setId(result.getId());
		row.setEmail(result.getEmail());
		row.setFullname(result.getFullname());
		row.setRoleCode(result.getRole().getCode());
		row.setRoleName(result.getRole().getName());
		if(result.getPhoto() != null) {
			row.setFileCode(result.getPhoto().getCode());
			row.setFileExt(result.getPhoto().getExt());
		}
		row.setVer(result.getVer());
		final UserResDto data = new UserResDto();
		data.setData(row);
		return data;
	}
	
	@Transactional(rollbackOn = Exception.class)
	@Override
	public UserInsertResDto insertInstructor(UserInsertReqDto data) {
		final String plainText = generateCodeService.generateDigit(5);
		final String hash = passwordEncode.encode(plainText);
		final User row = new User();
		row.setEmail(data.getEmail());
		row.setFullname(data.getFullname());
		row.setPassword(hash);
		final Optional<Role> roles = roleDao.getByCode(RoleConst.INSTRUCTOR.getRoleCodeEnum());
		row.setRole(roles.get());
		row.setCreatedBy(principalService.getPrincipal().getId());
		final User result = userDao.insert(row);
		final UserInsertDataResDto dto = new UserInsertDataResDto();
		dto.setId(result.getId());
		final SendEmailPojo emailPojo = new SendEmailPojo();
        emailPojo.setEmail(data.getEmail());
        emailPojo.setSubject("Registrasi Anda Berhasil");
        emailPojo.setBody("Email : "+data.getEmail()+"\nPassword anda : " + plainText);
        Runnable r = () -> mailService.sendEmail(emailPojo);
		Thread t = new Thread(r);
		t.start();
		final UserInsertResDto res = new UserInsertResDto();
		res.setData(dto);
		res.setMessage(ResponseConst.CREATED.getResponse());
		return res;
	}
	
	@Transactional(rollbackOn = Exception.class)
	@Override
	public UserInsertResDto insertStudent(UserInsertReqDto data) {
		final String plainText = generateCodeService.generateDigit(5);
		final String hash = passwordEncode.encode(plainText);
		final User row = new User();
		row.setEmail(data.getEmail());
		row.setFullname(data.getFullname());
		row.setPassword(hash);
		final Optional<Role> roles = roleDao.getByCode(RoleConst.STUDENT.getRoleCodeEnum());
		row.setRole(roles.get());
		row.setCreatedBy(principalService.getPrincipal().getId());
		final User result = userDao.insert(row);
		final UserInsertDataResDto dto = new UserInsertDataResDto();
		dto.setId(result.getId());
		final SendEmailPojo emailPojo = new SendEmailPojo();
        emailPojo.setEmail(data.getEmail());
        emailPojo.setSubject("Registrasi Anda Berhasil");
        emailPojo.setBody("Email : "+data.getEmail()+"\nPassword anda : " + plainText);
        mailService.sendEmail(emailPojo);
		final UserInsertResDto res = new UserInsertResDto();
		res.setData(dto);
		res.setMessage(ResponseConst.CREATED.getResponse());
		return res;
	}
	
}
