package com.guoyasoft.student.entities;

import com.guoyasoft.student.annotation.Column;
import com.guoyasoft.student.annotation.Table;

@Table(name="course")
public class Course {
	@Column(name="cno")
	private String cno;
	@Column(name="cname")
	private String name;
	@Column(name="tno")
	private String tno;
	
	
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	
}
