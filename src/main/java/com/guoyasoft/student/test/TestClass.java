package com.guoyasoft.student.test;

import java.lang.reflect.Field;

import com.guoyasoft.student.annotation.Column;
import com.guoyasoft.student.annotation.Table;

public class TestClass {
	public static void main(String[] args) throws Exception {
		// Class c=Student.class;
		// Student s=new Student();
		// Class c1=s.getClass();
		Class c = Class.forName("com.guoyasoft.student.entities.Student");

		System.out.println(c.getName());
		System.out.println(c.getPackage());
		Table table = (Table) c.getAnnotation(Table.class);
		System.out.println(table.name());
		c.getFields();
		Field name = c.getDeclaredField("name");
		System.out.println("修饰符：" + name.getModifiers() + "，类型："
				+ name.getType() + ",名字：" + name.getName() + ",注解："
				+ name.getAnnotation(Column.class).name());
	}
}
