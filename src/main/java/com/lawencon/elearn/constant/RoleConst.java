package com.lawencon.elearn.constant;

public enum RoleConst {
	SUPERADMIN("ROL001", "Super Admin"), INSTRUCTOR("ROL002", "Pengajar"),
	STUDENT("ROL003", "Siswa"), SYSTEM("ROL004", "System");

	private final String roleCodeEnum;
	private final String roleNameEnum;
	
	RoleConst(final String roleCodeEnum, final String roleNameEnum) {
		this.roleCodeEnum = roleCodeEnum;
		this.roleNameEnum = roleNameEnum;
		}

	public String getRoleCodeEnum() {
		return this.roleCodeEnum;
	}

	public String getRoleNameEnum() {
		return this.roleNameEnum;
	}
}
