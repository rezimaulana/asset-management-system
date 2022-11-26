package com.lawencon.elearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="roles",  uniqueConstraints = {
		@UniqueConstraint(
				name = "roles_ck",
				columnNames = {"role_code", "role_name"}
		)
})
public class Role extends BaseModel{
	@Column(name = "role_code", nullable=false, length=10, unique=true)
	private String code;
	@Column(name = "role_name", nullable=false, length=20)
	private String name;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
