package com.guoyasoft.testNG.annotations;

import java.lang.reflect.Method;

public class TestNGSvc01 {
	public static void dealTestNg(Class c) throws Exception{
		//先实例化
		Object obj=c.newInstance();
		
		Method[] methods=c.getDeclaredMethods();		
		
		//1. 先执行标注了beforetest的方法
		for(Method m:methods){
			BeforeTest before=m.getAnnotation(BeforeTest.class);
			if(before !=null){
				m.invoke(obj);
			}
		}
		//2. 先执行标注了test的方法
		for(Method m:methods){
			Test test=m.getAnnotation(Test.class);
			if(test !=null){
				m.invoke(obj);
			}
		}
		//3. 先执行标注了after的方法
		for(Method m:methods){
			AfterTest after=m.getAnnotation(AfterTest.class);
			if(after !=null){
				m.invoke(obj);
			}
		}
	}
}