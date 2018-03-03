package com.guoyasoft.testNG.annotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestNGSvc04 {
	public static void dealTestNg(Class c) throws Exception {
		// 先实例化
		Object obj = c.newInstance();

		Method[] methods = c.getDeclaredMethods();
		List<Method> beforelist = new ArrayList<Method>();
		List<Method> testlist = new ArrayList<Method>();
		List<Method> afterlist = new ArrayList<Method>();
		for (Method m : methods) {
			if (m.getAnnotation(BeforeTest.class) != null) {
				beforelist.add(m);
			} else if (m.getAnnotation(Test.class) != null) {
				testlist.add(m);
			} else if (m.getAnnotation(AfterTest.class) != null) {
				afterlist.add(m);
			} else {
				// 3个注解都没有，舍弃不要
			}
		}

		// 1. 先执行标注了beforetest的方法
		Collections.sort(beforelist, new Comparator<Method>() {
			public int compare(Method m1, Method m2) {
				int p1 = m1.getAnnotation(BeforeTest.class).priority();
				int p2 = m1.getAnnotation(BeforeTest.class).priority();
				return p2 - p1;
			}
		});
		for (Method m : beforelist) {
			BeforeTest before = m.getAnnotation(BeforeTest.class);
			if (before != null) {
				// 实现循环
				for (int i = 0; i < before.loop(); i++) {
					m.invoke(obj);
					System.out.println(c.getName()+"."+m.getName()+"()");
				}
			}
		}
		// 2. 先执行标注了test的方法
		Collections.sort(testlist, new Comparator<Method>() {
			public int compare(Method m1, Method m2) {
				int p1 = m1.getAnnotation(Test.class).priority();
				int p2 = m1.getAnnotation(Test.class).priority();
				return p2 - p1;
			}
		});
		for (Method m : testlist) {
			Test test = m.getAnnotation(Test.class);
			if (test != null) {
				// 实现循环
				for (int i = 0; i < test.loop(); i++) {
					m.invoke(obj);
					System.out.println(c.getName()+"."+m.getName()+"()");

				}
			}
		}
		// 3. 先执行标注了after的方法
		Collections.sort(afterlist, new Comparator<Method>() {
			public int compare(Method m1, Method m2) {
				int p1 = m1.getAnnotation(AfterTest.class).priority();
				int p2 = m1.getAnnotation(AfterTest.class).priority();
				return p2 - p1;
			}
		});
		for (Method m : afterlist) {
			AfterTest after = m.getAnnotation(AfterTest.class);
			if (after != null) {
				// 实现循环
				for (int i = 0; i < after.loop(); i++) {
					m.invoke(obj);
					System.out.println(c.getName()+"."+m.getName()+"()");

				}
			}
		}
	}

}