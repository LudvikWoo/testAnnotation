package com.guoyasoft.student.entities;

import com.guoyasoft.student.annotation.Column;
import com.guoyasoft.student.annotation.Table;

@Table(name="student")
//student类对应的是数据库的student表
public class Student {
	//id字段对应的是student表的sno字段，该字段的类型是varchar2，哈哈哈哈，骗你的
	@Column(name="sno",type="varchar2")
	private String id;

	@Column(name="sname")
	private String name;

	@Column(name="age",type="number")
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", age=" + age + "]";
	}

}
