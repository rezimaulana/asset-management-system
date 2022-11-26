package com.lawencon.elearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="files")
public class File extends BaseModel{
	@Column(name = "file_code", nullable = false)
	private String code;
	@Column(name = "file_ext", nullable = false)
	private String ext;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
}
