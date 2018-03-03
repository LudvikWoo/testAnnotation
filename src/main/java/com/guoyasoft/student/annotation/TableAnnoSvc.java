package com.guoyasoft.student.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableAnnoSvc {
	public static String getSelectSql(Object obj) throws Exception {
		StringBuilder sql = new StringBuilder();
		Table table = obj.getClass().getAnnotation(Table.class);
		if (table != null) {
			sql.append("select * from " + table.name() + " t where 1=1 ");
		}
		List<Field> fields = getAllFields(obj.getClass());
		for (Field f : fields) {
			Column c = f.getAnnotation(Column.class);
			if (c != null) {
				String cname = c.name();
				String ctype = c.type();
				String methodName = "get"
						+ f.getName().substring(0, 1).toUpperCase()
						+ f.getName().substring(1);
				Method m = obj.getClass().getMethod(methodName);
				String value = m.invoke(obj) + "";
				if ("number".equalsIgnoreCase(ctype)) {
					sql.append(" and " + cname + "=" + value);
				} else if ("varchar2".equalsIgnoreCase(ctype)) {
					sql.append(" and " + cname + " like " + "'%" + value
							+ "%'");
				}
			}
		}
		return sql.toString();
	}

	public static String getInsertSql(Object obj) throws Exception {

		StringBuilder sql = new StringBuilder();
		StringBuilder columnStr = new StringBuilder();
		StringBuilder valueStr = new StringBuilder();
		Table table = obj.getClass().getAnnotation(Table.class);
		if (table != null) {

			List<Field> fields = getAllFields(obj.getClass());
			for (Field f : fields) {
				Column c = f.getAnnotation(Column.class);
				if (c != null) {
					String cname = c.name();
					String ctype = c.type();
					String methodName = "get"
							+ f.getName().substring(0, 1).toUpperCase()
							+ f.getName().substring(1);
					Method m = obj.getClass().getMethod(methodName);
					String value = m.invoke(obj) + "";
					if ("number".equalsIgnoreCase(ctype)) {
						columnStr.append(cname + ",");
						valueStr.append(value + ",");
					} else if ("varchar2".equalsIgnoreCase(ctype)) {
						columnStr.append(cname + ",");
						valueStr.append("'"+value + "',");
					}
				}
			}
			sql.append("insert into " + table.name() + " ( ");
			sql.append(columnStr.toString().substring(0,columnStr.length()-1));
			sql.append("）values ( ");
			sql.append(valueStr.toString().substring(0,valueStr.length()-1));
			sql.append("） ");
		}
		return sql.toString();
	}

	public static String getUpadteSql(Object obj)throws Exception{
		StringBuilder sql = new StringBuilder();
		StringBuilder columnStr = new StringBuilder();
		Table table = obj.getClass().getAnnotation(Table.class);
		if (table != null) {

			List<Field> fields = getAllFields(obj.getClass());
			for (Field f : fields) {
				Column c = f.getAnnotation(Column.class);
				if (c != null) {
					String cname = c.name();
					String ctype = c.type();
					String methodName = "get"
							+ f.getName().substring(0, 1).toUpperCase()
							+ f.getName().substring(1);
					Method m = obj.getClass().getMethod(methodName);
					String value = m.invoke(obj) + "";
					if ("number".equalsIgnoreCase(ctype)) {
						columnStr.append(cname + "="+value+" ,");
					} else if ("varchar2".equalsIgnoreCase(ctype)) {
						columnStr.append(cname + "='"+value+"' ,");
					}
				}
			}
			sql.append("update  " + table.name() + " set  ");
			sql.append(columnStr.toString().substring(0,columnStr.length()-1));
		}
		return sql.toString();
	}

	public static String getDeleteSql(Object obj) throws Exception{
		StringBuilder sql = new StringBuilder();
		StringBuilder columnStr = new StringBuilder();
		Table table = obj.getClass().getAnnotation(Table.class);
		if (table != null) {
			List<Field> fields = getAllFields(obj.getClass());
			for (Field f : fields) {
				Column c = f.getAnnotation(Column.class);
				if (c != null) {
					String cname = c.name();
					String ctype = c.type();
					String methodName = "get"
							+ f.getName().substring(0, 1).toUpperCase()
							+ f.getName().substring(1);
					Method m = obj.getClass().getMethod(methodName);
					String value = m.invoke(obj) + "";
					if ("number".equalsIgnoreCase(ctype)) {
						columnStr.append(" and "+ cname + "="+value);
					} else if ("varchar2".equalsIgnoreCase(ctype)) {
						columnStr.append(" and "+ cname + "= '"+value+"'");
					}
				}
			}
			sql.append("delete  " + table.name() + " where 1=1   ");
			sql.append(columnStr.toString());
		}
		return sql.toString();
	}

	public static List<Field> getAllFields(Class page) {
		List<Field> list = new ArrayList<Field>();
		Class tempClass = page;
		while (tempClass != null) {// 当父类为null的时候说明到达了最上层的父类(Object类).
			list.addAll(Arrays.asList(tempClass.getDeclaredFields()));
			tempClass = tempClass.getSuperclass(); // 得到父类,然后赋给自己
		}
		return list;
	}
}
