package com.lawencon.elearn.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearn.dao.RoleDao;
import com.lawencon.elearn.dto.role.RoleDataDto;
import com.lawencon.elearn.dto.role.RoleListResDto;
import com.lawencon.elearn.dto.role.RoleResDto;
import com.lawencon.elearn.model.Role;
import com.lawencon.elearn.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleDao roleDao;

	@Override
	public RoleResDto getById(final Long id) {
		final Optional<Role> query = roleDao.getById(id);
		final Role result = query.get();
		final RoleDataDto row = new RoleDataDto();
		row.setId(result.getId());
		row.setRoleCode(result.getCode());
		row.setRoleName(result.getName());
		row.setVer(result.getVer());
		final RoleResDto data = new RoleResDto();
		data.setData(row);
		return data;
	}

	@Override
	public RoleListResDto getAll() {
		final List<Role> query = roleDao.getAll();
		final List<RoleDataDto> rows = new ArrayList<>();
		for (int i = 0; i<query.size(); i++) {
			final Role result = query.get(i);
			final RoleDataDto row = new RoleDataDto();
			row.setId(result.getId());
			row.setRoleCode(result.getCode());
			row.setRoleName(result.getName());
			row.setVer(result.getVer());
			rows.add(row);
		}
		final RoleListResDto data = new RoleListResDto();
		data.setData(rows);
		return data;
	}

}
