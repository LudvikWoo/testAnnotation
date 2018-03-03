package com.guoyasoft.student.test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import com.guoyasoft.student.annotation.Table;
import com.guoyasoft.student.annotation.TableAnnoSvc;
import com.guoyasoft.student.entities.Course;
import com.guoyasoft.student.entities.Student;

public class Test {
	public static void main(String[] args) throws Exception {
		Student s = new Student();
		s.setAge(23);
		s.setId("s1111");
		s.setName("guoya");
		
		Course c=new Course();
		c.setCno("C001");
		c.setName("语文");
		c.setTno("T001");

		System.out.println(TableAnnoSvc.getUpadteSql(c));
		
		
//		String select = TableAnnoSvc.getSelectSql(s);
//		System.out.println(select);
//		String update = TableAnnoSvc.getUpadteSql(s);
//		System.out.println(update);
//		String delete = TableAnnoSvc.getDeleteSql(s);
//		System.out.println(delete);
//		String insert = TableAnnoSvc.getInsertSql(s);
//		System.out.println(insert);
		

	}
}
